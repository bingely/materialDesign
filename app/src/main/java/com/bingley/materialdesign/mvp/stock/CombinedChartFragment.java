package com.bingley.materialdesign.mvp.stock;

import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseFragment;
import com.bingley.materialdesign.mvp.stock.entity.Model;
import com.bingley.materialdesign.mvp.stock.entity.StockListBean;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleDataSet;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * $Description:$
 * Author:  Mr.bingley
 * Version:
 * Date:  2017/2/27
 */

public class CombinedChartFragment extends BaseFragment {
    private String TAG = "qqq";
    private CombinedChart mChart;
    private Button btn;
    private int itemcount;
    private LineData lineData;
    private CandleData candleData;
    private CombinedData combinedData;
    private ArrayList<String> xVals;
    private List<CandleEntry> candleEntries = new ArrayList<>();
    private int colorHomeBg;
    private int colorLine;
    private int colorText;
    private int colorMa5;
    private int colorMa10;
    private int colorMa20;

    @Override
    protected int getLayoutId() {
        return R.layout.frg_combine;
    }


    @Override
    protected void initWidget(View root) {
        super.initWidget(root);
        mChart = (CombinedChart) root.findViewById(R.id.chart);
        initChart();
        loadChartData();
    }

    private void loadChartData() {

    }

    private void initChart() {


    }


}
