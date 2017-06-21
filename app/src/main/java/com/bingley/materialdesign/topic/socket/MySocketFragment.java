package com.bingley.materialdesign.topic.socket;

import android.view.View;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseFragment;
import com.bingley.materialdesign.utils.LogUtils;
import com.vilyever.socketclient.SocketClient;

import java.net.Socket;

import butterknife.OnClick;

/**
 * Author:  Mr.bingley
 * Version:
 * Date:  2017/3/14
 */

public class MySocketFragment extends BaseFragment {

    private SocketManager2 socketManger;
    private SocketClient localSocketClient;
    private Socket socket;

    @Override
    protected int getLayoutId() {
        return R.layout.frg_socket;
    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);
        socketManger = new SocketManager2();
        localSocketClient = socketManger.getLocalSocketClient();
    }

    @OnClick({R.id.bt_connet, R.id.bt_send})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_connet:
               socketManger.connect(localSocketClient);
                LogUtils.e("loging");

                break;
            case R.id.bt_send:

                localSocketClient.sendString("V0.1000000640000100100000000000000000{\"1\":\"1111\",\"91\":\"a123456\"}");
                break;
        }
    }


}
