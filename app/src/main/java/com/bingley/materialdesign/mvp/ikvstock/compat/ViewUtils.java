package com.bingley.materialdesign.mvp.ikvstock.compat;

import android.content.Context;
import android.util.AttributeSet;

import com.bingley.materialdesign.mvp.ikvstock.entry.SizeColor;

/**
   *
   * Author:  Mr.bingley
   * Version:
   * Date:  2017/5/11
   */

public class ViewUtils {
    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dpTopx(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int pxTodp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


    /**
     * 初始化 SizeColor
     */
    public static SizeColor getSizeColor(Context context, AttributeSet attrs, int defStyleAttr) {

        return null;
    }



}
