package com.imooc.demo.entity;

import java.util.Date;

public class WeatherDaily extends WeatherDailyKey {
    private String textDay;

    private String codeDay;

    private String textNight;

    private String codeNight;

    private String high;

    private String low;

    private String precip;

    private String windDirection;

    private String windDirectionDegree;

    private String windSpeed;

    private String windScale;

    private String multiTenancyId;

    private Integer vno;

    private Date tms;

    public String getTextDay() {
        return textDay;
    }

    public void setTextDay(String textDay) {
        this.textDay = textDay == null ? null : textDay.trim();
    }

    public String getCodeDay() {
        return codeDay;
    }

    public void setCodeDay(String codeDay) {
        this.codeDay = codeDay == null ? null : codeDay.trim();
    }

    public String getTextNight() {
        return textNight;
    }

    public void setTextNight(String textNight) {
        this.textNight = textNight == null ? null : textNight.trim();
    }

    public String getCodeNight() {
        return codeNight;
    }

    public void setCodeNight(String codeNight) {
        this.codeNight = codeNight == null ? null : codeNight.trim();
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high == null ? null : high.trim();
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low == null ? null : low.trim();
    }

    public String getPrecip() {
        return precip;
    }

    public void setPrecip(String precip) {
        this.precip = precip == null ? null : precip.trim();
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection == null ? null : windDirection.trim();
    }

    public String getWindDirectionDegree() {
        return windDirectionDegree;
    }

    public void setWindDirectionDegree(String windDirectionDegree) {
        this.windDirectionDegree = windDirectionDegree == null ? null : windDirectionDegree.trim();
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed == null ? null : windSpeed.trim();
    }

    public String getWindScale() {
        return windScale;
    }

    public void setWindScale(String windScale) {
        this.windScale = windScale == null ? null : windScale.trim();
    }

    public String getMultiTenancyId() {
        return multiTenancyId;
    }

    public void setMultiTenancyId(String multiTenancyId) {
        this.multiTenancyId = multiTenancyId == null ? null : multiTenancyId.trim();
    }

    public Integer getVno() {
        return vno;
    }

    public void setVno(Integer vno) {
        this.vno = vno;
    }

    public Date getTms() {
        return tms;
    }

    public void setTms(Date tms) {
        this.tms = tms;
    }
}