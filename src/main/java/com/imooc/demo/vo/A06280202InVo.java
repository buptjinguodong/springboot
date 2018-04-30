package com.imooc.demo.vo;

import com.imooc.demo.entity.ParamDetail;

import java.util.List;

public class A06280202InVo{
    private String svcTpcd;
    private String paramSeq;
    private List<ParamDetail> list1;

    public String getSvcTpcd() {
        return svcTpcd;
    }

    public void setSvcTpcd(String svcTpcd) {
        this.svcTpcd = svcTpcd;
    }

    public String getParamSeq() {
        return paramSeq;
    }

    public void setParamSeq(String paramSeq) {
        this.paramSeq = paramSeq;
    }

    public List<ParamDetail> getList1() {
        return list1;
    }

    public void setList1(List<ParamDetail> list1) {
        this.list1 = list1;
    }
}
