package com.bingley.materialdesign.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.topic.dialog.progress.Indeterminate;

/**
 * Created by Administrator on 2017/1/20.
 */
public class IosProgress extends ImageView implements Indeterminate {

    private float mRotateDegrees;
    private int mFrameTime;
    private boolean mNeedToUpdateView;
    private Runnable mUpdateViewRunnable;

    public IosProgress(Context context) {
        super(context);
        init();
    }

    public IosProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {

        setImageResource(R.drawable.kprogresshud_spinner);
        mFrameTime = 1000 / 12;
        mUpdateViewRunnable = new Runnable() {
            @Override
            public void run() {
                mRotateDegrees += 30;
                mRotateDegrees = mRotateDegrees < 360 ? mRotateDegrees : mRotateDegrees - 360;
                invalidate();
                if (mNeedToUpdateView) {
                    postDelayed(this, mFrameTime);
                }

            }
        };
    }

    @Override
    public void setAnimationSpeed(float scale) {
        mFrameTime = (int) (1000 / 12 / scale);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.rotate(mRotateDegrees, getWidth() / 2, getHeight() / 2);
        super.onDraw(canvas);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mNeedToUpdateView = true;
        post(mUpdateViewRunnable);
    }

    @Override
    protected void onDetachedFromWindow() {
        mNeedToUpdateView = false;
        super.onDetachedFromWindow();
    }

    public boolean setNeedToUpdateView(boolean needToUpdateView) {
        this.mNeedToUpdateView = needToUpdateView;
        return mNeedToUpdateView;
    }

    public void stop() {
        setNeedToUpdateView(false);
    }

    public void start() {
        setNeedToUpdateView(true);
    }
}
