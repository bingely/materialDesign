package com.bingley.materialdesign.topic.stock;

import android.view.View;
import android.widget.Button;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.activity.KnowleageDetailActivty;
import com.bingley.materialdesign.base.BaseFragment;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * $Description:$
 * Author:  Mr.bingley
 * Version:
 * Date:  2017/2/24
 */

public class StockFragment extends BaseFragment {
    @Bind(R.id.btn)
    Button btn;
    @Bind(R.id.btn_k)
    Button btnK;

    @Override
    protected int getLayoutId() {
        return R.layout.frag_stock;
    }


    @OnClick({R.id.btn, R.id.btn_k})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn:
                KnowleageDetailActivty.gotoActivity(getActivity(),15);
                break;
            case R.id.btn_k:
                KnowleageDetailActivty.gotoActivity(getActivity(),16);
                break;
        }
    }
}
