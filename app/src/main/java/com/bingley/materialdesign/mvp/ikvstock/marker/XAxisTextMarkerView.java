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

public class XAxisTextMarkerView implements IMarkerView {
     private RectF mContentRect;
     private AbstractReader mRender;

     @Override
    public void onInitMarkerView(RectF contentRect, AbstractReader render) {
         mContentRect = contentRect;
         mRender = render;

     }

    @Override
    public void onDrawMarkerView(Canvas canvas, float highlightPointX, float highlightPointY) {

    }
}
