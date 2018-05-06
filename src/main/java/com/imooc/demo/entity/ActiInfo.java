package com.imooc.demo.entity;

import java.util.Date;

public class ActiInfo {
    private String actiId;

    private String actiTitle;

    private String actiAddr;

    private String actiStartDate;

    private String actiEndDate;

    private Integer actiPriceTotal;

    private Integer actiPricePre;

    private String actiCreator;

    private String actiCreatorId;

    private Integer actiCapacity;

    private Date actiAplyTime;

    private String actiStatusCd;

    private String actiAbs;

    private String actiImgs;

    public String getActiId() {
        return actiId;
    }

    public void setActiId(String actiId) {
        this.actiId = actiId == null ? null : actiId.trim();
    }

    public String getActiTitle() {
        return actiTitle;
    }

    public void setActiTitle(String actiTitle) {
        this.actiTitle = actiTitle == null ? null : actiTitle.trim();
    }

    public String getActiAddr() {
        return actiAddr;
    }

    public void setActiAddr(String actiAddr) {
        this.actiAddr = actiAddr == null ? null : actiAddr.trim();
    }

    public String getActiStartDate() {
        return actiStartDate;
    }

    public void setActiStartDate(String actiStartDate) {
        this.actiStartDate = actiStartDate == null ? null : actiStartDate.trim();
    }

    public String getActiEndDate() {
        return actiEndDate;
    }

    public void setActiEndDate(String actiEndDate) {
        this.actiEndDate = actiEndDate == null ? null : actiEndDate.trim();
    }

    public Integer getActiPriceTotal() {
        return actiPriceTotal;
    }

    public void setActiPriceTotal(Integer actiPriceTotal) {
        this.actiPriceTotal = actiPriceTotal;
    }

    public Integer getActiPricePre() {
        return actiPricePre;
    }

    public void setActiPricePre(Integer actiPricePre) {
        this.actiPricePre = actiPricePre;
    }

    public String getActiCreator() {
        return actiCreator;
    }

    public void setActiCreator(String actiCreator) {
        this.actiCreator = actiCreator == null ? null : actiCreator.trim();
    }

    public String getActiCreatorId() {
        return actiCreatorId;
    }

    public void setActiCreatorId(String actiCreatorId) {
        this.actiCreatorId = actiCreatorId == null ? null : actiCreatorId.trim();
    }

    public Integer getActiCapacity() {
        return actiCapacity;
    }

    public void setActiCapacity(Integer actiCapacity) {
        this.actiCapacity = actiCapacity;
    }

    public Date getActiAplyTime() {
        return actiAplyTime;
    }

    public void setActiAplyTime(Date actiAplyTime) {
        this.actiAplyTime = actiAplyTime;
    }

    public String getActiStatusCd() {
        return actiStatusCd;
    }

    public void setActiStatusCd(String actiStatusCd) {
        this.actiStatusCd = actiStatusCd == null ? null : actiStatusCd.trim();
    }

    public String getActiAbs() {
        return actiAbs;
    }

    public void setActiAbs(String actiAbs) {
        this.actiAbs = actiAbs == null ? null : actiAbs.trim();
    }

    public String getActiImgs() {
        return actiImgs;
    }

    public void setActiImgs(String actiImgs) {
        this.actiImgs = actiImgs == null ? null : actiImgs.trim();
    }
}