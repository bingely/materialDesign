package com.bingley.materialdesign.mvp.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.Toast;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseFragment;

import butterknife.OnClick;

/**
 * 小组件
 * Author:  Mr.bingley
 * Version:
 * Date:  2016/12/21
 */

public class DialogFragment extends BaseFragment {

    @Override
    protected int getLayoutId() {
        return R.layout.frg_dialog;
    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);

    }

    public void showTextDialog() {
        ColorDialog dialog = new ColorDialog(getActivity());
        dialog.setColor("#8ECB54");
        dialog.setAnimationEnable(true);
        dialog.setTitle(getString(R.string.operation));
        dialog.setContentText(getString(R.string.content_text));
        dialog.setPositiveListener(getString(R.string.text_iknow), new ColorDialog.OnPositiveListener() {
            @Override
            public void onClick(ColorDialog dialog) {
                Toast.makeText(getActivity(), dialog.getPositiveText().toString(), Toast.LENGTH_SHORT).show();
            }
        }).show();
    }

    public void showPicDialog() {
        ColorDialog dialog = new ColorDialog(getActivity());
        dialog.setTitle(getString(R.string.operation));
        dialog.setAnimationEnable(true);
        dialog.setAnimationIn(getInAnimationTest(getActivity()));
        dialog.setAnimationOut(getOutAnimationTest(getActivity()));
        dialog.setContentImage(getResources().getDrawable(R.mipmap.sample_img));
        dialog.setPositiveListener(getString(R.string.delete), new ColorDialog.OnPositiveListener() {
            @Override
            public void onClick(ColorDialog dialog) {
                Toast.makeText(getActivity(), dialog.getPositiveText().toString(), Toast.LENGTH_SHORT).show();
            }
        }).setNegativeListener(getString(R.string.cancel), new ColorDialog.OnNegativeListener() {
                    @Override
                    public void onClick(ColorDialog dialog) {
                        Toast.makeText(getActivity(), dialog.getNegativeText().toString(), Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }).show();
    }


    @OnClick({R.id.showPromptDialog, R.id.showPicDialog, R.id.showTextDialog, R.id.showAllModeDialog})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.showPromptDialog:
                break;
            case R.id.showPicDialog:
                showPicDialog();
                break;
            case R.id.showTextDialog:
                showTextDialog();
                break;
            case R.id.showAllModeDialog:
                break;
        }
    }

    public static AnimationSet getInAnimationTest(Context context) {
        AnimationSet out = new AnimationSet(context, null);
        AlphaAnimation alpha = new AlphaAnimation(0.0f, 1.0f);
        alpha.setDuration(150);
        ScaleAnimation scale = new ScaleAnimation(0.6f, 1.0f, 0.6f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setDuration(150);
        out.addAnimation(alpha);
        out.addAnimation(scale);
        return out;
    }

    public static AnimationSet getOutAnimationTest(Context context) {
        AnimationSet out = new AnimationSet(context, null);
        AlphaAnimation alpha = new AlphaAnimation(1.0f, 0.0f);
        alpha.setDuration(150);
        ScaleAnimation scale = new ScaleAnimation(1.0f, 0.6f, 1.0f, 0.6f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setDuration(150);
        out.addAnimation(alpha);
        out.addAnimation(scale);
        return out;
    }
}

