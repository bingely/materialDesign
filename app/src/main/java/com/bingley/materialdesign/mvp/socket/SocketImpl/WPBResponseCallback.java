package com.bingley.materialdesign.mvp.socket.SocketImpl;


import com.bingley.materialdesign.mvp.socket.tcp.Packet;

/**
 * Created by demi on 16/10/19.
 */
public abstract class WPBResponseCallback {

    public abstract void onSucess(Packet packet);

}
