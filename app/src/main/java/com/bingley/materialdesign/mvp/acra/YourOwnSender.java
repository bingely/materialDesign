package com.bingley.materialdesign.mvp.acra;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import org.acra.collector.CrashReportData;
import org.acra.sender.ReportSender;
import org.acra.sender.ReportSenderException;

 /**
   * $Description:$
   * Author:  Mr.bingley
   * Version: 
   * Date:  2017/5/30
   */

public class YourOwnSender implements ReportSender {
    @Override
    public void send(@NonNull Context context, @NonNull CrashReportData crashReportData) throws ReportSenderException {
        //发送邮件
       Log.i("YourOwnSender", "send: " + crashReportData.toJSON());
        Mail mail=new Mail("13537688026@163.com","13537688026");
        mail.set_to(new String[]{"13537688026@163.com"});//接受者邮箱 可以是多个
        mail.set_from("13537688026@163.com");//邮件来源     ---这个得写成邮件的是形式，不能写其他的
        mail.set_subject("错误日志");//设置主题标题
        mail.setBody(crashReportData.toString());
        try {
            if( mail.send()){
                Log.i("YourOwnSender", "send: 发送成功");
            }else{
                Log.i("YourOwnSender", "send: 发送失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
