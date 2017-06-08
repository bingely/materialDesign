package com.bingley.materialdesign.topic.pullreflsh.jdong;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bingley.materialdesign.R;

import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;

/**
 * 下拉刷新header
 * Author:  Mr.bingley
 * Version:
 * Date:  2016/12/21
 */

public class JdRefreshHeader extends FrameLayout implements PtrUIHandler {
    /**
     * 提醒文本
     */
    private TextView mTvRemind;

    /**
     * 快递员logo
     */
    private ImageView mIvMan;

    /**
     * 商品logo
     */
    private ImageView mIvGoods;

    /**
     * 状态识别
     */
    private int mState;

    /**
     * 重置
     * 准备刷新
     * 开始刷新
     * 结束刷新
     */
    public static final int STATE_RESET = -1;
    public static final int STATE_PREPARE = 0;
    public static final int STATE_BEGIN = 1;
    public static final int STATE_FINISH = 2;

    public static final int MARGIN_RIGHT = 100;

    /**
     * 动画
     */
    private AnimationDrawable mAnimation;


    public JdRefreshHeader(Context context) {
        super(context);
        initView();
    }

    public JdRefreshHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public JdRefreshHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.jd_refresh_header_view, this, false);
        mTvRemind = (TextView) view.findViewById(R.id.tv_remain);
        mIvMan = (ImageView) view.findViewById(R.id.iv_man);
        mIvGoods = (ImageView) view.findViewById(R.id.iv_goods);
        addView(view);
    }

    @Override
    public void onUIReset(PtrFrameLayout frame) {
        mState = STATE_RESET;
    }

    @Override
    public void onUIRefreshPrepare(PtrFrameLayout frame) {
        mState = STATE_PREPARE;
    }

    @Override
    public void onUIRefreshBegin(PtrFrameLayout frame) {
        mState = STATE_BEGIN;
        //隐藏商品logo,开启跑步动画
        mIvGoods.setVisibility(View.GONE);
        mIvMan.setBackgroundResource(R.drawable.runningman);
        mAnimation = (AnimationDrawable) mIvMan.getBackground();

        if (!mAnimation.isRunning()) {
            mAnimation.start();
        }

    }

    @Override
    public void onUIRefreshComplete(PtrFrameLayout frame) {
        mState = STATE_FINISH;
        mIvGoods.setVisibility(View.VISIBLE);
        //停止动画
        if (mAnimation.isRunning()) {
            mAnimation.stop();
        }
        mIvMan.setBackgroundResource(R.mipmap.a2a);
    }

    @Override
    public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator) {
        switch (mState) {
            case STATE_PREPARE:
                // logo
                mIvMan.setAlpha(ptrIndicator.getCurrentPercent());
                mIvGoods.setAlpha(ptrIndicator.getCurrentPercent());

                FrameLayout.LayoutParams mIvanLayoutParams = (LayoutParams) mIvMan.getLayoutParams();

                // 此处小于1是什么意思
                float mCurrentPercent = ptrIndicator.getCurrentPercent();
                if (mCurrentPercent <= 1) {
                    mIvMan.setScaleX(mCurrentPercent);
                    mIvMan.setScaleY(mCurrentPercent);
                    mIvGoods.setScaleX(mCurrentPercent);
                    mIvGoods.setScaleY(mCurrentPercent);
                    int marginRight = (int) (MARGIN_RIGHT - MARGIN_RIGHT * mCurrentPercent);
                    mIvanLayoutParams.setMargins(0, 0, marginRight, 0);
                    mIvMan.setLayoutParams(mIvanLayoutParams);
                }

                if (mCurrentPercent < 1.2) {
                    mTvRemind.setText("下拉刷新");
                } else {
                    mTvRemind.setText("松开加载");
                }

                break;
            case STATE_BEGIN:
                mTvRemind.setText("更新中...");
                break;
            case STATE_FINISH:
                mTvRemind.setText("加载完成...");
                break;
        }
    }
}
