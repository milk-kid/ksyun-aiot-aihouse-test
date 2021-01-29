package com.ksyun.aiot.utils;

import java.util.Objects;

public class DeviceKey {
    private String deviceId;
    private long eventId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceKey deviceKey = (DeviceKey) o;
        return eventId == deviceKey.eventId && Objects.equals(deviceId, deviceKey.deviceId);
    }

    @Override
    public String toString() {
        return "DeviceKey{" +
                "deviceId='" + deviceId + '\'' +
                ", eventId=" + eventId +
                '}';
    }
}
