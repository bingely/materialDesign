package com.bingley.materialdesign.base;

import android.app.Application;
import android.content.Context;
import android.os.Build;

/**
 * Created by Administrator on 2017/1/19.
 */

public class BaseApplication extends Application {

    public static boolean release = true;//是否是正式环境

    static Context _context;

    private static boolean sIsAtLeastGB;

    static {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            sIsAtLeastGB = true;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        _context = getApplicationContext();
    }

    public static synchronized BaseApplication context() {
        return (BaseApplication) _context;
    }
}
