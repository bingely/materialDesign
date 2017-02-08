package com.bingley.materialdesign.mvp.osc;

import com.bingley.materialdesign.http.asy.ApiHttpClient;
import com.bingley.materialdesign.http.okhttp.OkHttpHelper;
import com.bingley.materialdesign.http.okhttp.OkHttpUtils;
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
}
