package com.bingley.materialdesign.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

 /**
   * 可以右划返回上一级的activity
   * Author:  Mr.bingley
   * Version:
   * Date:  2017/1/13
   */

public abstract class BaseSwipebackActivity extends SwipeBackActivity {

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
