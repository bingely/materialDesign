package com.bingley.materialdesign.topic.customview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * 实现一种点击后刷新布局，左右放置的效果
 * Author:  Mr.bingley
 * Version:
 * Date:  2017/5/30
 */

// layout:  custom_layout.xml

public class CustomLayout extends ViewGroup {

    private boolean isRight = false;


    public CustomLayout(Context context) {
        super(context);
    }


    /**
     * 要进行书写，不然显示不出来
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        // 测量孩子
        measureChildren(0, 0);

        setMeasuredDimension(widthSize, heightSize);  // 还得重新设置下
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        // child.Layout();

        // 交错布局

        int parentWidth = getMeasuredWidth();

        int count = getChildCount();

        int tmpTop = 0;

        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);

            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();

            if (i % 2 == 0) {

                if (isRight) {
                    // 单数行

                    int left = 0;
                    int top = tmpTop;
                    int right = left + childWidth;   // 通过
                    int bottom = top + childHeight;

                    child.layout(left, top, right, bottom);
                } else {
                    // 双数行
                    int left = parentWidth - childWidth; // 父亲的宽度-孩子的宽度 == 左边的距离
                    int top = tmpTop;
                    int right = left + childWidth;
                    int bottom = top + childHeight;

                    child.layout(left, top, right, bottom);
                }

            } else {
                if (isRight) {
                    // 双数行
                    int left = parentWidth - childWidth;
                    int top = tmpTop;
                    int right = left + childWidth;
                    int bottom = top + childHeight;

                    child.layout(left, top, right, bottom);
                } else {
                    // 单数行

                    int left = 0;
                    int top = tmpTop;
                    int right = left + childWidth;
                    int bottom = top + childHeight;

                    child.layout(left, top, right, bottom);
                }
            }

            tmpTop += childHeight;

        }
    }

    public void switchShow()
    {
        isRight = !isRight;
        // invalidate();//刷新显示，draw()
        requestLayout();// 布局的刷新
    }
}
