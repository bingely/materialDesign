package com.bingley.materialdesign.topic.socket.SocketImpl;


import com.bingley.materialdesign.topic.socket.tcp.Packet;

/**
 * Created by demi on 16/10/19.
 */
public abstract class WPBResponseCallback {

    public abstract void onSucess(Packet packet);

}
