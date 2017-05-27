package com.bingley.materialdesign.base;

/**
 * 一般的返回数据体结构
 *
 * @param <T>
 */

/**
 how to use？
 T 就是代表一个实体，代表任意类型
 */
public class HttpResult<T> {

    private int code;
    private String message;
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
