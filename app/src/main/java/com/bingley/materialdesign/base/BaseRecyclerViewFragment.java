package com.bingley.materialdesign.base;

import com.bingley.materialdesign.R;

/**
 * Created by Administrator on 2017/1/19.
 */

public class BaseRecyclerViewFragment<T> extends BaseFragment{
    @Override
    protected int getLayoutId() {
        return R.layout.frg_base_recycler_view;
    }

}
