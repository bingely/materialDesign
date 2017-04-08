package com.bingley.materialdesign.utils;

import android.support.annotation.StringRes;
import android.widget.Toast;

import com.bingley.materialdesign.AppContext;


/**
 * 如何做toast会覆盖原来的  (OK)
 */
public class ToastUtil {
    public static Toast mToast;
    private ToastUtil() {
    }

    /**
     * 将toast封装起来，连续点击时可以覆盖上一个
     */
    public static void show(CharSequence text) {
        if (mToast == null) {
            if (text.length() < 10) {
                mToast = Toast.makeText(AppContext.getInstance(), text, Toast.LENGTH_SHORT);
            } else {
                mToast = Toast.makeText(AppContext.getInstance(), text, Toast.LENGTH_LONG);
            }
        }else {
            mToast.setText(text);
        }
        mToast.show();
    }

    /**
     *
     * @param resId 表示你要使用  R.string.(resId) 的形式
     */
    public static void show(@StringRes int resId) {
        show(AppContext.getInstance().getString(resId));
    }

}