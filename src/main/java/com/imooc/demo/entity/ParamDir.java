package com.imooc.demo.entity;

public class ParamDir {
    private String paramSeq;

    private String paramDesc;

    public String getParamSeq() {
        return paramSeq;
    }

    public void setParamSeq(String paramSeq) {
        this.paramSeq = paramSeq == null ? null : paramSeq.trim();
    }

    public String getParamDesc() {
        return paramDesc;
    }

    public void setParamDesc(String paramDesc) {
        this.paramDesc = paramDesc == null ? null : paramDesc.trim();
    }
}