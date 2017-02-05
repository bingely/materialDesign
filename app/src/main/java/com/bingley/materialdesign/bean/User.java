package com.bingley.materialdesign.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
   * parcelable接口示例代码
   * Author:  Mr.bingley
   * Version:
   * Date:  2017/2/4
   */

public class User implements Parcelable{
    public int userId;
    public String userName;
    public boolean isMale;


    protected User(int userId,String userName,boolean isMale) {
        this.userId = userId;
        this.userName = userName;
        this.isMale = isMale;
    }


    // 这下面两个方法是自动生成的
    protected User(Parcel in) {
        userId = in.readInt();
        userName = in.readString();
        isMale = in.readInt() != 0;        // 这个有修改
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(userId);
        dest.writeString(userName);
        dest.writeByte((byte) (isMale ? 1 : 0));
    }
}
