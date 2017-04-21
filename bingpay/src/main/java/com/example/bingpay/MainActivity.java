package com.example.bingpay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/*
* 一个是你的AIDL文件与它的Service所在的Module ---- 作为aidl示例代码
*
* */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       /*
        这个项目难在什么地方呢？？？
        第一 socket通讯（我存在无法获取消息的苦恼）
        第二 K线图的绘制
        第三  协议的理解

        这尼玛不是人做的事啊，太尼玛的难了。
        时间在慢慢的流逝当中，而自己的进度又是没有进展啊，苦恼苦恼

        */
    }
}
