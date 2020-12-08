package com.ksyun.aiot.callback;


public interface EventListener extends java.util.EventListener {

    void handle(EventObject eventObject);
}
