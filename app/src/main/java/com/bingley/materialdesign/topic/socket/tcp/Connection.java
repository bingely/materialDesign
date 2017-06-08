package com.bingley.materialdesign.topic.socket.tcp;

/**
 * Created by demi on 16/10/20.
 */
public interface Connection {
    void connect() throws Exception;

    void disconnect();

    boolean isConnected();
}
