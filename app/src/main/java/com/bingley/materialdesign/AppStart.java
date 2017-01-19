package com.bingley.materialdesign;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.bingley.materialdesign.activity.MainActivity;


/**
 * 应用启动界面
 *
 * 如何做到如果关闭app时间间隔比较短的话，当应用再次打开时，不会重新看到appstar页面。 TODO
 */
public class AppStart extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 防止第三方跳转时出现双实例
        Activity aty = AppManager.getActivity(MainActivity.class);
        if (aty != null && !aty.isFinishing()) {
            finish();
        }

        setContentView(R.layout.app_start);
        findViewById(R.id.app_start_view).postDelayed(new Runnable() {
            @Override
            public void run() {
                redirectTo();
            }
        }, 800);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * 跳转到...
     */
    private void redirectTo() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
