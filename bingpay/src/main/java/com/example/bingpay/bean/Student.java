package com.example.bingpay.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 *
 * 假设你是要通过AIDL传递复杂的数据，比如Student这样类似的一个java bean
 * 必须实现Parcelable，不如就不能AIDL了
 */
public class Student implements Parcelable {

    public String name;
    public int age;
    public int sex;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.age);
        dest.writeInt(this.sex);
    }

    public Student() {
    }

    protected Student(Parcel in) {
        this.name = in.readString();
        this.age = in.readInt();
        this.sex = in.readInt();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
}
