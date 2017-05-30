package com.bingley.materialdesign.mvp.acra;

import android.content.Context;
import android.support.annotation.NonNull;

import org.acra.config.ACRAConfiguration;
import org.acra.sender.ReportSender;
import org.acra.sender.ReportSenderFactory;

/**
 * Created by Administrator on 2017/5/30.
 */

public class YourOwnSenderfactory implements ReportSenderFactory {
    /***
     * 注意这里必须要是空的构造方法
     */
    public YourOwnSenderfactory() {
    }

    @NonNull
    @Override
    public ReportSender create(@NonNull Context context, @NonNull ACRAConfiguration config) {
        return new YourOwnSender();
    }
}
