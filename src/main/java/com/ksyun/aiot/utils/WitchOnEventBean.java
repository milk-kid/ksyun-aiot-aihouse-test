package com.ksyun.aiot.utils;

/**
 * Copyright 2021 json.cn
 */

import lombok.ToString;

/**
 * Auto-generated: 2021-01-27 15:14:33
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@ToString
public class WitchOnEventBean {

    private String deviceId;
    private long eventId;
    private String messageCode;
    private int messageType;
    private String model;
    private String name;
    private String nodeId;
    private String parentDeviceId;
    private String propertyCode;
    private String rootDevice;
    private String sn;
    private long time;
    private String value;

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public long getEventId() {
        return eventId;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setParentDeviceId(String parentDeviceId) {
        this.parentDeviceId = parentDeviceId;
    }

    public String getParentDeviceId() {
        return parentDeviceId;
    }

    public void setPropertyCode(String propertyCode) {
        this.propertyCode = propertyCode;
    }

    public String getPropertyCode() {
        return propertyCode;
    }

    public void setRootDevice(String rootDevice) {
        this.rootDevice = rootDevice;
    }

    public String getRootDevice() {
        return rootDevice;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getSn() {
        return sn;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getTime() {
        return time;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}