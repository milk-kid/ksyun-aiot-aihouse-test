package com.ksyun.aiot.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Slf4j
public class Timekeeper {
    private int count = 0;
    private boolean flag = true;

    private HashMap<String, Integer> map = new HashMap<>();

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    /**
     * 统计相同key一共又多少个
     *
     * @param key
     */
    public void setCount(String key) {

        if (map.containsKey(key)) {
            Integer count = map.get(key);
            count += 1;
            map.put(key, count);
        } else {
            map.put(key, 1);
        }
    }

    public int getkeyCount(String key) {
        return map.get(key);
    }

    public void showMap() {
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            log.info("deviceId = {} , 执行次数 = {}", entry.getKey(), entry.getValue());
        }
    }
}
