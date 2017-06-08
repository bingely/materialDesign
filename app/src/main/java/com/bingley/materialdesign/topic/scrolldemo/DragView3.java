package com.bingley.materialdesign.topic.scrolldemo;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class DragView3 extends View {

    private int lastX;
    private int lastY;

    public DragView3(Context context) {
        super(context);
        ininView();
    }

    public DragView3(Context context, AttributeSet attrs) {
        super(context, attrs);
        ininView();
    }

    public DragView3(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ininView();
    }

    private void ininView() {
        // 给View设置背景颜色，便于观察
        setBackgroundColor(Color.YELLOW);
    }

    // LayoutParams方式 （这种方式写出来的拖动感觉怪怪的）
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // 记录触摸点坐标
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                // 计算偏移量
                int offsetX = x - lastX;
                int offsetY = y - lastY;


                // 是在第一种的基础上演变的

                // 1 这种方式需要考虑父布局类型
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
                // 2 这种不需要，但是效果都是一样
                //ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
                layoutParams.leftMargin = getLeft()+offsetX;
                layoutParams.topMargin = getTop()+offsetY;

                setLayoutParams(layoutParams);
                /*// 在当前left、top、right、bottom的基础上加上偏移量
                layout(getLeft() + offsetX,
                        getTop() + offsetY,
                        getRight() + offsetX,
                        getBottom() + offsetY);

                *//**
                 // 等效于上面的layout方法
                 offsetLeftAndRight(offsetX);
                 offsetTopAndBottom(offsetY);
                 */

                break;
        }
        return true;
    }
}
