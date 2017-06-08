package com.bingley.materialdesign.topic.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * 数据库创建的帮助类 类似File类
 * Author:  Mr.bingley
 * Version:
 * Date:  2017/1/11
 */

public class MyDBOpenHelper extends SQLiteOpenHelper {
    /**
     * @param context 上下文
     */
    public MyDBOpenHelper(Context context) {
        //第二个参数数据库的名称
        //第三个参数null代表的是默认的游标工厂
        //第四个参数 是数据库的版本号  数据库只能升级,不能降级,版本号只能变大不能变小
        super(context, "bingley.db", null, 2);
    }

    /**
     * Called when the database is created for the first time.
     * 当数据库第一次被创建的时候调用的方法,适合在这个方法里面把数据库的表结构定义出来.
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e("bingley", "oncreate 数据库被创建了. 哈哈哈哈,嘎嘎嘎------------");
        db.execSQL("create table contactinfo (id integer primary key autoincrement, name varchar(20), phone varchar(20))");
    }


    /**
     * Called when the database needs to be upgraded.(当数据库更新的时候调用的方法)
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.e("bingley", "onUpgrade 数据库被更新了. oldVersion:"+oldVersion+"--------newVersion:"+newVersion+"----");
        db.execSQL("alter table contactinfo add account varchar(20)");
    }
}
