package com.bingley.materialdesign.utils;

import android.os.Handler;

 /**
   * 线程工具 （可以让子线程主线程相互工作了）
   * Author:  Mr.bingley
   * Version:
   * Date:  2017/4/8
   */
/**
 *
 * 使用帮助  1
 ThreadUtil.runInUIThread(new Runnable() {
        @Override
        public void run() {
        mRefreshLayout.endLoadingMore();
        dismissLoadingDialog();
        mAdapter.addMoreData(response.body());
}
}, MainActivity.LOADING_DURATION);


  2  这个是一个view调用延时的操作
 findViewById(R.id.app_start_view).postDelayed(new Runnable() {
    @Override
    public void run() {
    redirectTo();
    }
}, 100);
 *
 */
public class ThreadUtil {
    private static Handler sHandler = new Handler();

    private ThreadUtil() {
    }

    /**
     * 在子线程执行任务
     *
     * @param task
     */
    public static void runInThread(Runnable task) {
        new Thread(task).start();
    }

    /**
     * 在UI线程执行任务
     *
     * @param task
     */
    public static void runInUIThread(Runnable task) {
        sHandler.post(task);
    }

    /**
     * 在UI线程延时执行任务
     *
     * @param task
     * @param delayMillis 延时时间，单位毫秒
     */
    public static void runInUIThread(Runnable task, long delayMillis) {
        sHandler.postDelayed(task, delayMillis);
    }
}