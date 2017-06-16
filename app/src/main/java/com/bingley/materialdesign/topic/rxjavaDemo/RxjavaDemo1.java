package com.bingley.materialdesign.topic.rxjavaDemo;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/**
 * Created by SAM on 2017/6/14.
 */

public class RxjavaDemo1 {
    public static void main(String[] args) {

    }

    public void method1() {
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("hi");
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                //数据接收完成时调用
            }

            @Override
            public void onError(Throwable e) {
                //发生错误调用
            }

            @Override
            public void onNext(String s) {
                //正常接收数据调用
                System.out.print(s);  //将接收到来自sender的问候"Hi，Weavey！"
            }
        });
    }
}
