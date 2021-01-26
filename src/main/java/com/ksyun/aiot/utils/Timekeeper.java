package com.ksyun.aiot.utils;

import sun.awt.image.IntegerComponentRaster;

import java.util.HashMap;

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
            if (count == 0) {
                count = 1;
            } else {
                count += 1;
            }
            map.put(key, count);
        }
    }

    public int getkeyCount(String key) {
        return map.get(key);
    }

}
