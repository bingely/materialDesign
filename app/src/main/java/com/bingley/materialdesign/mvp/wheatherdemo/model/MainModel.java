package com.bingley.materialdesign.mvp.wheatherdemo.model;

import com.bingley.materialdesign.mvp.wheatherdemo.presenter.IMainPresenter;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * 业务具体处理，包括负责存储、检索、操纵数据等
 * Author:  Mr.bingley
 * Version:
 * Date:  2017/6/10
 */

// 此处也要学会用原生的json解析方法

public class MainModel {
    IMainPresenter mIMainPresenter;

    public MainModel(IMainPresenter mIMainPresenter) {
        this.mIMainPresenter = mIMainPresenter;
    }


    public void loadData() {

        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        asyncHttpClient.get("http://www.weather.com.cn/adat/sk/101010100.html", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    MainModelBean mainModelBean = new MainModelBean();
                    JSONObject weatherinfo = response.getJSONObject("weatherinfo");
                    mainModelBean.setCity(weatherinfo.getString("city"));
                    mainModelBean.setWd(weatherinfo.getString("WD"));
                    mainModelBean.setWs(weatherinfo.getString("WS"));
                    mainModelBean.setTime(weatherinfo.getString("time"));
                    mIMainPresenter.loadDataSuccess(mainModelBean);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                mIMainPresenter.loadDataFailure();
            }
        });
    }
}