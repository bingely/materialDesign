package com.bingley.materialdesign.topic.aidldemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Toast;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseFragment;
import com.example.bingpay.ICat;
import com.example.bingpay.IMyAidlInterface;

import butterknife.OnClick;

import static android.content.Context.BIND_AUTO_CREATE;

/**
 * Created by Administrator on 2017/2/8.
 */

public class MAIDLFragment extends BaseFragment {
    // 示例一
    private ICat catService;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            catService = ICat.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            catService = null;
        }
    };

    // 示例二
    private IMyAidlInterface mAidlInterface = null;
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mAidlInterface = IMyAidlInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mAidlInterface = null;
        }
    };

    @Override
    protected int getLayoutId() {
        return R.layout.frg_aidl;
    }


    @OnClick({R.id.example_one, R.id.example_two})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.example_one:
                Intent intent = new Intent();
                intent.setAction("com.sysu.aidlclient.action.AIDL_SERVICE");  // 这个是如何知道的？？？
                //this is important
                intent.setPackage("com.example.bingpay.service.AidlService");
                getActivity().bindService(intent, serviceConnection, BIND_AUTO_CREATE);
                break;
            case R.id.example_two:
                Intent intent2 = new Intent("com.example.bingpay.IMyAidlInterface");
                getActivity().bindService(intent2, mServiceConnection, BIND_AUTO_CREATE);
                try {
                    Toast.makeText(getActivity(), mAidlInterface.getValue(), Toast.LENGTH_SHORT).show();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
