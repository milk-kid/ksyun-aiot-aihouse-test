package com.ksyun.aiot.callback;

public class EventObject extends java.util.EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public EventObject(Object source) {
        super(source);
    }

    /**
     * 解析msg 为map
     */
    public void doEvent(){
    }
}
