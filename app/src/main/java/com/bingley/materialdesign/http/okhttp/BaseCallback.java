package com.bingley.materialdesign.http.okhttp;

import com.google.gson.internal.$Gson$Types;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Administrator on 2017/1/31.
 */

public abstract class BaseCallback<T> {
    public Type mType;

    public BaseCallback()
    {
        mType = getSuperclassTypeParameter(getClass());
    }


    // 这里有个疑问request这两个包会不一样吗，retroift自带的okhttp3是什么东西
    public abstract void onBeforeRequest(Request request);

    public abstract void onFailure(Request request, IOException e);

    /**
     *请求成功时调用此方法
     * @param response
     */
    public abstract  void onResponse(Response response);
    /**
     *
     * 状态码大于200，小于300 时调用此方法
     * @param response
     * @param t
     * @throws IOException
     */
    public abstract void onSuccess(Response response,T t);

    /**
     * 状态码400，404，403，500等时调用此方法
     * @param response
     * @param code
     * @param e
     */
    public abstract void onError(Response response, int code,Exception e);



    static Type getSuperclassTypeParameter(Class<?> subclass)
    {
        Type superclass = subclass.getGenericSuperclass();
        if (superclass instanceof Class)
        {
            throw new RuntimeException("Missing type parameter.");
        }
        ParameterizedType parameterized = (ParameterizedType) superclass;
        return $Gson$Types.canonicalize(parameterized.getActualTypeArguments()[0]);
    }
}
