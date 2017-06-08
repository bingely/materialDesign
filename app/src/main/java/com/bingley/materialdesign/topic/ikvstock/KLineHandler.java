package com.bingley.materialdesign.topic.ikvstock;

import android.view.MotionEvent;

import com.bingley.materialdesign.topic.ikvstock.entry.Entry;

/**
   *
   * Author:  Mr.bingley
   * Version:
   * Date:  2017/5/9
   */

public interface KLineHandler {
    void onLeftRefresh();

    void onRightRefresh();

    void onSingleTap(MotionEvent e, float x, float y);

    void onDoubleTap(MotionEvent e, float x, float y);

    void onHighlight(Entry entry, int entryIndex, float x, float y);

    void onCancelHighlight();
}
