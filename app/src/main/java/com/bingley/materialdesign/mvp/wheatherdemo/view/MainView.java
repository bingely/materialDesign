package com.bingley.materialdesign.mvp.wheatherdemo.view;

import com.bingley.materialdesign.mvp.wheatherdemo.model.MainModelBean;

/**
   * 处理业务需要哪些方法
   * Author:  Mr.bingley
   * Version:
   * Date:  2017/6/10
   */

public interface MainView {
     void showData(MainModelBean mainModelBean);
     void showProgress();
     void hideProgress();
}