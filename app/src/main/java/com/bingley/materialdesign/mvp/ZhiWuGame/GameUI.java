package com.bingley.materialdesign.mvp.ZhiWuGame;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * 深入了解SurfaceView等三大核心类.avi
 * Author:  Mr.bingley
 * Version:
 * Date:  2017/1/10
 */
public class GameUI extends SurfaceView implements SurfaceHolder.Callback {
    private RenderThread thread; // 停掉线程 控制线程的循环
    boolean flag;
    private SurfaceHolder holder;

    public GameUI(Context context) {
        super(context);
        holder = getHolder();
        holder.addCallback(this);
    }

    private class RenderThread extends Thread {
        @Override
        public void run() {

            while (flag) {
                //
                System.out.println("执行线程");
            }
        }
    }

    // 屏幕显示的时候调用
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        System.out.println("surfaceCreated");
        thread = new RenderThread();
        flag = true;
        thread.start();

    }

    // 屏幕发生变化的时候调用 可见-> 不可见 不可见->可见
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
        System.out.println("surfaceChanged");

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        System.out.println("surfaceDestroyed");
        flag = false;
    }
}
