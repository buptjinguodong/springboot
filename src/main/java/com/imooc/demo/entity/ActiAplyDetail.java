package com.imooc.demo.entity;

public class ActiAplyDetail {
    private String aplyId;

    private String aplyUserName;

    private String telPhone;

    private String userGender;

    private String aplyAboardCd;

    private String aplyAboardName;

    private String aplyRemark;

    public String getAplyId() {
        return aplyId;
    }

    public void setAplyId(String aplyId) {
        this.aplyId = aplyId == null ? null : aplyId.trim();
    }

    public String getAplyUserName() {
        return aplyUserName;
    }

    public void setAplyUserName(String aplyUserName) {
        this.aplyUserName = aplyUserName == null ? null : aplyUserName.trim();
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone == null ? null : telPhone.trim();
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender == null ? null : userGender.trim();
    }

    public String getAplyAboardCd() {
        return aplyAboardCd;
    }

    public void setAplyAboardCd(String aplyAboardCd) {
        this.aplyAboardCd = aplyAboardCd == null ? null : aplyAboardCd.trim();
    }

    public String getAplyAboardName() {
        return aplyAboardName;
    }

    public void setAplyAboardName(String aplyAboardName) {
        this.aplyAboardName = aplyAboardName == null ? null : aplyAboardName.trim();
    }

    public String getAplyRemark() {
        return aplyRemark;
    }

    public void setAplyRemark(String aplyRemark) {
        this.aplyRemark = aplyRemark == null ? null : aplyRemark.trim();
    }
}