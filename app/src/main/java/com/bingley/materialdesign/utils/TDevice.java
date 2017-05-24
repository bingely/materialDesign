package com.bingley.materialdesign.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.bingley.materialdesign.AppContext;
import com.bingley.materialdesign.base.BaseApplication;

/**
 * 1 dp/sp转换为px工具类 (有公式换算方法，有系统TypedValue）
 * 2 获得屏幕尺寸
 * 3 网络检测及检测wifi是否打开
 * 4 软键盘收缩（貌似还有更好的方法TODO）
 * 5 得到版本号，名字
 * 6 调用系统安装了的应用分享
 * Author:  Mr.bingley
 * Version:
 * Date:  2016/12/21
 */

public class TDevice {

    // 手机网络类型
    public static final int NETTYPE_WIFI = 0x01;
    public static final int NETTYPE_CMWAP = 0x02;
    public static final int NETTYPE_CMNET = 0x03;
    /**
     * 根据分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dp2px(float dpValue) {
        final float scale = BaseApplication.context().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dp(float pxValue) {
        final float scale = BaseApplication.context().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue
     * @return
     */
    public static int px2sp(float pxValue) {
        final float fontScale = BaseApplication.context().getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue
     * @return
     */
    public static int sp2px(float spValue) {
        final float fontScale = BaseApplication.context().getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }


   /* public static int dp2px(Context context, int dp) {
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics()));
    }*/

    /**
     * 获取屏幕相关参数
     *
     *
     * @param context context
     * @return DisplayMetrics 屏幕宽高
     */
    public static DisplayMetrics getScreenSize(Context context) {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) context.getSystemService(
                Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        display.getMetrics(metrics);
        return metrics;
    }

    /**
     * 获取屏幕density
     *
     * @param context context
     * @return density 屏幕density（密度）
     */
    public static float getDeviceDensity(Context context) {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) context.getSystemService(
                Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metrics);
        return metrics.density;
    }


    /**
     * 是否有网络
     * @return
     */
    public static boolean hasInternet() {
        ConnectivityManager cm = (ConnectivityManager) BaseApplication.context()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        return info != null && info.isAvailable() && info.isConnected();
    }

    /**
     * 检测wifi是否打开
     * @return
     */
    public static boolean isWifiOpen() {
        ConnectivityManager cm = (ConnectivityManager) BaseApplication
                .context().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info == null) return false;
        if (!info.isAvailable() || !info.isConnected()) return false;
        if (info.getType() != ConnectivityManager.TYPE_WIFI) return false;
        return true;
    }

    /**
     * 检查移动网络是否连接
     * @param context
     * @return
     */
    public static boolean isMobileDataConnected(Context context){
        if (context != null){
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = manager.getActiveNetworkInfo();
            if (info != null){
                if (info.getType() == ConnectivityManager.TYPE_MOBILE)
                    return true;
            }
        }
        return false;
    }


    /**
     * 软键盘隐藏
     * @param view
     */
    public static void hideSoftKeyboard(View view) {
        if (view == null) return;
        View mFocusView = view;

        Context context = view.getContext();
        if (context != null && context instanceof Activity) {
            Activity activity = ((Activity) context);
            mFocusView = activity.getCurrentFocus();
        }
        if (mFocusView == null) return;
        mFocusView.clearFocus();
        InputMethodManager manager = (InputMethodManager) mFocusView.getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        manager.hideSoftInputFromWindow(mFocusView.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * 软键盘显示
     * @param view
     */
    public static void showSoftKeyboard(View view) {
        if (view == null) return;
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        if (!view.isFocused()) view.requestFocus();

        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(view, 0);
    }

    /**
     * 以下两个个方法分别为得到版本号，名字
     * @return
     */
    public static int getVersionCode() {
        return getVersionCode(BaseApplication.context().getPackageName());
    }

    public static int getVersionCode(String packageName) {
        try {
            return BaseApplication.context()
                    .getPackageManager()
                    .getPackageInfo(packageName, 0)
                    .versionCode;
        } catch (PackageManager.NameNotFoundException ex) {
            return 0;
        }
    }

    public static String getVersionName() {
        try {
            return BaseApplication
                    .context()
                    .getPackageManager()
                    .getPackageInfo(BaseApplication.context().getPackageName(), 0)
                    .versionName;
        } catch (PackageManager.NameNotFoundException ex) {
            return "undefined version name";
        }
    }


    /**
     * 调用系统安装了的应用分享
     *
     * @param context
     * @param title
     * @param url
     */
    public static void showSystemShareOption(Activity context,
                                             final String title, final String url) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "分享：" + title);
        intent.putExtra(Intent.EXTRA_TEXT, title + " " + url);
        context.startActivity(Intent.createChooser(intent, "选择分享"));
    }


    /**
     * 获取当前网络类型
     *
     * @return 0：没有网络 1：WIFI网络 2：WAP网络 3：NET网络
     */
    public static int getNetworkType() {
        int netType = 0;
        ConnectivityManager connectivityManager = (ConnectivityManager) AppContext
                .getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null) {
            return netType;
        }
        int nType = networkInfo.getType();
        if (nType == ConnectivityManager.TYPE_MOBILE) {
            String extraInfo = networkInfo.getExtraInfo();
            if (!StringUtils.isEmpty(extraInfo)) {
                if (extraInfo.toLowerCase().equals("cmnet")) {
                    netType = NETTYPE_CMNET;
                } else {
                    netType = NETTYPE_CMWAP;
                }
            }
        } else if (nType == ConnectivityManager.TYPE_WIFI) {
            netType = NETTYPE_WIFI;
        }
        return netType;
    }
}
