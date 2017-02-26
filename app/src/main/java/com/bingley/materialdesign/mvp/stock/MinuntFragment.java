package com.bingley.materialdesign.mvp.stock;

import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.Toast;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseFragment;
import com.bingley.materialdesign.mvp.stock.bean.DataParse;
import com.bingley.materialdesign.mvp.stock.bean.MinutesBean;
import com.bingley.materialdesign.mvp.stock.mychart.MyBarChart;
import com.bingley.materialdesign.mvp.stock.mychart.MyBottomMarkerView;
import com.bingley.materialdesign.mvp.stock.mychart.MyLeftMarkerView;
import com.bingley.materialdesign.mvp.stock.mychart.MyLineChart;
import com.bingley.materialdesign.mvp.stock.mychart.MyRightMarkerView;
import com.bingley.materialdesign.mvp.stock.mychart.MyXAxis;
import com.bingley.materialdesign.mvp.stock.mychart.MyYAxis;
import com.bingley.materialdesign.mvp.stock.utils.MyUtils;
import com.bingley.materialdesign.mvp.stock.utils.VolFormatter;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.YAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import rx.Subscription;

 /**
   * $Description:$
   * Author:  Mr.bingley
   * Version: 
   * Date:  2017/2/24
   */
 // 如何获得得平均线值


public class MinuntFragment extends BaseFragment{
    @Bind(R.id.line_chart)
    MyLineChart lineChart;
    @Bind(R.id.bar_chart)
    MyBarChart barChart;

    private LineDataSet d1, d2;
    MyXAxis xAxisLine;
    MyYAxis axisRightLine;
    MyYAxis axisLeftLine;
    BarDataSet barDataSet;

    MyXAxis xAxisBar;
    MyYAxis axisLeftBar;
    MyYAxis axisRightBar;
    SparseArray<String> stringSparseArray;
    private DataParse mData;
    Integer sum = 0;
    List<Integer> listA, listB;
    @Override
    protected int getLayoutId() {
        return R.layout.frag_minute;
    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);
        initChart();
        stringSparseArray = setXLabels();
        getOffLineData();


        // 此处的作用就是让上下两个图数据就行联动
        lineChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
//                barChart.setHighlightValue(new Highlight(h.getXIndex(), 0));

                // 比如说如果触摸lineChart，barChart也会引起变化
                barChart.highlightValue(new Highlight(h.getXIndex(), 0));
                Toast.makeText(getActivity(),String.valueOf(e.getVal()),0).show();

