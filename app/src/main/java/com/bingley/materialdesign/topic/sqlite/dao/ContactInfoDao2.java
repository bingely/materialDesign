package com.bingley.materialdesign.topic.sqlite.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bingley.materialdesign.topic.sqlite.MyDBOpenHelper;

 /**
   * 这个是谷歌api写法，与ContactInfoDao思路一样
   * Author:  Mr.bingley
   * Version:
   * Date:  2017/1/11
   */

public class ContactInfoDao2 {
    /**
     * 数据库打开的帮助类
     */
    private MyDBOpenHelper helper;

    /**
     * 在构造方法里面完成 必须要用的类的初始化
     * @param context
     */
    public ContactInfoDao2(Context context) {
        helper = new MyDBOpenHelper(context);
    }

    /**
     * 添加一条记录
     * @param name 联系人姓名
     * @param phone 联系人电话
     * @return 返回的是添加后在数据库的行号  -1代表添加失败
     */
    public long add(String name, String phone){
        SQLiteDatabase db = helper.getWritableDatabase();
        //db.execSQL("insert into contactinfo (name,phone) values (?,?)", new Object[]{name,phone});
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("phone", phone);
        //内部是组拼sql语句实现的.
        long rowid = db.insert("contactinfo", null, values);
        //记得释放数据库资源
        db.close();
        return rowid;
    }
    /**
     * 根据姓名删除一条记录
     * @param name 要删除的联系人的姓名
     * @return 返回0代表的是没有删除任何的记录 返回整数int值代表删除了几条数据
     */
    public int delete(String name){
        //判断这个数据是否存在.
        SQLiteDatabase db = helper.getWritableDatabase();
        //db.execSQL("delete from contactinfo where name=?", new Object[]{name});
        int rowcount = db.delete("contactinfo", "name=?", new String[]{name});
        db.close();
        //再从数据库里面查询一遍,看name是否还在
        return rowcount;
    }
    /**
     * 修改联系人电话号码
     * @param newphone 新的电话号码
     * @param name 要修改的联系人姓名
     * @return 0代表一行也没有更新成功, >0 整数代表的是更新了多少行记录
     */
    public int update(String newphone , String name){
        SQLiteDatabase db = helper.getWritableDatabase();
        //db.execSQL("update contactinfo set phone =? where name=?", new Object[]{newphone,name});
        ContentValues values = new ContentValues();
        values.put("phone", newphone);
        int rowcount =  db.update("contactinfo", values, "name=?", new String[]{name});
        db.close();
        return rowcount;
    }
    /**
     * 查询联系人的电话号码
     * @param name 要查询的联系人
     * @return 电话号码
     */
    public String getPhoneNumber(String name){
        String phone = null;
        SQLiteDatabase db = helper.getReadableDatabase();
        //Cursor  cursor = db.rawQuery("select phone from contactinfo where name=?", new String[]{name});
        Cursor cursor =  db.query("contactinfo", new String[]{"phone"}, "name=?", new String[]{name}, null, null, null);
        if(cursor.moveToNext()){//如果光标可以移动到下一位,代表就是查询到了数据
            phone = cursor.getString(0);
        }
        cursor.close();//关闭掉游标,释放资源
        db.close();//关闭数据库,释放资源
        return phone;
    }
}
