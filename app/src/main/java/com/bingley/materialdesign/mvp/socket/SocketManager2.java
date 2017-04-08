package com.bingley.materialdesign.mvp.socket;

import android.support.annotation.NonNull;

import com.bingley.materialdesign.AppConfig;
import com.bingley.materialdesign.utils.LogUtils;
import com.vilyever.socketclient.SocketClient;
import com.vilyever.socketclient.helper.SocketClientDelegate;
import com.vilyever.socketclient.helper.SocketClientSendingDelegate;
import com.vilyever.socketclient.helper.SocketPacket;
import com.vilyever.socketclient.helper.SocketPacketHelper;
import com.vilyever.socketclient.helper.SocketResponsePacket;
import com.vilyever.socketclient.util.CharsetUtil;

/**
   *
   * Author:  Mr.bingley
   * Version:
   * Date:  2017/3/14
   */

public class SocketManager2 {
    private SocketClient localSocketClient;


    public SocketClient getLocalSocketClient() {
        if (localSocketClient == null) {
            localSocketClient = new SocketClient();
            setupAddress(localSocketClient);
            setupEncoding(localSocketClient);
            localSocketClient.getHeartBeatHelper().setHeartBeatInterval(1000 * 30);

            localSocketClient.getHeartBeatHelper().setSendString(null);
        }

        localSocketClient.registerSocketClientDelegate(new SocketClientDelegate() {
            @Override
            public void onConnected(SocketClient client) {
                LogUtils.e("connect");
                SocketPacket packet = localSocketClient.sendData(new byte[]{0x02}); // 发送消息
               // packet = localSocketClient.sendString("sy hi!"); // 发送消息

                localSocketClient.cancelSend(packet); // 取消发送，若在等待发送队列中则从队列中移除，若已发送完成则无法取消，若正在发送且分段发送则取消发送剩余数据（此时若没有设置包头用于远程端判断下一个信息包的开始可能出现粘包或数据不全问题）
            }

            @Override
            public void onDisconnected(SocketClient client) {
                // 断开连接回调，可在此实现自动重连
                localSocketClient.connect();
            }

            @Override
            public void onResponse(SocketClient client, @NonNull SocketResponsePacket responsePacket) {
                byte[] data = responsePacket.getData(); // 获取接收的byte数组，不为null
                String message = responsePacket.getMessage(); // 获取按默认设置的编码转化的String，可能为null
                LogUtils.e(message);
            }
        });


        return localSocketClient;
    }

    /* Public Methods */
    public void connect(SocketClient socketClient) {
        socketClient.connect();
    }


    /**
     * 设置远程端地址信息
     */
    private void setupAddress(SocketClient socketClient) {
        socketClient.getAddress().setRemoteIP(AppConfig.REMOTE_IP); // 远程端IP地址
        socketClient.getAddress().setRemotePort(Integer.parseInt(AppConfig.REMOTE_PORT)); // 远程端端口号
        socketClient.getAddress().setConnectionTimeout(1 * 1000); // 连接超时时长，单位毫秒
    }

    /**
     * 设置自动转换String类型到byte[]类型的编码
     * 如未设置（默认为null），将不能使用{@link SocketClient#sendString(String)}发送消息
     * 如设置为非null（如UTF-8），在接受消息时会自动尝试在接收线程（非主线程）将接收的byte[]数据依照编码转换为String，在{@link SocketResponsePacket#getMessage()}读取
     */
    private void setupEncoding(SocketClient socketClient) {
        socketClient.setCharsetName(CharsetUtil.UTF_8); // 设置编码为UTF-8
    }
}
