package com.weytenera.xsq;

import com.bingley.materialdesign.MyApplication;

/**
 * Created by Administrator on 2016/9/26 0026.
 */
public class BaseConfig {


    public static final String WX_APPID="wxf6b65c50cf2e87d1";
    public static final String WX_KEY="63f6166cc3a6841b5e2e0392fe3fc3f2";



    //正式https
    public static final String HOST= MyApplication.release?"https://www.xsq518.com/":"https://www.51zlcm.com/";//host  8800
    public static final String IMG=MyApplication.release?"http://www.xsq518.com:4000/":"http://www.51zlcm.com:8080/";//host
    public static final String HTML5 =MyApplication.release?"http://www.xsq518.com/":"http://www.51zlcm.com/";//4005



    //http
    public static final String HOST1=MyApplication.release?"http://www.xsq518.com:4000/":"http://www.51zlcm.com:8080/";//host  8800
    public static final String IMG1=MyApplication.release?"http://www.xsq518.com:4000/":"http://www.51zlcm.com:8080/";//host


    //测试
//    public static final String HOST="http://120.76.153.166:4000/";//host
//    public static final String IMG="http://120.76.153.166:4000/";//host




//    public static final String IMG="http://120.76.153.166:4000";//img

    public static final String INFOMATION= HTML5 +"/MobileHome/InformationDetail?HideHeader=1&Id=";//新闻
    public static final String NOTIES= HTML5 +"/MobileHome/NoticeDetail?HideHeader=1&Id=";//公告
    public static final String HUODONG= HTML5 +"/MobileHome/ActivityDetail?HideHeader=1&Id=";//活动
    public static final String POLICY= HTML5 +"/MobileHome/PolicyDetail?HideHeader=1&Id=";//政策
    public static final String GOODDETAIL= HTML5 +"/MobileHome/ProductDetail?HideHeader=1&Id=";//商品详情。
    public static final String COURSE= HTML5 +"/MobileHome/MediaLectureDetail?HideHeader=1&Id=";//课程详情。
    public static final String CARD= HTML5 +"/MobileHome/ShowCard?UserId=";//课程详情。

//    public static final String HOST="http://api.map.baidu.com/";

}
