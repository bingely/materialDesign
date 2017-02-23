package com.bingley.materialdesign.mvp.stock;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
   * $Description:$
   * Author:  Mr.bingley
   * Version: 
   * Date:  2017/2/22
   */

public class KLineView extends View{

    private Paint mPaint;

    public KLineView(Context context) {
        super(context);
        init();
    }



    public KLineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public KLineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        mPaint = new Paint();
        createTestData();
    }

    private void createTestData() {

    }
}
