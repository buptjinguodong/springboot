package com.imooc.demo.trdEntity;

import java.util.List;

public class WeatherEntity {

    WeatherLocationEntity location;
    List<WeatherDailyEntity> daily;
    String last_update;

    public WeatherLocationEntity getLocation() {
        return location;
    }

    public void setLocation(WeatherLocationEntity location) {
        this.location = location;
    }

    public List<WeatherDailyEntity> getDaily() {
        return daily;
    }

    public void setDaily(List<WeatherDailyEntity> daily) {
        this.daily = daily;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }
}
