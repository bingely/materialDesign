package com.bingley.materialdesign.topic.stock.mychart;

import android.util.SparseArray;

import com.github.mikephil.charting.components.XAxis;

/**
 * author：ajiang
 * mail：1025065158@qq.com
 * blog：http://blog.csdn.net/qqyanjiang
 */


/**
 * 怎么才能让中间显示11:30/13:00呢？
 */
public class MyXAxis extends XAxis {
    private SparseArray<String> labels;
    public SparseArray<String> getXLabels() {
        return labels;
    }
    public void setXLabels(SparseArray<String> labels) {
        this.labels = labels;
    }
}
