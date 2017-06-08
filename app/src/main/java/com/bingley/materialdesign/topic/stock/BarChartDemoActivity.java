package com.bingley.materialdesign.topic.stock;


import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseActivity;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class BarChartDemoActivity extends BaseActivity {
    BarChart mChart;

    @Override
    protected int getContentView() {
        return R.layout.activity_bar_chart_demo;
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        mChart = (BarChart) findViewById(R.id.chart);

     /* 使用 setData 的方法設定 LineData 物件 */
        mChart.setData(getBarData());

        mChart.setDescription("");
        mChart.setBorderColor(ColorTemplate.PASTEL_COLORS[0]);
        mChart.setDrawGridBackground(false);

        // 設定其他樣式
        setupXAxis();
        setupYAxis();
        setupLegend();
        setupAnimation();

        mChart.invalidate();
        mChart.notifyDataSetChanged();
    }

    private void setupAnimation() {

    }

    private void setupLegend() {
    }

    private void setupYAxis() {

    }

    private void setupXAxis() {
        XAxis mXaxis = mChart.getXAxis();
        mXaxis.setPosition(XAxis.XAxisPosition.BOTTOM);
    }

    private List<BarEntry> getCharData(int count, int ratio) {
        List<BarEntry> chartData = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            chartData.add(new BarEntry((i + 1) * ratio, i));
        }
        return chartData;
    }

    private List<String> getLabels(int count) {
        List<String> chartLabels = new ArrayList<>();
        for (int i= 0;i<count;i++) {
            chartLabels.add("S" + i);
        }
        return chartLabels;
    }

    private BarData getBarData() {
        final int DATA_COUNT = 5;

        BarDataSet dataSetA = new BarDataSet(getCharData(DATA_COUNT, 1), "Apple");
        BarDataSet dataSetB = new BarDataSet(getCharData(DATA_COUNT, 2), "Banana");
        BarDataSet dataSetC = new BarDataSet(getCharData(DATA_COUNT, 3), "CCLemon");

        dataSetA.setColor(ColorTemplate.JOYFUL_COLORS[0]);
        dataSetB.setColor(ColorTemplate.JOYFUL_COLORS[1]);
        dataSetC.setColor(ColorTemplate.JOYFUL_COLORS[3]);

        List<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(dataSetA);
        dataSets.add(dataSetB);
        dataSets.add(dataSetC);

        BarData data = new BarData(getLabels(DATA_COUNT), dataSets);
        return data;
    }
}
