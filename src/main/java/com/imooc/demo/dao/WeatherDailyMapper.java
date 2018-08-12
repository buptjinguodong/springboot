package com.imooc.demo.dao;

import com.imooc.demo.entity.WeatherDaily;
import com.imooc.demo.entity.WeatherDailyKey;


public interface WeatherDailyMapper {

    int deleteByPrimaryKey(WeatherDailyKey key);

    int insert(WeatherDaily record);

    int insertSelective(WeatherDaily record);

    WeatherDaily selectByPrimaryKey(WeatherDailyKey key);

    int updateByPrimaryKeySelective(WeatherDaily record);

    int updateByPrimaryKey(WeatherDaily record);
}