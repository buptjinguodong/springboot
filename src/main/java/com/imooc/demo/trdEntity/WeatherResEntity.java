package com.imooc.demo.trdEntity;

import java.util.List;

public class WeatherResEntity {
    List<WeatherEntity> results;
    private String status;
    private String status_code;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus_code() {
        return status_code;
    }

    public void setStatus_code(String status_code) {
        this.status_code = status_code;
    }

    public List<WeatherEntity> getResults() {
        return results;
    }

    public void setResults(List<WeatherEntity> results) {
        this.results = results;
    }
}
