package com.imooc.o2o.entity;

import javax.xml.crypto.Data;

/**
 * @Author: zxw
 * @Date: Created in 11:13 2022/7/27
 */
public class Area {
    /**
     * 创建变量名，采用小驼峰命名法
     * */
    //ID
    private Integer areaId;
    //名称
    private String areaName;
    //权重
    private Integer priority;
    //创建时间
    private Data createTime;
    //更新时间
    private Data lastEditTime;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Data getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Data createTime) {
        this.createTime = createTime;
    }

    public Data getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Data lastEditTime) {
        this.lastEditTime = lastEditTime;
    }
}
