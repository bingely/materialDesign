package com.bingley.materialdesign.utils;

import android.util.Log;

/**
 * 日志util
 * Author:  Mr.bingley
 * Version:
 * Date:  2017/1/12
 */

/**
 * how to use?
 * 应该先在application中设置相关属性
 * private final static String TAG = "NewsJsonUtils";
 * LogUtils.d(TAG, url);
 */

public class LogUtils {
    public static final boolean DEBUG = true;

    public static void v(String tag, String message) {
        if (DEBUG) {
            Log.v(tag, message);
        }
    }

    public static void d(String tag, String message) {
        if (DEBUG) {
            Log.d(tag, message);
        }
    }

    public static void i(String tag, String message) {
        if (DEBUG) {
            Log.i(tag, message);
        }
    }

    public static void w(String tag, String message) {
        if (DEBUG) {
            Log.w(tag, message);
        }
    }

    public static void e(String tag, String message) {
        if (DEBUG) {
            Log.e(tag, message);
        }
    }

    public static void e(String tag, String message, Exception e) {
        if (DEBUG) {
            Log.e(tag, message, e);
        }
    }
}
