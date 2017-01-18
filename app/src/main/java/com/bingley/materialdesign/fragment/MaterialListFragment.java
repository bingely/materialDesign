package com.bingley.materialdesign.fragment;

import android.app.ActivityOptions;
import android.content.Intent;
import android.view.View;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.activity.KnowleageDetailActivty;
import com.bingley.materialdesign.base.BaseFragment;
import com.bingley.materialdesign.mvp.materal.TransListActitity;
import com.bingley.materialdesign.mvp.materal.XiTuActivity;

import butterknife.OnClick;

/**
 * Created by Administrator on 2016/12/16.
 */

public class MaterialListFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.frg_learn_material;
    }

    @OnClick({R.id.item_svg, R.id.item_palette, R.id.item_cc, R.id.item_activity_trans,R.id.item_elevation})
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.item_svg:
                KnowleageDetailActivty.gotoActivity(getActivity(), 1000);
                break;
            case R.id.item_palette:
                KnowleageDetailActivty.gotoActivity(getActivity(), 1001);
                break;
            case R.id.item_cc:
                startActivity(new Intent(getActivity(), XiTuActivity.class));
                break;

            case R.id.item_elevation:
                KnowleageDetailActivty.gotoActivity(getActivity(), 1002);
                break;
            case R.id.item_activity_trans:
                startActivity(new Intent(getActivity(), TransListActitity.class), ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());
                break;
        }
    }
}
