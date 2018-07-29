package com.imooc.demo.vo;

import java.util.List;

public class A06280302OutVo {

    private String cityId;
    private String cityName;
    private String cityPath;

    private List<A06280302Sub1OutVo> list1;

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityPath() {
        return cityPath;
    }

    public void setCityPath(String cityPath) {
        this.cityPath = cityPath;
    }

    public List<A06280302Sub1OutVo> getList1() {
        return list1;
    }

    public void setList1(List<A06280302Sub1OutVo> list1) {
        this.list1 = list1;
    }
}
