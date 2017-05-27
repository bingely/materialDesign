package com.bingley.materialdesign.mvp.ikvstock.marker;

import android.graphics.Canvas;
import android.graphics.RectF;

import com.thoughtworks.xstream.io.AbstractReader;

/**
   * 
   * Author:  Mr.bingley
   * Version: 
   * Date:  2017/5/25
   */

public interface IMarkerView {

    /**
     * 初始化 MarkerView
     *
     * @param contentRect 视图区域
     * @param render render
     */
    void onInitMarkerView(RectF contentRect, AbstractReader render);

    /**
     * onDrawMarkerView
     *
     * @param canvas canvas
     * @param highlightPointX 高亮中心坐标 x
     * @param highlightPointY 高亮中心坐标 y
     */
    void onDrawMarkerView(Canvas canvas, float highlightPointX, float highlightPointY);
}
