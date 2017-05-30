package com.bingley.materialdesign;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.bingley.materialdesign.api.Engine;
import com.bingley.materialdesign.base.BaseApplication;
import com.bingley.materialdesign.http.asy.ApiHttpClient;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.PersistentCookieStore;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.https.HttpsUtils;
import com.zhy.http.okhttp.log.LoggerInterceptor;

import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.annotation.ReportsCrashes;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * $Description:$
 * Author:  Mr.bingley
 * Version:
 * Date:  2017/4/8
 */
@ReportsCrashes(
        reportSenderFactoryClasses = {com.bingley.materialdesign.mvp.acra.YourOwnSenderfactory.class},  // 是.class
        customReportContent = {ReportField.APP_VERSION_CODE, ReportField.APP_VERSION_NAME, ReportField.ANDROID_VERSION, ReportField.PHONE_MODEL, ReportField.CUSTOM_DATA, ReportField.STACK_TRACE, ReportField.LOGCAT},
        resToastText = R.string.msg_acra_toast
)
public class AppContext extends BaseApplication {
    private static AppContext instance;


    private Engine mEngine;

    @Override
    public void onCreate() {
        ACRA.init(this);
        super.onCreate();
        instance = this;
        //System.out.println(1 / 0);
        init();
    }

    /**
     * 获得当前app运行的AppContext
     *
     * @return
     */
    public static AppContext getInstance() {
        return instance;
    }

    private void init() {
        AppCrashHandler handler = AppCrashHandler.getInstance();
        // 如果加了这句话app报错的话，不会提醒程序方面的语言。所以平常开发的时候还是给他注释掉把
        //handler.init(this);

        // Log控制器


        initRetrofit();

        // 初始化网络请求
        initAsyNet();

        initOkhttp();
    }

    private void initRetrofit() {
        mEngine = new Retrofit.Builder()
                .baseUrl("http://7xk9dj.com1.z0.glb.clouddn.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(Engine.class);
    }


    public Engine getEngine() {
        return mEngine;
    }

    private void initOkhttp() {
    /* ClearableCookieJar cookieJar1 = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(getApplicationContext()));

     HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null, null, null);

     OkHttpClient okHttpClient = new OkHttpClient.Builder()
             .connectTimeout(10000L, TimeUnit.MILLISECONDS)
             .readTimeout(10000L, TimeUnit.MILLISECONDS)
             .addInterceptor(new LoggerInterceptor("TAG"))
             .cookieJar(cookieJar1)
             .hostnameVerifier(new HostnameVerifier()
             {
                 @Override
                 public boolean verify(String hostname, SSLSession session)
                 {
                     return true;
                 }
             })
             .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
             .build();
     OkHttpUtils.initClient(okHttpClient);*/
    }

    private void initAsyNet() {
        AsyncHttpClient client = new AsyncHttpClient();
        PersistentCookieStore myCookieStore = new PersistentCookieStore(this);
        client.setCookieStore(myCookieStore);
        ApiHttpClient.setHttpClient(client);
        ApiHttpClient.setCookie(ApiHttpClient.getCookie(this));
    }

    /**
     * 获取App安装包信息
     *
     * @return
     */
    public PackageInfo getPackageInfo() {
        PackageInfo info = null;
        try {
            info = getPackageManager().getPackageInfo(getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace(System.err);
        }
        if (info == null)
            info = new PackageInfo();
        return info;
    }

    public static Gson createGson() {
        com.google.gson.GsonBuilder gsonBuilder = new com.google.gson.GsonBuilder();
        //gsonBuilder.setExclusionStrategies(new SpecificClassExclusionStrategy(null, Model.class));
        gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss");
        return gsonBuilder.create();
    }
}
