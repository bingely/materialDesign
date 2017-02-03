package com.bingley.materialdesign.mvp.osc.fragment;

import android.content.Intent;
import android.view.View;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseFragment;
import com.bingley.materialdesign.mvp.osc.activity.LoginActivity;

/**
 * Created by Administrator on 2017/1/19.
 */
public class MeFragment extends BaseFragment{
    @Override
    protected int getLayoutId() {
        return R.layout.frg_me;
    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);
        findView(R.id.btn_me).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),LoginActivity.class));
            }
        });
    }
}
