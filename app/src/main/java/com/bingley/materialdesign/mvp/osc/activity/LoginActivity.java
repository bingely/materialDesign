package com.bingley.materialdesign.mvp.osc.activity;


import android.text.TextUtils;
import android.widget.Toast;

import com.bingley.materialdesign.AppConfig;
import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseActivity;
import com.bingley.materialdesign.http.asy.ApiHttpClient;
import com.bingley.materialdesign.mvp.osc.OSChinaApi;
import com.bingley.materialdesign.mvp.osc.bean.LoginUserBean;
import com.bingley.materialdesign.utils.DialogUtil;
import com.bingley.materialdesign.utils.LogUtils;
import com.bingley.materialdesign.utils.SPUtils;
import com.bingley.materialdesign.utils.XmlUtils;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.TextHttpResponseHandler;


import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.client.CookieStore;
import cz.msebera.android.httpclient.client.protocol.ClientContext;
import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.protocol.HttpContext;

public class LoginActivity extends BaseActivity {
    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void initWidget() {
        super.initWidget();

        /*String loginurl = "action/api/login_validate";
        OkHttpUtils
                .post()
                .url(loginurl)
                .addParams("username", "linmb@qq.com")
                .addParams("pwd", "lmbbest123")
                .addParams("keep_login","1")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Toast.makeText(LoginActivity.this, response, Toast.LENGTH_SHORT).show();
                    }

                });*/

        DialogUtil.showDialog(this);
        OSChinaApi.login("linmb@qq.com", "lmbbest123", mHandler);


    }
    private final AsyncHttpResponseHandler mHandler = new AsyncHttpResponseHandler() {

        @Override
        public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
            LoginUserBean loginUserBean = XmlUtils.toBean(LoginUserBean.class, arg2);
            if (loginUserBean != null) {
                handleLoginBean(loginUserBean, arg1);
            }
            Toast.makeText(LoginActivity.this, new String(arg2), Toast.LENGTH_SHORT).show();
            LogUtils.e(new String(arg2));

        }

        @Override
        public void onFailure(int arg0, Header[] arg1, byte[] arg2,
                              Throwable arg3) {
            Toast.makeText(LoginActivity.this, "网络出错" + arg0, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onFinish() {
            super.onFinish();
            DialogUtil.dimissDialog();
        }
    };


    // 处理loginBean
    private void handleLoginBean(LoginUserBean loginUserBean, Header[] headers) {
        // 貌似得写进cookie中不然是不行的
        if (loginUserBean.getResult().OK()) {
            AsyncHttpClient client = ApiHttpClient.getHttpClient();
            HttpContext httpContext = client.getHttpContext();
            CookieStore cookies = (CookieStore) httpContext
                    .getAttribute(ClientContext.COOKIE_STORE);
            if (cookies != null) {
                String tmpcookies = "";
                for (Cookie c : cookies.getCookies()) {
                    LogUtils.e("cookie:" + c.getName() + " " + c.getValue());
                    tmpcookies += (c.getName() + "=" + c.getValue()) + ";";
                }
                if (TextUtils.isEmpty(tmpcookies)) {

                    if (headers != null) {
                        for (Header header : headers) {
                            String key = header.getName();
                            String value = header.getValue();
                            if (key.contains("Set-Cookie"))
                                tmpcookies += value + ";";
                        }
                        if (tmpcookies.length() > 0) {
                            tmpcookies = tmpcookies.substring(0, tmpcookies.length() - 1);
                        }
                    }
                }
                LogUtils.e("cookies:" + tmpcookies);

                // 改进没必要通过property形式写，直接用sp
                //AppContext.getInstance().setProperty(AppConfig.CONF_COOKIE, tmpcookies);
                SPUtils.saveToPrefs(this, AppConfig.CONF_COOKIE, tmpcookies);
                ApiHttpClient.setCookie(SPUtils.getFromPrefs(this, AppConfig.CONF_COOKIE, "0"));


                OSChinaApi.getUserInfo(new TextHttpResponseHandler() {
                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, String responseString) {

                        LogUtils.e(responseString);
                        Toast.makeText(LoginActivity.this, responseString, Toast.LENGTH_SHORT).show();

                        SPUtils.saveToPrefs(LoginActivity.this, AppConfig.OSCINFO, responseString);
                        finish();
                    }
                });
            }

        } else {
        }
    }
}
