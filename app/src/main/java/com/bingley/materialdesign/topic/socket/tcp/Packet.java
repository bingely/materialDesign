package com.bingley.materialdesign.topic.socket.tcp;

/**
 * Base class for tcp packets. Every packet has a unique ID (which is automatically
 * generated, but can be overridden).
 */
public abstract class Packet {
    private long longPacketId;

    /**
     * Returns the packet as bytes.
     */
    public abstract byte[] toBytes();

    public abstract String getContent();

    /**
     * Returns the unique ID of the packet.
     */
    public abstract String getPacketID();

    public abstract void setPacketID(String packetID);

    public abstract int getCommand();

    public abstract void setCommand(int command);

    public String nextPacketID() {
        if (longPacketId == Long.MAX_VALUE) {
            longPacketId = 1;
        }
        return String.valueOf(Long.valueOf(longPacketId));
    }

}