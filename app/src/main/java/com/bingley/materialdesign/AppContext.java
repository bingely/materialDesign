package com.bingley.materialdesign;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.bingley.materialdesign.base.BaseApplication;

/**
 * Created by Administrator on 2017/1/19.
 */
public class AppContext extends BaseApplication{
    public static final int PAGE_SIZE = 20;// 默认分页大小
    private static AppContext instance;
    private long loginUid;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        init();
        //initLogin();
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

        // 初始化网络请求
        /*AsyncHttpClient client = new AsyncHttpClient();
        PersistentCookieStore myCookieStore = new PersistentCookieStore(this);
        client.setCookieStore(myCookieStore);
        ApiHttpClient.setHttpClient(client);
        ApiHttpClient.setCookie(ApiHttpClient.getCookie(this));*/

        // Log控制器

        // Bitmap缓存地址
    }

    /**
     * 获取App唯一标识
     *
     * @return
     */
    public String getAppId() {
        return "";
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

}
