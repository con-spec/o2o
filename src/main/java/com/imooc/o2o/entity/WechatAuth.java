package com.imooc.o2o.entity;

import javax.xml.crypto.Data;

/**
 * @Author: zxw
 * @Date: Created in 11:25 2022/7/29
 */
public class WechatAuth {
    private Long wechatAuth;
    private String openId;
    private Data createTime;
    private PersonInfo personInfo;

    public Long getWechatAuth() {
        return wechatAuth;
    }

    public void setWechatAuth(Long wechatAuth) {
        this.wechatAuth = wechatAuth;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Data getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Data createTime) {
        this.createTime = createTime;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }
}
