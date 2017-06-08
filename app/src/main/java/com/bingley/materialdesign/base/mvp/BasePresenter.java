package com.bingley.materialdesign.base.mvp;

import android.util.Log;

import com.bingley.materialdesign.BuildConfig;
import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.mvp.exception.NetworkTimeOutException;
import com.bingley.materialdesign.base.mvp.exception.NoNetworkException;
import com.bingley.materialdesign.base.mvp.exception.ResultEmptyException;
import com.bingley.materialdesign.base.mvp.exception.ResultFailedException;
import com.bingley.materialdesign.base.mvp.exception.ResultParseException;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
   *
   * Author:  Mr.bingley
   * Version:
   * Date:  2017/6/8
   */

public abstract class BasePresenter<T extends BaseView>{
    protected T baseView;

    private CompositeSubscription compositeSubscription;

    /**
     * 通常在 onResume 时调用此方法
     *
     * @param baseView
     */
    public void attachView(T baseView) {
        this.baseView = baseView;

        if(compositeSubscription == null) {
            compositeSubscription = new CompositeSubscription();
            initSubscription();
        }
    }

    /**
     * 通常在 onPause 时调用此方法
     */
    public void detachView() {
        if(compositeSubscription != null) {
            compositeSubscription.unsubscribe();
            compositeSubscription = null;
        }
    }

    protected void initSubscription() {}

    protected void addSubscription(Subscription subscription) {
        if(compositeSubscription == null) {
            subscription.unsubscribe();
        } else {
            compositeSubscription.add(subscription);
        }
    }

    /**
     * how o use?
     * 比如我程序发一个错误exception（是要明确的指出exception吗），（其实这个思路相当于自己在smartstrade中写的错误码处理逻辑）
     *
     * BuildConfig 这个奇怪了，这是从哪里来的，怎么会自动生成的？
     *
     * @param requestCode
     * @param throwable
     */
    protected void handleError(int requestCode, Throwable throwable) {
        final String errMessage;

        if(throwable instanceof NoNetworkException) { // 没有网络
            errMessage = "onNoNetworkError --> " + requestCode;
            baseView.onNoNetworkError(requestCode);

        } else if(throwable instanceof NetworkTimeOutException) { // 网络超时
            errMessage = "onNetworkTimeOutError --> " + requestCode;
            baseView.onNetworkTimeOutError(requestCode);

        } else if(throwable instanceof ResultParseException) { // 服务器返回的 JSON 数据解析错误
            errMessage = "onResultParseError --> " + requestCode;
            baseView.onResultParseError(requestCode);

        } else if(throwable instanceof ResultEmptyException) { // 服务器返回结果为空
            errMessage = "onResultEmpty --> " + requestCode;
            baseView.onResultEmpty(requestCode);

        } else if(throwable instanceof ResultFailedException) { // 服务器返回错误码
            errMessage = "onResultFailed --> " + requestCode;
            baseView.onResultFailed(requestCode,
                    ((ResultFailedException) throwable).getErrCode(),
                    ((ResultFailedException) throwable).getErrMessage());

        } else { // 其它不知道的错误，除非在设置UI时发生了错误，否则不会走到这里
            errMessage = "Warning_Unknow -->" + requestCode;
            baseView.onShowWarning(requestCode, R.string.Warning_Unknow);
        }


        if(BuildConfig.DEBUG) {    // 可见类似于输出信息的语句，要有全局的开关来控制的。
            Log.e("BasePresenter", "##d handleError: " + errMessage);
            throwable.printStackTrace();
        }
    }
}
