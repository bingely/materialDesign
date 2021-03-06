package com.bingley.materialdesign.topic.pullreflsh.jdong;

import android.content.Context;
import android.util.AttributeSet;

import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by Administrator on 2016/12/21.
 */

public class JdRefreshLayout extends PtrFrameLayout{
    /**
     * headerView
     */
    JdRefreshHeader mHeaderView;

    public JdRefreshLayout(Context context) {
        super(context);
        initView();
    }

    public JdRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public JdRefreshLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    private void initView() {
        mHeaderView = new JdRefreshHeader(getContext());
        setHeaderView(mHeaderView);
        addPtrUIHandler(mHeaderView);
    }
}
