package com.bingley.materialdesign.activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Mr.bingley
 * on 16/6/20.
 */

public class MaterialMainActivity extends BaseActivity {
    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected int getContentView() {
        return R.layout.act_material;
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }


    @OnClick({ R.id.ll_hide_toolbar})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_hide_toolbar:
                startActivity(new Intent(this, HideToolbarActivty.class));
                break;
        }
    }
}
