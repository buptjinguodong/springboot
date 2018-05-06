package com.imooc.demo.entity;

import java.util.Date;

public class ActiAplyInfo {
    private String aplyId;

    private String actiId;

    private String userId;

    private Integer aplyUserAmount;

    private Date aplyTime;

    private Integer aplyPriceTotal;

    private Integer aplyPricePre;

    private String aplyReportInd;

    public String getAplyId() {
        return aplyId;
    }

    public void setAplyId(String aplyId) {
        this.aplyId = aplyId == null ? null : aplyId.trim();
    }

    public String getActiId() {
        return actiId;
    }

    public void setActiId(String actiId) {
        this.actiId = actiId == null ? null : actiId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getAplyUserAmount() {
        return aplyUserAmount;
    }

    public void setAplyUserAmount(Integer aplyUserAmount) {
        this.aplyUserAmount = aplyUserAmount;
    }

    public Date getAplyTime() {
        return aplyTime;
    }

    public void setAplyTime(Date aplyTime) {
        this.aplyTime = aplyTime;
    }

    public Integer getAplyPriceTotal() {
        return aplyPriceTotal;
    }

    public void setAplyPriceTotal(Integer aplyPriceTotal) {
        this.aplyPriceTotal = aplyPriceTotal;
    }

    public Integer getAplyPricePre() {
        return aplyPricePre;
    }

    public void setAplyPricePre(Integer aplyPricePre) {
        this.aplyPricePre = aplyPricePre;
    }

    public String getAplyReportInd() {
        return aplyReportInd;
    }

    public void setAplyReportInd(String aplyReportInd) {
        this.aplyReportInd = aplyReportInd == null ? null : aplyReportInd.trim();
    }
}