package com.bingley.materialdesign.mvp.sqlite.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bingley.materialdesign.mvp.sqlite.MyDBOpenHelper;

/**
 * 联系人数据库表的访问类(增删改查）---原始的方式
 * Author:  Mr.bingley
 * Version:
 * Date:  2017/1/11
 */



public class ContactInfoDao {
    /**
     * 数据库打开的帮助类
     */
    private MyDBOpenHelper helper;

    /**
     * 在构造方法里面完成 必须要用的类的初始化
     *
     * @param context
     */
    public ContactInfoDao(Context context) {
        helper = new MyDBOpenHelper(context);
    }

    /**
     * 添加一条记录
     *
     * @param name  联系人姓名
     * @param phone 联系人电话
     */
    public void add(String name, String phone) {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("insert into contactinfo (name,phone) values (?,?)", new Object[]{name, phone});
        //记得释放数据库资源
        db.close();
    }

    /**
     * 根据姓名删除一条记录
     * @param name 要删除的联系人的姓名
     */
    public void delete(String name){
        //判断这个数据是否存在.
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("delete from contactinfo where name=?", new Object[]{name});
        db.close();
        //再从数据库里面查询一遍,看name是否还在
    }
    /**
     * 修改联系人电话号码
     * @param newphone 新的电话号码
     * @param name 要修改的联系人姓名
     */
    public void update(String newphone , String name){
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("update contactinfo set phone =? where name=?", new Object[]{newphone,name});
        db.close();
    }


    /**
     * 查询联系人的电话号码   因为是读取的动作getReadableDatabase()，其余都是getWritableDatabase()----所以查是比较特殊的
     * @param name 要查询的联系人
     * @return 电话号码
     */
    public String getPhoneNumber(String name){
        String phone = null;
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select phone from contactinfo where name=?", new String[]{name});
        if(cursor.moveToNext()){//如果光标可以移动到下一位,代表就是查询到了数据
            phone = cursor.getString(0);
        }
        cursor.close();//关闭掉游标,释放资源
        db.close();//关闭数据库,释放资源
        return phone;
    }
}
