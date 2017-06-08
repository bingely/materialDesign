package com.bingley.materialdesign.topic.zhifeiji;

import android.view.View;

/**
   *
   * Author:  Mr.bingley
   * Version:
   * Date:  2017/3/9
   */

public interface BaseView<T> {
    /**
     * set the presenter of mvp
     * @param presenter
     */
    void setPresenter(T presenter);

    /**
     * init the views of fragment
     * @param view
     */
    void initViews(View view);
}
