package com.bingley.materialdesign.utils;

import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

import com.bingley.materialdesign.base.BaseActivity;

/**
 * Created by Administrator on 2016/12/28.
 */

public class demo extends BaseActivity{

 /*

      // 这个是evenbus
    public void onEventMainThread(MeChangeEvent event) {
        initData();
    }



    */

    public void ani() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0f,  // x方向缩放比例
                1f,
                0f,
                1f,
                Animation.RELATIVE_TO_SELF, 0.5f,  // 相对自己，  这里是中心点
                Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setFillEnabled(true);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(1000);

    }


    @Override
    protected int getContentView() {
        return 0;
    }

    @Override
    protected void initWidget() {
        super.initWidget();

    }

    @Override
    protected void initData() {
        super.initData();



        initArrayAdapter();
    }

    private void initArrayAdapter() {
     /*
        String[] objects = new String[100];
        for (int i = 0; i < 100; i++) {
            objects[i] = "hacket--"+i;
        }
        lv.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, R.id.tv_info, objects ));

        */
    }
}
