package com.bingley.materialdesign.mvp.osc.fragment;

import android.os.Bundle;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseFragment;

/**
 * Created by SAM on 2017/5/27.
 */
public class FindFragment extends BaseFragment{

    @Override
    protected int getLayoutId() {
        return R.layout.frg_me;
    }
    public static FindFragment newInstance() {
        Bundle args = new Bundle();
        FindFragment fragment = new FindFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
