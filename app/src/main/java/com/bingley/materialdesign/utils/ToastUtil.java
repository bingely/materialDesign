package com.bingley.materialdesign.utils;

import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.Toast;

import com.bingley.materialdesign.AppContext;


/**
 * 如何做toast会覆盖原来的  (OK)
 */
public class ToastUtil {
    private static Toast toast;

    private ToastUtil() {
    }

    /**
     * 将toast封装起来，连续点击时可以覆盖上一个
     */
    public static void show(CharSequence text) {
        if (!TextUtils.isEmpty(text)) {
            if (toast == null) {
                if (text.length() < 10) {
                    toast = Toast.makeText(AppContext.getInstance(), text, Toast.LENGTH_SHORT);
                } else {
                    toast = Toast.makeText(AppContext.getInstance(), text, Toast.LENGTH_LONG);
                }
            } else {
                toast.setText(text);
            }
            toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, TDevice.dp2px(2));
            toast.show();
        }
    }

    /**
     *
     * @param resId 表示你要使用  R.string.(resId) 的形式
     */
    public static void show(@StringRes int resId) {
        show(AppContext.getInstance().getString(resId));
    }

}