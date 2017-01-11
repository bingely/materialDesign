package com.bingley.materialdesign.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;
/**
 * <br/> Description:  自适应
 * <br/> Author:  chencaisheng
 * <br/> Version: 1.0
 * <br/> Date:  2016/9/28 0028 上午 11:54
 */
public class MyGridView extends GridView {
        public MyGridView(Context context, AttributeSet attrs) {
            super(context, attrs); 
        } 
        public MyGridView(Context context) { 
            super(context); 
        } 
        public MyGridView(Context context, AttributeSet attrs, int defStyle) { 
            super(context, attrs, defStyle); 
        }     
        @Override 
        public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {      
            int expandSpec = MeasureSpec.makeMeasureSpec( 
                    Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST); 
            super.onMeasure(widthMeasureSpec, expandSpec); 
        } 
    } 