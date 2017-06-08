package com.bingley.materialdesign.topic.ikvstock.marker;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.bingley.materialdesign.topic.ikvstock.alilgn.XMarkerAlign;
import com.bingley.materialdesign.topic.ikvstock.entry.SizeColor;
import com.bingley.materialdesign.topic.ikvstock.render.AbstractReader;

/**
 * Author:  Mr.bingley
 * Version:
 * Date:  2017/5/25
 */

public class XAxisTextMarkerView implements IMarkerView {
    private static final String TAG = "XAxisTextMarkerView";

    private Paint markerTextPaint;
    private Paint markerBorderPaint;

    private final RectF contentRect = new RectF();
    private AbstractReader mRender;

    private final Paint.FontMetrics fontMetrics = new Paint.FontMetrics();       //在Canvas画图时计算字符的高度。
    private final int height;
    private final RectF markerInsets = new RectF(0, 0, 0, 0);
    private float inset = 0;
    private XMarkerAlign xMarkerAlign;

    public XAxisTextMarkerView(int height) {
        this.height = height;
    }

    @Override
    public void onInitMarkerView(RectF contentRect, AbstractReader render) {
        this.contentRect.set(contentRect);
        mRender = render;
        final SizeColor sizeColor = render.getSizeColor();

        if (markerTextPaint == null) {
            markerTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            markerTextPaint.setTextAlign(Paint.Align.CENTER);
        }

        markerTextPaint.setColor(sizeColor.getMarkerTextColor());
        markerTextPaint.setTextSize(sizeColor.getMaTextSize());
        markerTextPaint.getFontMetrics(fontMetrics);

        if (markerBorderPaint == null) {
            markerBorderPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            markerBorderPaint.setStyle(Paint.Style.STROKE);
        }

        markerBorderPaint.setStrokeWidth(sizeColor.getMarkerBorderSize());
        markerBorderPaint.setColor(sizeColor.getMarkerBorderColor());
        inset = markerBorderPaint.getStrokeWidth() / 2;

    }


    @Override
    public void onDrawMarkerView(Canvas canvas, float highlightPointX, float highlightPointY) {

    }
}
