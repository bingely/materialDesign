package com.bingley.materialdesign.mvp.wheatherdemo.ui;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseActivity;
import com.bingley.materialdesign.mvp.wheatherdemo.model.MainModelBean;
import com.bingley.materialdesign.mvp.wheatherdemo.presenter.MainPresenter;
import com.bingley.materialdesign.mvp.wheatherdemo.view.MainView;

/**
   * 由Activity/Fragment实现View里方法，包含一个Presenter的引用
   * Author:  Mr.bingley
   * Version:
   * Date:  2017/6/10
   */

public class MainActivity extends BaseActivity implements MainView {
    private TextView text;
    private MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    protected int getContentView() {
        return R.layout.mvp_whether_main;
    }

    private void initView() {
        text = (TextView) findViewById(R.id.text);
        mMainPresenter = new MainPresenter(this);
        //制造延迟效果
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mMainPresenter.loadData();
            }
        }, 2000);
    }

    @Override
    public void showData(MainModelBean mainModelBean) {
        String showData = getResources().getString(R.string.city) + mainModelBean.getCity()
                + getResources().getString(R.string.wd) + mainModelBean.getWd()
                + getResources().getString(R.string.ws) + mainModelBean.getWs()
                + getResources().getString(R.string.time) + mainModelBean.getTime();
        text.setText(showData);
    }

    @Override
    public void showProgress() {
       //showProgress();
    }

    @Override
    public void hideProgress() {
       // dismissProgressDialog();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainPresenter.detachView();
        super.onDestroy();
    }
}
