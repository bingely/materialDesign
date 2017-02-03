package com.bingley.materialdesign.mvp.osc.activity;


import android.widget.Toast;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseActivity;
import com.bingley.materialdesign.mvp.osc.OscApi;
import com.bingley.materialdesign.utils.LogUtils;
import com.bingley.materialdesign.utils.XmlUtils;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class LoginActivity extends BaseActivity {
    private final AsyncHttpResponseHandler mHandler = new AsyncHttpResponseHandler() {

        @Override
        public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
            /*LoginUserBean loginUserBean = XmlUtils.toBean(LoginUserBean.class, arg2);
            if (loginUserBean != null) {
                handleLoginBean(loginUserBean, arg1);
            }*/
            Toast.makeText(LoginActivity.this,new String(arg2), Toast.LENGTH_SHORT).show();
            LogUtils.e(new String(arg2));

        }

        @Override
        public void onFailure(int arg0, Header[] arg1, byte[] arg2,
                              Throwable arg3) {
            Toast.makeText(LoginActivity.this,"网络出错" + arg0, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onFinish() {
            super.onFinish();
            //hideWaitDialog();
        }
    };
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


        OscApi.login("linmb@qq.com", "lmbbest123", mHandler);
    }
}
