package com.bingley.materialdesign.mvp.component;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 小组件
 * Author:  Mr.bingley
 * Version:
 * Date:  2016/12/21
 */

public class ComponnetFragment extends BaseFragment {
    @Bind(R.id.phone)
    ClearableEditText mPhone;

    @Override
    protected int getLayoutId() {
        return R.layout.act_componet;
    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);
        mPhone.addTextChangedListener(new PhoneTextWatcher(mPhone));

    }
}

