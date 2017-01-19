package com.bingley.materialdesign.http.retrofit;

import com.bingley.materialdesign.AppConfig;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

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
            /**
             *  拦截器
             */
            httpClientBuilder.addInterceptor(new Interceptor() {
                @Override
                public okhttp3.Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();

                    HttpUrl.Builder authorizedUrlBuilder = request.url()
                            .newBuilder()
                            //添加统一参数 如手机唯一标识符,token等
                            .addQueryParameter("key1", "value1")
                            .addQueryParameter("key2", "value2");

                    Request newRequest = request.newBuilder()
                            //对所有请求添加请求头
                            .header("mobileFlag", "adfsaeefe").addHeader("type", "4")
                            .method(request.method(), request.body())
                            .url(authorizedUrlBuilder.build())
                            .build();
                    return chain.proceed(newRequest);
                }
            });


            SERVICE = new Retrofit.Builder()
                    .client(httpClientBuilder.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .baseUrl(AppConfig.HOST)
                    .build().create(ApiService.class);


        }

        return SERVICE;
    }
}
