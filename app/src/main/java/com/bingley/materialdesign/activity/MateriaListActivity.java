package com.bingley.materialdesign.activity;

import android.content.Intent;
import android.view.View;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseActivity;
import com.bingley.materialdesign.view.TitleView;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Mr.bingley
 * on 16/6/20.
 */

public class MateriaListActivity extends BaseActivity {
    @Bind(R.id.titleview)
    TitleView mTitleView;

    @Override
    protected int getContentView() {
        return R.layout.act_material;
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        mTitleView.setBackBtn();
        mTitleView.setTitle("material");
    }


    @OnClick({R.id.ll_hide_toolbar,R.id.ll_pull_torefesh,R.id.ll_textview,R.id.ll_dialog})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_hide_toolbar:

                startActivity(new Intent(this, MaterialDetailActivty.class).putExtra("material",1));
                break;
            case R.id.ll_pull_torefesh:

                startActivity(new Intent(this, MaterialDetailActivty.class).putExtra("material",2));
                break;
            case R.id.ll_textview:
                startActivity(new Intent(this, MaterialDetailActivty.class).putExtra("material",3));
                break;
            case R.id.ll_dialog:
                startActivity(new Intent(this, MaterialDetailActivty.class).putExtra("material",4));
                break;
        }
    }
}
