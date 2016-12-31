package com.bingley.materialdesign.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 流式布局
 * Author:  Mr.bingley
 * Version:
 * Date:  2016/12/28
 */

public class FlowLayout extends ViewGroup {

    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 求取布局的宽高
     *
     * @param widthMeasureSpec  ----宽度的测量规格
     * @param heightMeasureSpec ---高度的测量规格
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int wideMode = MeasureSpec.getMode(widthMeasureSpec);
        int wideSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width = 0;
        int height = 0;

        int lineWidth = 0;
        int lineHeight = 0;

        int cCount = getChildCount();
        for (int i = 0; i < cCount; i++) {
            View child = getChildAt(i);
            int childHeight = child.getMeasuredHeight();
            int childWidth = child.getMeasuredWidth();
            MarginLayoutParams mp = (MarginLayoutParams) child.getLayoutParams();
            MarginLayoutParams layoutParams = (MarginLayoutParams) child.getLayoutParams();
            if (lineWidth + childWidth + childWidth + mp.leftMargin + mp.rightMargin > wideSize) {
                // 换行
                width = Math.max(width, lineWidth);
                height += lineHeight;

                lineWidth = childWidth + mp.leftMargin + mp.rightMargin;
                lineHeight = childHeight + mp.topMargin + mp.bottomMargin;
            } else {
                // no tab
                lineWidth += childWidth + mp.leftMargin + mp.rightMargin;
                lineHeight = Math.max(lineHeight, childHeight + mp.topMargin + mp.bottomMargin);
            }

            // figuther
            if (i == cCount - 1) {
                width = Math.max(width, lineWidth);
                height += lineHeight;
            }
        }

        setMeasuredDimension(wideMode == MeasureSpec.EXACTLY ? wideSize : width, heightMode == MeasureSpec.EXACTLY ? heightSize : height);
    }


    //每一行所包含的所有子view
    private List<List<View>> allViews = new ArrayList<>();

    private List<Integer> allHeights = new ArrayList<>();

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int width = getWidth();
        int childCount = getChildCount();

        int lineWidth = 0;
        int lineHeight = 0;

        List<View> lineViews = new ArrayList<>();

        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();
            MarginLayoutParams mp = (MarginLayoutParams) child.getLayoutParams();
            if (lineWidth + childWidth + mp.leftMargin + mp.rightMargin > width) {
                allViews.add(lineViews);
                allHeights.add(lineHeight);

                lineViews = new ArrayList<>();
                lineWidth = 0;
                lineHeight = childHeight + mp.topMargin + mp.bottomMargin;
            }

            lineWidth += childWidth + mp.leftMargin + mp.rightMargin;
            lineHeight = Math.max(lineHeight, childHeight + mp.topMargin + mp.bottomMargin);
            lineViews.add(child);

            if (i == childCount - 1) {
                allViews.add(lineViews);
                allHeights.add(lineHeight);
            }
        }


        //通过计算每一行的每一个子view的left,top,right,bottom,摆放每一行的每一个子view的位置
        int left = 0;
        int top = 0;

        for (int i = 0; i < allViews.size(); i++) {
            //allHeights.get()
        }
    }
}
