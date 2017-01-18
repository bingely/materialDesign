package com.bingley.materialdesign.mvp.materal;

import android.app.ActivityOptions;
import android.content.Intent;
import android.util.Pair;
import android.view.View;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseSwipebackActivity;

import butterknife.OnClick;

/**
 * 过渡动画展示
 * Author:  Mr.bingley
 * Version:
 * Date:  2017/1/18
 */

public class TransListActitity extends BaseSwipebackActivity {

    private Intent intent;

    @Override
    protected int getContentView() {
        return R.layout.activity_transition_list;
    }


    @OnClick({R.id.explode, R.id.slide, R.id.fade, R.id.share})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.explode:
                intent = new Intent(this, TransitionsActivity.class);
                intent.putExtra("flag", 0);
                startActivity(intent,
                        ActivityOptions.makeSceneTransitionAnimation(this)
                                .toBundle());
                break;
            case R.id.slide:
                intent = new Intent(this, TransitionsActivity.class);
                intent.putExtra("flag", 1);
                startActivity(intent,
                        ActivityOptions.makeSceneTransitionAnimation(this)
                                .toBundle());
                break;
            case R.id.fade:
                intent = new Intent(this, TransitionsActivity.class);
                intent.putExtra("flag", 2);
                startActivity(intent,
                        ActivityOptions.makeSceneTransitionAnimation(this)
                                .toBundle());
                break;
            case R.id.share:

                View fab = findViewById(R.id.fab_button);
                intent = new Intent(this, TransitionsActivity.class);
                intent.putExtra("flag", 3);
                // 创建单个共享元素(view两者可以长得不一样，意味只有一个view的视图变化）
                /*startActivity(intent,
                        ActivityOptions.makeSceneTransitionAnimation(
                                this, view, "share").toBundle());*/

                // 创建多个共享元素
               startActivity(intent,
                        ActivityOptions.makeSceneTransitionAnimation(
                                this,
                                // 创建多个共享元素
                                Pair.create(view, "share"),
                                Pair.create(fab, "fab")).toBundle());
                break;
        }
    }
}
