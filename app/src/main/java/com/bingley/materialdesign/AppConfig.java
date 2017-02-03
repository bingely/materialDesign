package com.bingley.materialdesign;

import android.os.Environment;

import com.bingley.materialdesign.base.BaseApplication;

import java.io.File;

/**
 * Created by Administrator on 2016/9/26 0026.
 */
public class AppConfig {

   public static final String HOST= BaseApplication.release?"https://www.xsq518.com/":"https://www.51zlcm.com/";//host  8800
    public static final String IMG= BaseApplication.release?"http://www.xsq518.com:4000/":"http://www.51zlcm.com:8080/";//host
    public static final String HTML5 = BaseApplication.release?"http://www.xsq518.com/":"http://www.51zlcm.com/";//4005



    private final static String APP_CONFIG = "config";

    public final static String CONF_COOKIE = "cookie";
    // 默认存放图片的路径
    public final static String DEFAULT_SAVE_IMAGE_PATH = Environment
            .getExternalStorageDirectory()
            + File.separator
            + "OSChina"
            + File.separator + "osc_img" + File.separator;

    // 默认存放文件下载的路径
    public final static String DEFAULT_SAVE_FILE_PATH = Environment
            .getExternalStorageDirectory()
            + File.separator
            + "OSChina"
            + File.separator + "download" + File.separator;
}
