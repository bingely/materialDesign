package com.bingley.materialdesign.mvp.wheatherdemo.presenter;

/**
 * Created by Administrator on 2017/1/3.
 */

public interface Presenter<V> {
    void attachView(V view);
    void detachView();
}
