package com.imooc.demo.entity;

public class ParamDetailKey {
    private String paramSeq;

    private String paramKey;

    public String getParamSeq() {
        return paramSeq;
    }

    public void setParamSeq(String paramSeq) {
        this.paramSeq = paramSeq == null ? null : paramSeq.trim();
    }

    public String getParamKey() {
        return paramKey;
    }

    public void setParamKey(String paramKey) {
        this.paramKey = paramKey == null ? null : paramKey.trim();
    }
}