package com.bingley.materialdesign.mvp.osc.fragment;

import android.os.Bundle;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseFragment;

/**
 * Created by SAM on 2017/5/27.
 */
public class TweenFragment extends BaseFragment{
    @Override
    protected int getLayoutId() {
        return R.layout.frg_tween;
    }
    public static TweenFragment newInstance() {
        Bundle args = new Bundle();
        TweenFragment fragment = new TweenFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