                // lineChart.setHighlightValue(h);
            }

            @Override
            public void onNothingSelected() {
                barChart.highlightValue(null);
            }
        });
        barChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
                lineChart.highlightValue(new Highlight(h.getXIndex(), 0));
                // lineChart.setHighlightValue(new Highlight(h.getXIndex(), 0));//此函数已经返回highlightBValues的变量，并且刷新，故上面方法可以注释
                //barChart.setHighlightValue(h);
            }

            @Override
            public void onNothingSelected() {
                lineChart.highlightValue(null);
            }
        });
    }

    private void initChart() {
        /**
         * lineChart
         */
        lineChart.setScaleEnabled(false);
        lineChart.setDrawBorders(true);   //设置图表内 格子外的边框是否显示
        lineChart.setBorderWidth(1);
        lineChart.setBorderColor(getResources().getColor(R.color.minute_grayLine));
        // 为什么设置之后下角没有出现名字---因为默认字体时黑色的
        // 如何改变文字的位置
        lineChart.setDescription("");  // 图表默认右下方的描述
        lineChart.setDescriptionColor(Color.rgb(227, 135, 0));  //上面字的颜色，参数是Color对象
        lineChart.setHighlightPerDragEnabled(true);//能否拖拽高亮线(数据点与坐标的提示线)，默认是true

        // 设置比例图标示，就是那个一组y的value的  ,表现就是底下的小正方形
        Legend lineChartLegend = lineChart.getLegend();
        lineChartLegend.setEnabled(false);

        /**
         * barChart
         */
        barChart.setScaleEnabled(false);
        barChart.setDrawBorders(true);
        barChart.setBorderWidth(1);
        barChart.setBorderColor(getResources().getColor(R.color.minute_grayLine));
        barChart.setDescription("");
        barChart.setHighlightPerDragEnabled(true);
        Legend barChartLegend = barChart.getLegend();
        barChartLegend.setEnabled(false);


        /**
         * x轴
         */
        xAxisLine = lineChart.getXAxis();

        //        The Axis 坐标轴相关的,XY轴通用
        xAxisLine.setEnabled(true);     //是否显示X坐标轴 及 对应的刻度竖线，默认是true
        xAxisLine.setDrawAxisLine(true); //是否绘制坐标轴的线，即含有坐标的那条线，默认是true
        xAxisLine.setDrawGridLines(true); //是否显示X坐标轴上的刻度竖线，默认是true
        xAxisLine.setDrawLabels(true); //是否显示X坐标轴上的刻度，默认是true


        //      X轴专用
        // 注释部分，为什么我设置之后没什么效果  TODO
        /*xAxisLine.setLabelsToSkip(1);    //设置坐标相隔多少，参数是int类型
        xAxisLine.resetLabelsToSkip();   //将自动计算坐标相隔多少
        xAxisLine.setAvoidFirstLastClipping(true);
        xAxisLine.setSpaceBetweenLabels(4);*/
        xAxisLine.setPosition(XAxis.XAxisPosition.BOTTOM);//把坐标轴放在上下 参数有：TOP, BOTTOM, BOTH_SIDED, TOP_INSIDE or BOTTOM_INSIDE.

        // 为什么显示不了刻度?TODO
        xAxisLine.setTextColor(Color.rgb(145, 13, 64)); //X轴上的刻度的颜色
        xAxisLine.setTextSize(10); //X轴上的刻度的字的大小 单位dp
        //      xAxis.setTypeface(Typeface tf); //X轴上的刻度的字体
        xAxisLine.setDrawGridLines(true);
        xAxisLine.setGridColor(Color.rgb(227, 135, 0)); //X轴上的刻度竖线的颜色
        xAxisLine.setGridLineWidth(1); //X轴上的刻度竖线的宽 float类型
        xAxisLine.enableGridDashedLine(40, 3, 0); //虚线表示X轴上的刻度竖线(float lineLength, float spaceLength, float phase)三个参数，1.线长，2.虚线间距，3.虚线开始坐标


        /**
         * y轴
         */
        //左边y
        axisLeftLine = lineChart.getAxisLeft();



       /* axisLeftLine.setStartAtZero(false);    //设置Y轴坐标是否从0开始
        axisLeftLine.setAxisMaxValue(50);    //设置Y轴坐标最大为多少
        axisLeftLine.resetAxisMaxValue();    //重新设置Y轴坐标最大为多少，自动调整
        axisLeftLine.setAxisMinValue(10);    //设置Y轴坐标最小为多少
        axisLeftLine.resetAxisMinValue();    //重新设置Y轴坐标，自动调整
        axisLeftLine.setInverted(false);    //Y轴坐标反转,默认是false,即下小上大
        axisLeftLine.setSpaceTop(0);    //Y轴坐标距顶有多少距离，即留白
        axisLeftLine.setSpaceBottom(0);    //Y轴坐标距底有多少距离，即留白
        axisLeftLine.setShowOnlyMinMax(false);    //参数如果为true Y轴坐标只显示最大值和最小值
        axisLeftLine.setLabelCount(10, false);    //第一个参数是Y轴坐标的个数，第二个参数是 是否不均匀分布，true是不均匀分布
        axisLeftLine.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);  //参数是INSIDE_CHART(Y轴坐标在内部) 或 OUTSIDE_CHART(在外部（默认是这个）)  */


        /*折线图y轴左没有basevalue，调用系统的*/
        axisLeftLine.setLabelCount(5, true); //第一个参数是Y轴坐标的个数，第二个参数是 是否不均匀分布，true是不均匀分布
        axisLeftLine.setDrawLabels(true);
        axisLeftLine.setDrawGridLines(false);
        /*轴不显示 避免和border冲突*/
        axisLeftLine.setDrawAxisLine(false);
        //y轴样式
        this.axisLeftLine.setValueFormatter(new YAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, YAxis yAxis) {
                DecimalFormat mFormat = new DecimalFormat("#0.00");
                return mFormat.format(value);
            }
        });

        //右边y
        axisRightLine = lineChart.getAxisRight();
        axisRightLine.setLabelCount(2, true);
        axisRightLine.setDrawLabels(true);
        axisRightLine.setValueFormatter(new YAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, YAxis yAxis) {
                DecimalFormat mFormat = new DecimalFormat("#0.00%");
                return mFormat.format(value);
            }
        });

        axisRightLine.setStartAtZero(false);
        axisRightLine.setDrawGridLines(false);
        axisRightLine.setDrawAxisLine(false);


        /**
         * 背景线  (横坐标竖坐标线的颜色）
         */
        xAxisLine.setGridColor(getResources().getColor(R.color.minute_grayLine));
        xAxisLine.setAxisLineColor(getResources().getColor(R.color.minute_grayLine));
        xAxisLine.setTextColor(getResources().getColor(R.color.minute_zhoutv));
        axisLeftLine.setGridColor(getResources().getColor(R.color.minute_grayLine));
        axisLeftLine.setTextColor(getResources().getColor(R.color.minute_zhoutv));
        axisRightLine.setAxisLineColor(getResources().getColor(R.color.minute_grayLine));
        axisRightLine.setTextColor(getResources().getColor(R.color.minute_zhoutv));

        /**
         * bar x y轴  条形图  （分析思路与上面类似）
         */
        xAxisBar = barChart.getXAxis();
        xAxisBar.setDrawLabels(false);
        xAxisBar.setDrawGridLines(true);
        xAxisBar.setDrawAxisLine(false);
        // xAxisBar.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxisBar.setGridColor(getResources().getColor(R.color.minute_grayLine));
        //
        axisLeftBar = barChart.getAxisLeft();
        axisLeftBar.setAxisMinValue(0);
        axisLeftBar.setDrawGridLines(false);
        axisLeftBar.setDrawAxisLine(false);
        axisLeftBar.setTextColor(getResources().getColor(R.color.minute_zhoutv));

        //
        axisRightBar = barChart.getAxisRight();
        axisRightBar.setDrawLabels(false);
        axisRightBar.setDrawGridLines(false);
        axisRightBar.setDrawAxisLine(false);


    }


    private void getOffLineData() {
        /*方便测试，加入假数据*/
        mData = new DataParse();
        JSONObject object = null;
        try {
            object = new JSONObject(ConstantTest.MINUTESURL);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mData.parseMinutes(object);
        setData(mData);
        // 那如何自定义动画？ TODO
        lineChart.animateX(1000); // 立即执行的动画,x轴
    }


    private SparseArray<String> setXLabels() {
        SparseArray<String> xLabels = new SparseArray<>();
        xLabels.put(0, "09:30");
        xLabels.put(60, "10:30");
        xLabels.put(121, "11:30/13:00");
        xLabels.put(182, "14:00");
        xLabels.put(241, "15:00");
        return xLabels;
    }


    /**
     * 设置数据
     * @param mData
     */
    private void setData(DataParse mData) {
        // 设置左右两边的数据
        setMarkerView(mData);
        // 填充x轴数据
        setShowLabels(stringSparseArray);
        Log.e("###", mData.getDatas().size() + "ee");
        if (mData.getDatas().size() == 0) {
            lineChart.setNoDataText("暂无数据");
            return;
        }
        //设置y左右两轴最大最小值
        axisLeftLine.setAxisMinValue(mData.getMin());
        axisLeftLine.setAxisMaxValue(mData.getMax());
        axisRightLine.setAxisMinValue(mData.getPercentMin());
        axisRightLine.setAxisMaxValue(mData.getPercentMax());

        // 设置下面部分柱形图的数据
        axisLeftBar.setAxisMaxValue(mData.getVolmax());
        /*单位*/
        String unit = MyUtils.getVolUnit(mData.getVolmax());
        int u = 1;
        if ("万手".equals(unit)) {
            u = 4;
        } else if ("亿手".equals(unit)) {
            u = 8;
        }
        /*次方*/
        axisLeftBar.setValueFormatter(new VolFormatter((int) Math.pow(10, u)));
        axisLeftBar.setShowMaxAndUnit(unit);
        axisLeftBar.setDrawLabels(true);
        //axisLeftBar.setAxisMinValue(0);//即使最小是不是0，也无碍
        axisLeftBar.setShowOnlyMinMax(true);
        axisRightBar.setAxisMaxValue(mData.getVolmax());
        //   axisRightBar.setAxisMinValue(mData.getVolmin);//即使最小是不是0，也无碍
        //axisRightBar.setShowOnlyMinMax(true);

        //基准线
        LimitLine ll = new LimitLine(0);
        ll.setLineWidth(1f);
        ll.setLineColor(getResources().getColor(R.color.minute_jizhun));
        ll.enableDashedLine(10f, 10f, 0f);
        ll.setLineWidth(1);
        axisRightLine.addLimitLine(ll);
        axisRightLine.setBaseValue(0);

        ArrayList<Entry> lineCJEntries = new ArrayList<>();
        ArrayList<Entry> lineJJEntries = new ArrayList<>();
        ArrayList<String> dateList = new ArrayList<>();
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        ArrayList<String> xVals = new ArrayList<>();
        Log.e("##", Integer.toString(xVals.size()));
        for (int i = 0, j = 0; i < mData.getDatas().size(); i++, j++) {
           /* //避免数据重复，skip也能正常显示
            if (mData.getDatas().get(i).time.equals("13:30")) {
                continue;
            }*/
            MinutesBean t = mData.getDatas().get(j);

            if (t == null) {
                lineCJEntries.add(new Entry(Float.NaN, i));
                lineJJEntries.add(new Entry(Float.NaN, i));
                barEntries.add(new BarEntry(Float.NaN, i));
                continue;
            }
            if (!TextUtils.isEmpty(stringSparseArray.get(i)) &&
                    stringSparseArray.get(i).contains("/")) {
                i++;
            }
            lineCJEntries.add(new Entry(mData.getDatas().get(i).cjprice, i));
            lineJJEntries.add(new Entry(mData.getDatas().get(i).avprice, i));
            barEntries.add(new BarEntry(mData.getDatas().get(i).cjnum, i));
            // dateList.add(mData.getDatas().get(i).time);
        }
        d1 = new LineDataSet(lineCJEntries, "成交价");
        d2 = new LineDataSet(lineJJEntries, "均价");
        d1.setDrawValues(false);
        d2.setDrawValues(false);
        barDataSet = new BarDataSet(barEntries, "成交量");

        d1.setCircleRadius(0);
        d2.setCircleRadius(0);
        d1.setColor(getResources().getColor(R.color.minute_blue));
        d2.setColor(getResources().getColor(R.color.minute_yellow));
        d1.setHighLightColor(Color.WHITE);
        d2.setHighlightEnabled(true);     // 如何获得选中的值呢？？？ 这个如果是true，那么d1就没效果了
        d1.setDrawFilled(true);


        barDataSet.setBarSpacePercent(50); //bar空隙
        barDataSet.setHighLightColor(Color.WHITE);
        barDataSet.setHighLightAlpha(255);
        barDataSet.setDrawValues(false);
        barDataSet.setHighlightEnabled(true);
        barDataSet.setColor(Color.RED);
        List<Integer> list=new ArrayList<>();
        list.add(Color.RED);
        list.add(Color.GREEN);
        barDataSet.setColors(list);
        //谁为基准
        d1.setAxisDependency(YAxis.AxisDependency.LEFT);
        // d2.setAxisDependency(YAxis.AxisDependency.RIGHT);
        ArrayList<ILineDataSet> sets = new ArrayList<>();
        sets.add(d1);
        sets.add(d2);
        /*注老版本LineData参数可以为空，最新版本会报错，修改进入ChartData加入if判断*/
        LineData cd = new LineData(getMinutesCount(), sets);
        lineChart.setData(cd);
        BarData barData = new BarData(getMinutesCount(), barDataSet);
        barChart.setData(barData);

       // setOffset();
        lineChart.invalidate();//刷新图
        barChart.invalidate();


    }

    public String[] getMinutesCount() {
        return new String[242];
    }

    public void setShowLabels(SparseArray<String> labels) {
        xAxisLine.setXLabels(labels);
        xAxisBar.setXLabels(labels);
    }

    /**
     * 设置左右两边的数据
     * @param mData
     */
    private void setMarkerView(DataParse mData) {
        MyLeftMarkerView leftMarkerView = new MyLeftMarkerView(getActivity(), R.layout.mymarkerview);
        MyRightMarkerView rightMarkerView = new MyRightMarkerView(getActivity(), R.layout.mymarkerview);
        MyBottomMarkerView bottomMarkerView = new MyBottomMarkerView(getActivity(), R.layout.mymarkerview);
        lineChart.setMarker(leftMarkerView, rightMarkerView,bottomMarkerView, mData);
        barChart.setMarker(leftMarkerView, rightMarkerView,bottomMarkerView, mData);
    }
}
