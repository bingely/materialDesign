package com.bingley.materialdesign.topic.elmssearch;

import android.animation.Animator;
import android.animation.ValueAnimator;
                                                                                                                                                    import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseSwipebackActivity;

/**
   * 在style.xml里面新增加一个透明的主题,为该acticity
   * Author:  Mr.bingley
   * Version:
   * Date:  2017/1/3
   */

public class ElemsSearchActivity extends BaseSwipebackActivity{
    private TextView mSearchBGTxt;
    private TextView mHintTxt;
    private TextView mSearchTxt;
    private FrameLayout mContentFrame;
    private ImageView mArrowImg;
    @Override
    protected int getContentView() {
        return R.layout.activity_ele_search;
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        mSearchBGTxt = (TextView) findViewById(R.id.tv_search_bg);
        mHintTxt = (TextView) findViewById(R.id.tv_hint);
        mContentFrame = (FrameLayout) findViewById(R.id.frame_content_bg);
        mSearchTxt = (TextView) findViewById(R.id.tv_search);
        mArrowImg = (ImageView) findViewById(R.id.iv_arrow);

        /*
        接下来动画只要交给ValueAnimator,在这里把搜索栏的背景单独抽成一个View，用来进行X缩放操作。所以现在要做的动画有：

        左侧箭头的Y轴平移动画。
        右侧搜索的Y轴平移动画。
        中间文字以及背景的Y轴平移动画。
        中间背景的X缩放动画。
        下部View内容的透明动画。
        */
        mSearchBGTxt.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                performEnterAnimation();
            }
        });

        mArrowImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performExitAnimation();
            }
        });
    }

     private void performEnterAnimation() {
         float originY = getIntent().getIntExtra("y", 0);

         int location[] = new int[2];
         mSearchBGTxt.getLocationOnScreen(location);

         final float translateY = originY - (float) location[1];

         //放到前一个页面的位置
         mSearchBGTxt.setY(mSearchBGTxt.getY() + translateY);
         mHintTxt.setY(mSearchBGTxt.getY() + (mSearchBGTxt.getHeight() - mHintTxt.getHeight()) / 2);
         mSearchTxt.setY(mSearchBGTxt.getY() + (mSearchBGTxt.getHeight() - mSearchTxt.getHeight()) / 2);
         final ValueAnimator translateVa = ValueAnimator.ofFloat(mSearchBGTxt.getY(), mSearchBGTxt.getY() - 100);
         translateVa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
             @Override
             public void onAnimationUpdate(ValueAnimator valueAnimator) {
                 mSearchBGTxt.setY((Float) valueAnimator.getAnimatedValue());

                 // 这个为什么是这样计算的，还有为什么我的中间文字不见了
                 mArrowImg.setY(mSearchBGTxt.getY() + (mSearchBGTxt.getHeight() - mArrowImg.getHeight()) / 2);
                 mHintTxt.setY(mSearchBGTxt.getY() + (mSearchBGTxt.getHeight() - mHintTxt.getHeight()) / 2);
                 mSearchTxt.setY(mSearchBGTxt.getY() + (mSearchBGTxt.getHeight() - mSearchTxt.getHeight()) / 2);
             }
         });

         ValueAnimator scaleVa = ValueAnimator.ofFloat(1, 0.8f);
         scaleVa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
             @Override
             public void onAnimationUpdate(ValueAnimator valueAnimator) {
                 mSearchBGTxt.setScaleX((Float) valueAnimator.getAnimatedValue());
             }
         });

         ValueAnimator alphaVa = ValueAnimator.ofFloat(0, 1f);
         alphaVa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
             @Override
             public void onAnimationUpdate(ValueAnimator valueAnimator) {
                 mContentFrame.setAlpha((Float) valueAnimator.getAnimatedValue());
                 mSearchTxt.setAlpha((Float) valueAnimator.getAnimatedValue());
                 mArrowImg.setAlpha((Float) valueAnimator.getAnimatedValue());
             }
         });

         alphaVa.setDuration(500);
         translateVa.setDuration(500);
         scaleVa.setDuration(500);

         alphaVa.start();
         translateVa.start();
         scaleVa.start();

     }


     @Override
     public void onBackPressed() {
         performExitAnimation();
     }

     private void performExitAnimation() {
         float originY = getIntent().getIntExtra("y", 0);

         int location[] = new int[2];
         mSearchBGTxt.getLocationOnScreen(location);

         final float translateY = originY - (float) location[1];


         final ValueAnimator translateVa = ValueAnimator.ofFloat(mSearchBGTxt.getY(), mSearchBGTxt.getY()+translateY);
         translateVa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
             @Override
             public void onAnimationUpdate(ValueAnimator valueAnimator) {
                 mSearchBGTxt.setY((Float) valueAnimator.getAnimatedValue());
                 mArrowImg.setY(mSearchBGTxt.getY() + (mSearchBGTxt.getHeight() - mArrowImg.getHeight()) / 2);
                // mHintTxt.setY(mSearchBGTxt.getY() + (mSearchBGTxt.getHeight() - mHintTxt.getHeight()) / 2);
                 mSearchTxt.setY(mSearchBGTxt.getY() + (mSearchBGTxt.getHeight() - mSearchTxt.getHeight()) / 2);
                 //mSearchTxt.setY((Float) valueAnimator.getAnimatedValue());
             }
         });
         translateVa.addListener(new Animator.AnimatorListener() {
             @Override
             public void onAnimationStart(Animator animator) {

             }

             @Override
             public void onAnimationEnd(Animator animator) {
                 finish();
                 overridePendingTransition(0, 0);
             }

             @Override
             public void onAnimationCancel(Animator animator) {

             }

             @Override
             public void onAnimationRepeat(Animator animator) {

             }
         });

         ValueAnimator scaleVa = ValueAnimator.ofFloat(0.8f, 1f);
         scaleVa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
             @Override
             public void onAnimationUpdate(ValueAnimator valueAnimator) {
                 mSearchBGTxt.setScaleX((Float) valueAnimator.getAnimatedValue());
             }
         });

         ValueAnimator alphaVa = ValueAnimator.ofFloat(1, 0f);
         alphaVa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
             @Override
             public void onAnimationUpdate(ValueAnimator valueAnimator) {
                 mContentFrame.setAlpha((Float) valueAnimator.getAnimatedValue());

                 mArrowImg.setAlpha((Float) valueAnimator.getAnimatedValue());
                 mSearchTxt.setAlpha((Float) valueAnimator.getAnimatedValue());
             }
         });


         alphaVa.setDuration(500);
         translateVa.setDuration(500);
         scaleVa.setDuration(500);

         alphaVa.start();
         translateVa.start();
         scaleVa.start();

     }



 }
