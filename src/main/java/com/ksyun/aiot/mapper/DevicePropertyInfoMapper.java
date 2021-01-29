package com.ksyun.aiot.mapper;

import com.ksyun.aiot.entity.DevicePropertyInfo;

public interface DevicePropertyInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DevicePropertyInfo record);

    int insertSelective(DevicePropertyInfo record);

    DevicePropertyInfo selectById(Long id);

    int updateByPrimaryKeySelective(DevicePropertyInfo record);

    int updateByPrimaryKey(DevicePropertyInfo record);
}