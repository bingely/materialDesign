package com.bingley.materialdesign.topic.ikvstock.marker;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.bingley.materialdesign.topic.ikvstock.alilgn.YMarkerAlign;
import com.bingley.materialdesign.topic.ikvstock.entry.SizeColor;
import com.bingley.materialdesign.topic.ikvstock.render.AbstractReader;

import java.text.DecimalFormat;

/**
 * Author:  Mr.bingley
 * Version:
 * Date:  2017/6/14
 */

public class YAxisTextMarkerView implements IMarkerView {
    public static final String TAG = "YAxisTextMarkerView";

    private Paint markerTextPaint;
    private Paint marderBorderPaint;

    public final RectF contentRect = new RectF();
    private AbstractReader render;

    private final Paint.FontMetrics fontMetrics = new Paint.FontMetrics();
    private final DecimalFormat decimalFormatter = new DecimalFormat("0.00");
    private final float[] pointCache = new float[2];
    private final int height;
    private final RectF markerInsets = new RectF(0, 0, 0, 0);
    private float inset = 0;
    private YMarkerAlign yMarkerAlign;

    public YAxisTextMarkerView(int height) {
        this.height = height;
    }

    @Override
    public void onInitMarkerView(RectF contentRect, AbstractReader render) {
        this.contentRect.set(contentRect);
        this.render = render;
        final SizeColor sizeColor = render.getSizeColor();

        if (markerTextPaint == null) {
            markerTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            markerTextPaint.setTextAlign(Paint.Align.CENTER);
        }

        markerTextPaint.setColor(sizeColor.getMaTextColor());
        markerTextPaint.setTextSize(sizeColor.getMaTextSize());
        markerTextPaint.getFontMetrics(fontMetrics);

        if (marderBorderPaint == null) {
            marderBorderPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            marderBorderPaint.setStyle(Paint.Style.STROKE);
        }

        marderBorderPaint.setStrokeWidth(sizeColor.getMarkerBorderSize());
        marderBorderPaint.setColor(sizeColor.getMarkerBorderColor());
        inset = marderBorderPaint.getStrokeWidth() / 2;

        yMarkerAlign = sizeColor.getYMarkerAlign();

    }

    @Override
    public void onDrawMarkerView(Canvas canvas, float highlightPointX, float highlightPointY) {
    }
}
