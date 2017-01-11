package com.bingley.materialdesign.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ExpandableListView;

/**
 * <br/> Description: 用于scrollview并且item 的textview可以多行
 * <br/> Author:  chencaisheng
 * <br/> Version: 1.0
 * <br/> Date:  2016/9/28 0028 下午 2:14
 */
public class NoScrollExplandListView extends ExpandableListView {

    public NoScrollExplandListView(Context context) {
        super(context);
    }

    public NoScrollExplandListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoScrollExplandListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);  
    }  
  
    @Override  
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {  
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);  
        super.onMeasure(widthMeasureSpec, expandSpec);  
    }  
  
}  