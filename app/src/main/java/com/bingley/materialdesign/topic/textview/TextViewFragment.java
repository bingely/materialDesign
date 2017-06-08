package com.bingley.materialdesign.topic.textview;

import android.view.View;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseFragment;

import butterknife.Bind;

/**
 * 小组件
 * Author:  Mr.bingley
 * Version:
 * Date:  2016/12/21
 */

public class TextViewFragment extends BaseFragment {
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

