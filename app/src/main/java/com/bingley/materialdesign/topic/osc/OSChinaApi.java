package com.bingley.materialdesign.topic.osc;

import android.text.TextUtils;

import com.bingley.materialdesign.http.asy.ApiHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

/**
 * Created by Administrator on 2017/2/3.
 */

public class OSChinaApi {
    /**
     * 登陆
     *
     * @param username
     * @param password
     * @param handler
     */
    public static void login(String username, String password,
                             AsyncHttpResponseHandler handler) {
        RequestParams params = new RequestParams();
        params.put("username", username);
        params.put("pwd", password);
        params.put("keep_login", 1);
        String loginurl = "action/api/login_validate";
        ApiHttpClient.post(loginurl, params, handler);

    }

    /**
     * 获取个人信息
     */
    public static void getUserInfo(TextHttpResponseHandler handler) {
        ApiHttpClient.get("action/apiv2/user_info", handler);
    }

    /**
     * 请求资讯列表
     *
     * @param pageToken 请求上下页数据令牌
     * @param handler   AsyncHttpResponseHandler
     */
    public static void getNewsList(String pageToken, AsyncHttpResponseHandler handler) {
        RequestParams params = new RequestParams();
        if (!TextUtils.isEmpty(pageToken)) {
            params.put("pageToken", pageToken);
        }

        ApiHttpClient.get("action/apiv2/news", params, handler);
    }


    public static final int CATALOG_BANNER_NEWS = 1; // 资讯Banner
    public static final int CATALOG_BANNER_BLOG = 2; // 博客Banner
    public static final int CATALOG_BANNER_EVENT = 3; // 活动Banner

    /**
     * 请求Banner列表接口
     *
     * @param catalog Banner类别 {@link #CATALOG_BANNER_NEWS, #CATALOG_BANNER_BLOG, #CATALOG_BANNER_EVENT}
     * @param handler AsyncHttpResponseHandler
     */
    public static void getBannerList(int catalog, AsyncHttpResponseHandler handler) {
        RequestParams params = new RequestParams();
        params.put("catalog", catalog);
        ApiHttpClient.get("action/apiv2/banner", params, handler);
    }
}
