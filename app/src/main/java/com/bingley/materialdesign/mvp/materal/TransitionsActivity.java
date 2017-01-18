package com.bingley.materialdesign.mvp.materal;

import android.app.Activity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Window;

import com.bingley.materialdesign.R;

public class TransitionsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 我把其注释掉也是正常的显示效果
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        int flag = getIntent().getExtras().getInt("flag");
        // 设置不同的动画效果
        // ？？我不设置退出效果，也是有动画的
        switch (flag) {
            case 0:
                getWindow().setEnterTransition(new Explode());
                getWindow().setExitTransition(new Explode());
                break;
            case 1:
                getWindow().setEnterTransition(new Slide());
                getWindow().setExitTransition(new Slide());
                break;
            case 2:
                getWindow().setEnterTransition(new Fade());
                getWindow().setExitTransition(new Fade());
                break;
            case 3:
                break;
        }
        setContentView(R.layout.activity_transition_to);
    }
}
