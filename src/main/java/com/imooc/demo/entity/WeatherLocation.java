package com.imooc.demo.entity;

import java.util.Date;

public class WeatherLocation {
    private String id;

    private String name;

    private String country;

    private String path;

    private String timezone;

    private String timezoneOffset;

    private String multiTenancyId;

    private Integer vno;

    private Date tms;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone == null ? null : timezone.trim();
    }

    public String getTimezoneOffset() {
        return timezoneOffset;
    }

    public void setTimezoneOffset(String timezoneOffset) {
        this.timezoneOffset = timezoneOffset == null ? null : timezoneOffset.trim();
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