package com.bingley.materialdesign.http.retrofit;


import com.bingley.materialdesign.AppConfig;
import com.bingley.materialdesign.AppContext;
import com.bingley.materialdesign.BuildConfig;
import com.bingley.materialdesign.utils.TDevice;

import java.io.File;
import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 封装极好的retrofit
 * Author:  Mr.bingley
 * Version:
 * Date:  2017/6/10
 * http://wuxiaolong.me/2016/06/18/retrofits/  还要看接口参数的传递
 */

/*
* bug
* 这种方式添加的公共参数在POST请求方式中是用不了的  -=---是真的吗？
* */
public class CustomRetrofit {
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofit() {

        if (retrofit == null) {
            // OkHttpClient  Retrofit 装饰者模式
            OkHttpClient.Builder builder = new OkHttpClient.Builder();

            /**
             *设置缓存，代码略
             */
            catheInterceptor(builder);
            /**
             *  公共参数，代码略
             */
            parampublicIntercepter(builder);
            /**
             * 设置头，代码略
             */
            headIntercepter(builder);
            /**
             * Log信息拦截器，代码略
             */
            logInterceptor(builder);

            /**
             * 设置cookie，代码略
             */
            cookieInterceptor(builder);
            /**
             * 设置超时和重连，代码略
             */
            timeInterpolator(builder);


    /*       builder.addInterceptor(BaseApplication.release ? new HttpLoggingInterceptor()
                            .setLevel(HttpLoggingInterceptor.Level.NONE) : new HttpLoggingInterceptor()
                            .setLevel(HttpLoggingInterceptor.Level.BODY));*/

            //以上设置结束，才能build(),不然设置白搭
            OkHttpClient okHttpClient = builder.build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(AppConfig.HOST)
                    //设置 Json 转换器
                    .addConverterFactory(GsonConverterFactory.create())
                    //RxJava 适配器
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }


    /**
     * 设置超时和重连
     *
     * @param builder
     */
    private static void timeInterpolator(OkHttpClient.Builder builder) {
        //设置超时
        builder.connectTimeout(15, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);
    }

    /**
     * 设置cookie
     *
     * @param builder
     */
    private static void cookieInterceptor(OkHttpClient.Builder builder) {
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        builder.cookieJar(new JavaNetCookieJar(cookieManager));
    }

    /**
     * 缓存机制(无网络时，也能显示数据)
     *
     * @param builder
     */
    private static void catheInterceptor(OkHttpClient.Builder builder) {
        File cacheFile = new File(AppContext.getInstance().getExternalCacheDir(), "WuXiaolongCache");
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!TDevice.hasInternet()) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }

                Response response = chain.proceed(request);
                if (TDevice.hasInternet()) {
                    int maxAge = 0;
                    // 有网络时 设置缓存超时时间0个小时
                    response.newBuilder()
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .removeHeader("WuXiaolong")// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                            .build();
                } else {
                    // 无网络时，设置超时为4周
                    int maxStale = 60 * 60 * 24 * 28;
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("nyn")
                            .build();
                }
                return response;
            }
        };
        builder.cache(cache).addInterceptor(cacheInterceptor);
    }

    /**
     * Log信息拦截器
     *
     * @param builder
     */
    private static void logInterceptor(OkHttpClient.Builder builder) {
        if (BuildConfig.DEBUG) {
            // Log信息拦截器
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            //设置 Debug Log 模式
            builder.addInterceptor(loggingInterceptor);
        }
    }

    /**
     * 设置公共参数(可能接口有某些参数是公共的，不可能一个个接口都去加吧)
     * 那下次如果同时设置公共方法、公共头、公共参数该怎么写？ ---在 .addInterceptor(headerInterceptor)
     * String method = originalRequest.method();
     * Headers headers = originalRequest.headers();
     */
    private static void parampublicIntercepter(OkHttpClient.Builder builder) {
        //公共参数
        Interceptor addQueryParameterInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request request;
                String method = originalRequest.method();
                Headers headers = originalRequest.headers();
                HttpUrl modifiedUrl = originalRequest.url().newBuilder()
                        // Provide your custom parameter here
                        .addQueryParameter("platform", "android")
                        .addQueryParameter("version", "1.0.0")
                        .build();
                request = originalRequest.newBuilder().url(modifiedUrl).build();
                return chain.proceed(request);
            }
        };
        //公共参数
        builder.addInterceptor(addQueryParameterInterceptor);
    }


    /**
     * 设置头( 有的接口可能对请求头要设置)
     */
    private static void headIntercepter(OkHttpClient.Builder builder) {
        Interceptor headerInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request.Builder requestBuilder = originalRequest.newBuilder()
                        .header("AppType", "TPOS")
                        .header("Content-Type", "application/json")
                        .header("Accept", "application/json")
                        .header("charset", "utf-8")
                        .header("access-Key", "123456789")
                        .method(originalRequest.method(), originalRequest.body());
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        };
        //设置头
        builder.addInterceptor(headerInterceptor);
    }


}
