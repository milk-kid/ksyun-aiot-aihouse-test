package com.ksyun.aiot.entity;

import lombok.ToString;

import java.util.Date;
@ToString
public class DevicePropertyInfo {
    /**
    * 主键标识
    */
    private Long id;

    /**
    * 设备标识
    */
    private Long deviceId;

    /**
    * 属性名称
    */
    private String name;

    /**
    * 属性编码
    */
    private String code;

    /**
    * 属性缓存取值
    */
    private String value;

    /**
    * 属性权限,0 只读,1 可写
    */
    private Boolean permit;

    /**
    * 场景权限,e 触发,a 执行
    */
    private String scene;

    /**
    * 单位
    */
    private String unit;

    /**
    * 数据类型,int,float,enum,string
    */
    private String dataType;

    /**
    * 取值范围整形/浮点型[最小值,最大值,步长]
    */
    private String valueRange;

    /**
    * 枚举[{"value" : 1 ,"description":"取值描述"}]
    */
    private String valueLen;

    /**
    * 字符类型长度,单位字节
    */
    private Integer maxLength;

    /**
    * 属性描述
    */
    private String description;

    /**
    * 结合删除标记使用
    */
    private String remark;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 修改时间
    */
    private Date updateTime;

    /**
    * 逻辑删除,0 删除,1 未删除
    */
    private Boolean delFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getPermit() {
        return permit;
    }

    public void setPermit(Boolean permit) {
        this.permit = permit;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getValueRange() {
        return valueRange;
    }

    public void setValueRange(String valueRange) {
        this.valueRange = valueRange;
    }

    public String getValueLen() {
        return valueLen;
    }

    public void setValueLen(String valueLen) {
        this.valueLen = valueLen;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }
}