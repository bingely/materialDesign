package com.bingley.materialdesign.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * $Description:$
 * Author:  Mr.bingley
 * Version:
 * Date:  2017/1/6
 */

public class ApiService {
    private static ApiService SERVICE;
    /**
     * 请求超时时间
     */
    private static final int DEFAUT_TIMEOUT = 1000;

    public static ApiService getDefault() {
        if (SERVICE == null) {
            // 手动创建OKhttpClient并设置超时时间
            OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
            httpClientBuilder.connectTimeout(DEFAUT_TIMEOUT, TimeUnit.SECONDS);
        }
        




        return null;
    }
}
