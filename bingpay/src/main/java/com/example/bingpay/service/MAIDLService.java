package com.example.bingpay.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.example.bingpay.IMyAidlInterface;


/**
 * 放的位置有讲究没？
 */
public class MAIDLService extends Service {
    public class MAIDLServiceImpl extends IMyAidlInterface.Stub{
        @Override
        public String getValue() throws RemoteException {
            return "get value";
        }
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MAIDLServiceImpl();
    }
}
