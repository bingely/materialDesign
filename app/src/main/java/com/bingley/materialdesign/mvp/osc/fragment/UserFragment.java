package com.bingley.materialdesign.mvp.osc.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bingley.materialdesign.AppConfig;
import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseFragment;
import com.bingley.materialdesign.mvp.osc.activity.LoginActivity;
import com.bingley.materialdesign.utils.SPUtils;

import butterknife.Bind;

/**
 * Created by SAM on 2017/5/27.
 */
public class UserFragment extends BaseFragment{
    @Bind(R.id.bt_meinfo)
    Button mBtInfo;

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
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });

        mBtInfo.setText(SPUtils.getFromPrefs(getActivity(), AppConfig.OSCINFO, ""));
    }
    public static UserFragment newInstance() {
        Bundle args = new Bundle();
        UserFragment fragment = new UserFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
