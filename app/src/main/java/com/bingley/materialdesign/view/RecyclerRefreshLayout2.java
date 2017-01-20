package com.bingley.materialdesign.view;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.ViewConfiguration;

/**
 * Created by Administrator on 2017/1/19.
 */

public class RecyclerRefreshLayout2 extends SwipeRefreshLayout implements SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView mRecycleView;

    private int mTouchSlop;

    private SuperRefreshLayoutListener listener;

    private boolean mIsOnLoading = false;

    private boolean mCanLoadMore = true;

    private boolean mHasMore = true;

    private int mYDown;

    private int mLastY;

    public RecyclerRefreshLayout2(Context context) {
        this(context, null);
    }

    public RecyclerRefreshLayout2(Context context, AttributeSet attrs) {
        super(context, attrs);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {

        if (listener != null && !mIsOnLoading) {
            listener.onRefreshing();
        } else {
            setRefreshing(false);
        }
    }


    public interface SuperRefreshLayoutListener {
        void onRefreshing();

        void onLoadMore();
    }

}
