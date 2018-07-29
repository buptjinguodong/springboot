package com.imooc.demo.dao;

import com.imooc.demo.entity.WeatherLocation;

public interface WeatherLocationMapper {

    int deleteByPrimaryKey(String id);

    int insert(WeatherLocation record);

    int insertSelective(WeatherLocation record);

    WeatherLocation selectByPrimaryKey(String id);

    WeatherLocation selectByName(String name);

    int updateByPrimaryKeySelective(WeatherLocation record);

    int updateByPrimaryKey(WeatherLocation record);
}