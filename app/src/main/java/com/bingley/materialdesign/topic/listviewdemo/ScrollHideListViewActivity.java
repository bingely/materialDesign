package com.bingley.materialdesign.topic.listviewdemo;

import android.animation.ObjectAnimator;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseSwipebackActivity;

import butterknife.Bind;

/**
 * 自动显示隐藏的listview
 *
 * TODO 没有处理好toolbar高度。
 * * Author:  Mr.bingley
 * Version:
 * Date:  2017/1/10
 */

public class ScrollHideListViewActivity extends BaseSwipebackActivity {
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.listview)
    ListView mListView;

    private String[] mStr = new String[20];
    private int mTouchSlop;
    private float mFirstY;
    private float mCurrentY;
    private int direction;
    private ObjectAnimator mAnimator;
    private boolean mShow = true;

    @Override
    protected int getContentView() {
        return R.layout.act_scroll_hide;
    }

    View.OnTouchListener myTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    mFirstY = event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    mCurrentY = event.getY();
                    if (mCurrentY - mFirstY > mTouchSlop) {
                        direction = 0;// down
                    } else if (mFirstY - mCurrentY > mTouchSlop) {
                        direction = 1;// up
                    }
                    if (direction == 1) {
                        if (mShow) {
                             toolbarAnim(1);//hide
                            mShow = !mShow;
                        }
                    } else if (direction == 0) {
                        if (!mShow) {
                            toolbarAnim(0);//show
                            mShow = !mShow;
                        }
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    break;
            }
            return false;
        }
    };


    @Override
    protected void initWidget() {
        super.initWidget();

        mTouchSlop = ViewConfiguration.get(this).getScaledTouchSlop();
        for (int i = 0; i < mStr.length; i++) {
            mStr[i] = "item" + i;
        }

        // 加headerview 避免第一个item被toolbar遮挡
        View header = new View(this);
        header.setLayoutParams(new AbsListView.LayoutParams(
                AbsListView.LayoutParams.MATCH_PARENT,
                (int) 44));
        //mListView.addHeaderView(header);
        mListView.setAdapter(new ArrayAdapter<String>(
               this,
                android.R.layout.simple_expandable_list_item_1,
                mStr));
        mListView.setOnTouchListener(myTouchListener);

    }

    private void toolbarAnim(int flag) {
        if (mAnimator != null && mAnimator.isRunning()) {
            mAnimator.cancel();
        }
        if (flag == 0) {
            mAnimator = ObjectAnimator.ofFloat(mToolbar,
                    "translationY", mToolbar.getTranslationY(), 0);
        } else {
            mAnimator = ObjectAnimator.ofFloat(mToolbar,
                    "translationY", mToolbar.getTranslationY(),
                    -mToolbar.getHeight());
        }
        mAnimator.start();
    }

    private void toobarA(int flag) {
        if (mAnimator != null && mAnimator.isRunning()) {
            mAnimator.cancel();
        }
        mAnimator = ObjectAnimator.ofFloat(mToolbar,"translationY",mToolbar.getTranslationY(),0);

    }
}
