package com.bingley.materialdesign.mvp.osc;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseSwipebackActivity;
import com.bingley.materialdesign.utils.TDevice;

/**
 * 我想实现点击下面某个模块会刷新界面功能
 * 当点击某个按钮的时候，直接回到首页
 * Author:  Mr.bingley
 * Version:
 * Date:  2016/12/22
 */

public class OscMainActivity extends BaseSwipebackActivity {
    private View mPopupView;
    private PopupWindow mPopupWindow;


    @Override
    protected int getContentView() {
        return R.layout.act_osc_main;
    }

    @Override
    protected void initWidget() {
        super.initWidget();
       mPopupView = findView(R.id.ll_pop);
        final TextView view = findView(R.id.pop);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupShow(view);
            }
        });
    }

    /**
     * 显示popup window
     * @param view
     */
    private void popupShow(View view) {

        int density = (int) TDevice.getDeviceDensity(this);
        // 显示popup window
        mPopupWindow = new PopupWindow(mPopupView,
                200 * density, 50 * density);
        mPopupWindow.setFocusable(true);
        mPopupWindow.setOutsideTouchable(true);
        // 透明背景
        Drawable transpent = new ColorDrawable(Color.TRANSPARENT);
        mPopupWindow.setBackgroundDrawable(transpent);
        // 获取位置
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        mPopupWindow.showAtLocation(
                view,
                Gravity.NO_GRAVITY,
                location[0] - 40 * density,
                location[1] + 30 * density);

    }

}
