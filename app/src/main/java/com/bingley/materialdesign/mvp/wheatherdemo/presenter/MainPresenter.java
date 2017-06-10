package com.bingley.materialdesign.mvp.wheatherdemo.presenter;


import com.bingley.materialdesign.mvp.wheatherdemo.model.MainModel;
import com.bingley.materialdesign.mvp.wheatherdemo.model.MainModelBean;
import com.bingley.materialdesign.mvp.wheatherdemo.view.MainView;

/**
 * View和Model的桥梁，它从Model层检索数据后，返回给View层
 * Author:  Mr.bingley
 * Version:
 * Date:  2017/6/10
 */
public class MainPresenter implements Presenter<MainView>, IMainPresenter {
    private MainView mMainView;
    private MainModel mMainModel;

    public MainPresenter(MainView mMainView) {
        this.mMainView = mMainView;
        mMainModel = new MainModel(this);
    }

    @Override
    public void attachView(MainView view) {
        this.mMainView = view;
    }

    @Override
    public void detachView() {
        this.mMainView = null;
    }

    @Override
    public void loadDataSuccess(MainModelBean mainModelBean) {
        mMainView.showProgress();
        mMainModel.loadData();
    }

    public void loadData() {
        mMainView.showProgress();
        mMainModel.loadData();
    }

    @Override
    public void loadDataFailure() {
        mMainView.hideProgress();
    }
}