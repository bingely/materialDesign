package com.bingley.materialdesign.fragment;

import android.view.View;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.activity.KnowleageDetailActivty;
import com.bingley.materialdesign.base.BaseFragment;

import butterknife.OnClick;

/**
 * Created by Administrator on 2016/12/16.
 */

public class MaterialListFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.frg_learn_material;
    }

    @OnClick({R.id.item_svg})
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.item_svg:
                KnowleageDetailActivty.gotoActivity(getActivity(),11);
                break;
        }
    }
}
