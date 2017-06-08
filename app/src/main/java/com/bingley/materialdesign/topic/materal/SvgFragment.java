package com.bingley.materialdesign.topic.materal;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
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

    @Bind(R.id.image2)
    ImageView mImageView2;

    @Override
    protected int getLayoutId() {
        return R.layout.frg_svg;
    }


    @OnClick({R.id.bt_svg_demo,R.id.image2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_svg_demo:
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                // 失败不知道为什么没执行成功
                Drawable drawable = mImageView.getDrawable();
                if (drawable instanceof AnimationDrawable) {
                    ((Animatable) (mImageView.getDrawable())).start();
                }
                break;
            case R.id.image2:
                // 失败不知道为什么没执行成功
                Drawable drawable2 = mImageView2.getDrawable();
                if (drawable2 instanceof AnimationDrawable) {
                    ((Animatable) (mImageView2.getDrawable())).start();
                }
                break;
        }
    }

}

