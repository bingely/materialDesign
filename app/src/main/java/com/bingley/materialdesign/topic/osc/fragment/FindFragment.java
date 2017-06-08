package com.bingley.materialdesign.topic.osc.fragment;

import android.os.Bundle;
import android.view.View;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseFragment;

/**
 * Created by SAM on 2017/5/27.
 */
public class FindFragment extends BaseFragment{

    @Override
    protected int getLayoutId() {
        return R.layout.frg_databind;
    }
    public static FindFragment newInstance() {
        Bundle args = new Bundle();
        FindFragment fragment = new FindFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);
        // 如果是在fragment中 databinding如何写

       /* ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        User user = new User("loonggg", "23");
        binding.setUser(user);*/

    }
}
