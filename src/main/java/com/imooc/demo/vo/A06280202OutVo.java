package com.imooc.demo.vo;

import com.imooc.demo.entity.ParamDetail;

import java.util.List;

public class A06280202OutVo {
    private List<ParamDetail> list1;
    private List<ParamDetail> rows;
    Integer total;

    public List<ParamDetail> getList1() {
        return list1;
    }

    public void setList1(List<ParamDetail> list1) {
        this.list1 = list1;
    }

    public List<ParamDetail> getRows() {
        return rows;
    }

    public void setRows(List<ParamDetail> rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
