package com.bingley.materialdesign.mvp.stock;

import android.graphics.Color;
import android.graphics.PointF;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseFragment;
import com.bingley.materialdesign.mvp.stock.entity.DataParse;
import com.bingley.materialdesign.mvp.stock.mychart.MyBarChart;
import com.bingley.materialdesign.mvp.stock.mychart.MyLineChart;
import com.bingley.materialdesign.mvp.stock.mychart.MyXAxis;
import com.bingley.materialdesign.mvp.stock.mychart.MyYAxis;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.List;

import butterknife.Bind;

/**
 * Created by SAM on 2017/2/27.
 */

public class MyMinutFragment extends BaseFragment {
    @Bind(R.id.line_chart)
    MyLineChart lineChart;
    @Bind(R.id.bar_chart)
    MyBarChart barChart;
    @Bind(R.id.green_value)
    TextView mGreenValue;
    @Bind(R.id.yello_value)
    TextView mYelloValue;

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
        getOffLineData();
    }


    private void initChart() {
        lineChart.setScaleEnabled(false);
        lineChart.setDrawBorders(true);
        lineChart.setBorderWidth(1);
        lineChart.setBorderColor(getResources().getColor(R.color.minute_grayLine));
        lineChart.setDescription("");
        lineChart.setDescriptionColor(Color.rgb(277, 135, 0));
        lineChart.setHighlightPerTapEnabled(true);

        Legend lineChartLegend = lineChart.getLegend();
        lineChartLegend.setEnabled(false);

        barChart.setScaleEnabled(false);
    }

    private void getOffLineData() {
        //
        // 调皮的
       /* buy stop, buy limit及sell stop, sell limit 在使用MT4等主流交易软件下单时，新手总会不明白buy stop, buy
        limit及sell stop, sell limit，那么到底这几个下单模式是什么意思，又有什么作用呢？Buy stop：止损买进，
        即是指在相对与目前现价而言高于现价的价格挂单的买进操作指令 例子：Buy stop是一个追涨的行为，比如现在EURUSD是1 .4321，你觉得只有向上突破了1 .4400，
        才能确定升势，并进一步上扬，那么你可以使用Buy stop：1.4410，那么当EURUSD上升到1 .4410，你的买单才会成交，如果继续上扬，你将会盈利。buy limit：
        限价买进，即是指相对现价而言，低于现价的价格挂单的买进的操作指令 例子：buy limit是设定为以更低的价格买入（做多），和股票的挂单方式是一样的；比如现在EURUSD是1
        .4321，你觉得趋势仍然是向上的，但是价格会回调到1 .4300，然后还会继续上涨，则你需要使用buy limit：1.4300，当价格回落到1 .4300，你的买单将会成交，
        如果价格上扬，你将会盈利。sell stop：止损卖出，即是指相对现价而言，低于现价的价格挂单的卖出操作指令 例子：sell stop是一个杀跌的行为，比如现在EURUSD是1
        .4321，你觉得只有向下突破了1 .4300，才能确定跌势，并进一步下跌，那么你可以使用sell stop：1.4290，那么当EURUSD下跌到1 .4290，你的卖单才会成交，
        如果继续下跌，你将会盈利。sell limit：限价卖出，即是指相对现价而言，高于现价的价格挂单的卖出操作指令 例子：sell limit是设定为以更高的价格卖出（做空）；
        比如现在EURUSD是1 .4321，你觉得趋势仍然是向下的，但是价格会反弹到1 .4350，然后还会继续下跌，则你需要使用sell limit：1.4350，当价格上涨到1
        .4350，你的卖单将会成交，如果价格下跌，你将会盈利。由以上解析我们可以得到，buy stop, buy limit及sell stop, sell
        limit是在目前汇价没达到你入场要求时，你为你的单子设定的入场条件，达到给条件后，单子会自动成交的一种智能方便的下单方式。*/
        lineChart.setScaleEnabled(false);
        lineChart.setDrawBorders(true);
        lineChart.setBorderWidth(1);
        lineChart.setBorderColor(getResources().getColor(R.color.minute_grayLine));
        lineChart.setDescription("");
    }


}
