package com.imooc.demo.entity;

public class ActiDetail {
    private String actiId;

    private String actiBaseinfo;

    private String actiPrepare;

    private String actiPriceDetail;

    private String actiAplyDetail;

    public String getActiId() {
        return actiId;
    }

    public void setActiId(String actiId) {
        this.actiId = actiId == null ? null : actiId.trim();
    }

    public String getActiBaseinfo() {
        return actiBaseinfo;
    }

    public void setActiBaseinfo(String actiBaseinfo) {
        this.actiBaseinfo = actiBaseinfo == null ? null : actiBaseinfo.trim();
    }

    public String getActiPrepare() {
        return actiPrepare;
    }

    public void setActiPrepare(String actiPrepare) {
        this.actiPrepare = actiPrepare == null ? null : actiPrepare.trim();
    }

    public String getActiPriceDetail() {
        return actiPriceDetail;
    }

    public void setActiPriceDetail(String actiPriceDetail) {
        this.actiPriceDetail = actiPriceDetail == null ? null : actiPriceDetail.trim();
    }

    public String getActiAplyDetail() {
        return actiAplyDetail;
    }

    public void setActiAplyDetail(String actiAplyDetail) {
        this.actiAplyDetail = actiAplyDetail == null ? null : actiAplyDetail.trim();
    }
}