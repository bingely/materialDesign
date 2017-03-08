package com.bingley.materialdesign.mvp.osc.fragment;

import android.view.View;
import android.widget.Toast;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseFragment;
import com.bingley.materialdesign.interf.OnTabReselectListener;

/**
 * Created by Administrator on 2017/1/19.
 */
public class HomeFragment extends BaseFragment implements OnTabReselectListener {

    @Override
    protected int getLayoutId() {
        return R.layout.frg_home;
    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);

    }

    @Override
    public void onTabReselect() {
        Toast.makeText(getActivity(), "homefragment", Toast.LENGTH_SHORT).show();
    }

}
