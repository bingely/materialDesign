package com.example.bingpay.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.example.bingpay.ICat;

public class AidlService extends Service {
    private CatBinder catBinder;

    //此处要继承Stub,实现ICat和IBinder接口
    public class CatBinder extends ICat.Stub
    {
        @Override
        public String getColor() throws RemoteException {
            return "get from remote service";
        }

        @Override
        public double getWeight() throws RemoteException {
            return 999.9;
        }
    }

    public AidlService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        catBinder = new CatBinder();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return catBinder;
    }

    @Override
    public void onDestroy() {
        System.out.println("remote service destroy");
    }
}
