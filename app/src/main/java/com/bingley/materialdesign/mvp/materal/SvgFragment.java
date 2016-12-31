package com.bingley.materialdesign.mvp.materal;

import android.graphics.drawable.Animatable;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.ImageView;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseFragment;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * svg
 * Author:  Mr.bingley
 * Version:
 * Date:  2016/12/21
 */

public class SvgFragment extends BaseFragment {
    @Bind(R.id.image)
    ImageView mImageView;

    @Override
    protected int getLayoutId() {
        return R.layout.frg_svg;
    }


    @OnClick({R.id.bt_svg_demo})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_svg_demo:
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                // 失败不知道为什么没执行成功
                ((Animatable) (mImageView.getDrawable())).start();
                break;
        }
    }

}

