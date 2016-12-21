package com.bingley.materialdesign.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseActivity;
import com.bingley.materialdesign.fragment.MaterialFragment;
import com.bingley.materialdesign.fragment.PtrRefreashFragment;
import com.bingley.materialdesign.view.TitleView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 实现Google+滑动显示、隐藏toolbar
 * 我觉得应该一种容器的作用，放置的是各个fragment
 */
public class MaterialDetailActivty extends BaseActivity {
    @Bind(R.id.titleview)
    TitleView mTitleview;
    @Bind(R.id.fl_container)
    FrameLayout mFrameLayout;

    @Override
    protected int getContentView() {
        return R.layout.act_container;
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        mTitleview.setBackBtn();
        int material = getIntent().getIntExtra("material", 0);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (material) {
            case 1:
                mTitleview.setTitle("我的收藏");
                MaterialFragment collectFragment = new MaterialFragment();
                fragmentTransaction.add(R.id.fl_container, collectFragment);
                break;
            case 2:
                mTitleview.setTitle("下拉刷新");
                PtrRefreashFragment ptrRefreashFragment = new PtrRefreashFragment();
                fragmentTransaction.add(R.id.fl_container, ptrRefreashFragment);
                break;
            default:
                break;
        }
        fragmentTransaction.commit();

    }

}
