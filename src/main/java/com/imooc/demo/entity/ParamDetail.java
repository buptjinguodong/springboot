package com.imooc.demo.entity;

public class ParamDetail extends ParamDetailKey {
    private String paramValue;

    private String paramRemark;

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue == null ? null : paramValue.trim();
    }

    public String getParamRemark() {
        return paramRemark;
    }

    public void setParamRemark(String paramRemark) {
        this.paramRemark = paramRemark == null ? null : paramRemark.trim();
    }
}