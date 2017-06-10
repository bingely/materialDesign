package com.bingley.materialdesign.mvp.wheatherdemo.presenter;

import com.bingley.materialdesign.mvp.wheatherdemo.model.MainModelBean;

 /**
   * 此接口作用是连接Model
   * Author:  Mr.bingley
   * Version:
   * Date:  2017/6/10
   */

public interface IMainPresenter {

    void loadDataSuccess(MainModelBean mainModelBean);

    void loadDataFailure();
}
