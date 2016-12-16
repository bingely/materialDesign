package com.bingley.materialdesign.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import butterknife.ButterKnife;

/**
 * Created by Mr.bingley
 * on 16/6/20.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (initBundle(getIntent().getExtras())) {
            setContentView(getContentView());

            initWindow();
            //将activity加入到AppManager堆栈中
            //AppManager.getAppManager().addActivity(this);

            ButterKnife.bind(this);
            initWidget();
            initData();
        } else {
            finish();
        }
    }

    // 可以直接替代 bind
    protected <T extends View> T findView(int viewId) {
        return (T) findViewById(viewId);
    }

    protected void initWindow() {
    }


    protected abstract int getContentView();

    protected boolean initBundle(Bundle bundle) {
        return true;
    }

    protected void initWidget() {
    }

    protected void initData() {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //AppManager.getAppManager().removeActivity(this);
    }
}
