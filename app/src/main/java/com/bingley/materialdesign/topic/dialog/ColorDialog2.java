package com.bingley.materialdesign.topic.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bingley.materialdesign.R;

/**
 * Created by Administrator on 2016/12/22.
 */

public class ColorDialog2 extends Dialog implements View.OnClickListener {
    private ImageView mContentIv;

    private Bitmap mContentBitmap;

    private View mBtnGroupView, mDividerView, mBkgView, mDialogView;

    private TextView mTitleTv, mContentTv, mPositiveBtn, mNegativeBtn;

    private Drawable mDrawable;

    private AnimationSet mAnimIn, mAnimOut;

    private int mResId, mBackgroundColor, mTitleTextColor, mContentTextColor;

    private ColorDialog.OnPositiveListener mPositiveListener;

    private ColorDialog.OnNegativeListener mNegativeListener;

    private CharSequence mTitleText, mContentText, mPositiveText, mNegativeText;

    private boolean mIsShowAnim;

    public ColorDialog2(Context context) {
        this(context, 0);
    }

    public ColorDialog2(Context context, int themeResId) {
        super(context, R.style.color_dialog);
        init();
    }

    private void callDismiss() {
        super.dismiss();
    }


    private void init() {
        mAnimIn = AnimationLoader.getInAnimation(getContext());
        mAnimOut = AnimationLoader.getOutAnimation(getContext());
        initAnimListener();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View contentView = View.inflate(getContext(), R.layout.layout_colordialog, null);
        setContentView(contentView);

        mDialogView = getWindow().getDecorView().findViewById(android.R.id.content);
        mBkgView = contentView.findViewById(R.id.llBkg);
        mTitleTv = (TextView) contentView.findViewById(R.id.tvTitle);
        mContentTv = (TextView) contentView.findViewById(R.id.tvContent);
        mContentIv = (ImageView) contentView.findViewById(R.id.ivContent);

        mPositiveBtn = (TextView) contentView.findViewById(R.id.btnPositive);
        mNegativeBtn = (TextView) contentView.findViewById(R.id.btnNegative);

        mDividerView = contentView.findViewById(R.id.divider);
        mBtnGroupView = contentView.findViewById(R.id.llBtnGroup);

        mPositiveBtn.setOnClickListener(this);
        mNegativeBtn.setOnClickListener(this);

        mTitleTv.setText(mTitleText);
        mContentTv.setText(mContentText);
        mPositiveBtn.setText(mPositiveText);
        mNegativeBtn.setText(mNegativeText);





        boolean isImageMode = (null != mDrawable | null != mContentBitmap | 0 != mResId);
        boolean isTextMode = (!TextUtils.isEmpty(mContentText));

        if (isImageMode & isTextMode) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) mContentTv.getLayoutParams();
            layoutParams.gravity = Gravity.BOTTOM;
            mContentTv.setLayoutParams(layoutParams);
        }

    }

    private void initAnimListener() {
        mAnimOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mDialogView.post(new Runnable() {
                    @Override
                    public void run() {
                        callDismiss();
                    }


                });
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    @Override
    public void onClick(View view) {

    }

    // Dialog基本用法---去感受下如何变成一个真正意义上的工具。
}
