package com.bingley.materialdesign.mvp.socket;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bingley.materialdesign.AppConfig;
import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseFragment;
import com.bingley.materialdesign.mvp.socket.tcp.SocketConnection;
import com.bingley.materialdesign.utils.LogUtils;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.socketio.Acknowledge;
import com.koushikdutta.async.http.socketio.ConnectCallback;
import com.koushikdutta.async.http.socketio.EventCallback;
import com.koushikdutta.async.http.socketio.JSONCallback;
import com.koushikdutta.async.http.socketio.SocketIOClient;
import com.vilyever.socketclient.SocketClient;
import com.vilyever.socketclient.helper.SocketClientDelegate;
import com.vilyever.socketclient.helper.SocketClientReceivingDelegate;
import com.vilyever.socketclient.helper.SocketClientSendingDelegate;
import com.vilyever.socketclient.helper.SocketPacket;
import com.vilyever.socketclient.helper.SocketPacketHelper;
import com.vilyever.socketclient.helper.SocketResponsePacket;
import com.vilyever.socketclient.util.CharsetUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.Arrays;

import butterknife.OnClick;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

/**
 * Author:  Mr.bingley
 * Version:
 * Date:  2017/3/14
 */

public class MySocketFragment extends BaseFragment {

    private SocketManager socketManger;
    private SocketClient localSocketClient;
    private Socket socket;

    @Override
    protected int getLayoutId() {
        return R.layout.frg_socket;
    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);


        socketManger = new SocketManager();

       try {
            socket = IO.socket("http://192.168.10.234:60000");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                socket.emit("foo", "hi");
                //socket.disconnect();

                LogUtils.e("call0");

                /*JSONObject obj = (JSONObject)args[0];
                LogUtils.e("call0"+obj.toString());*/
            }

        }).on("event", new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                LogUtils.e("event");
            }

        }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                LogUtils.e("diconnect");
            }

        });
    }

    @OnClick({R.id.bt_connet, R.id.bt_send})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_connet:
               //socketManger.connect(localSocketClient);

                socket.connect();

                socket.on("login", onLogin);
                LogUtils.e("loging");

                break;
            case R.id.bt_send:
                //localSocketClient.sendString("hello");
                JSONObject obj1 = new JSONObject();
                try {
                    obj1.put("hello", "server");
                    obj1.put("binary", "hljlasdf");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                socket.emit("foo", obj1);
                break;
        }
    }


    private Emitter.Listener onLogin = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            LogUtils.e("call");
           /* JSONObject data = (JSONObject) args[0];

            int numUsers;
            try {
                numUsers = data.getInt("numUsers");
            } catch (JSONException e) {
                return;
            }*/

        }
    };


}
