package com.bingley.materialdesign.activity;

import android.content.Intent;
import android.view.View;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseSwipebackActivity;
import com.bingley.materialdesign.topic.listviewdemo.ScrollHideListViewActivity;
import com.bingley.materialdesign.view.TitleView;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Mr.bingley
 * on 16/6/20.
 */

public class KnowlegeListActivity extends BaseSwipebackActivity {
    @Bind(R.id.titleview)
    TitleView mTitleView;

    @Override
    protected int getContentView() {
        return R.layout.act_learn_basic;
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        mTitleView.setBackBtn();
        mTitleView.setTitle("基础知识学习");
    }


    @OnClick({R.id.ll_hide_toolbar, R.id.ll_pull_torefesh, R.id.ll_textview, R.id.ll_dialog,
            R.id.ll_pop,R.id.ll_elm,R.id.ll_hindlistview,R.id.ll_anim,R.id.ll_lunbo,R.id.ll_sqlite,
            R.id.ll_customview,R.id.ll_scroll,R.id.ll_aidl,R.id.ll_socket,R.id.ll_graph
    })
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_hide_toolbar:
                KnowleageDetailActivty.gotoActivity(this,1);
                break;
            case R.id.ll_pull_torefesh:
                KnowleageDetailActivty.gotoActivity(this,2);
                break;
            case R.id.ll_textview:
                KnowleageDetailActivty.gotoActivity(this,3);
                break;
            case R.id.ll_dialog:
                KnowleageDetailActivty.gotoActivity(this,4);
                break;
            case R.id.ll_pop:
                KnowleageDetailActivty.gotoActivity(this,5);

                break;
            case R.id.ll_elm:
                KnowleageDetailActivty.gotoActivity(this,6);
                break;

            case R.id.ll_hindlistview:
                startActivity(new Intent(this, ScrollHideListViewActivity.class));
                break;
            case R.id.ll_anim:
                KnowleageDetailActivty.gotoActivity(this,7);
                break;
            case R.id.ll_lunbo:
                KnowleageDetailActivty.gotoActivity(this,8);
                break;
            case R.id.ll_sqlite:
                KnowleageDetailActivty.gotoActivity(this,9);
                break;
            case R.id.ll_customview:
                KnowleageDetailActivty.gotoActivity(this,10);
                break;

            case R.id.ll_scroll:
                KnowleageDetailActivty.gotoActivity(this,12);
                break;
            case R.id.ll_aidl:
                KnowleageDetailActivty.gotoActivity(this,13);
                break;
            case R.id.ll_graph:
                KnowleageDetailActivty.gotoActivity(this,14);
                break;
            case R.id.ll_socket:
                KnowleageDetailActivty.gotoActivity(this,17);
                break;
        }
    }

}
