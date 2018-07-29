package com.imooc.demo.service.impl;

import com.imooc.demo.dao.WeatherDailyMapper;
import com.imooc.demo.dao.WeatherLocationMapper;
import com.imooc.demo.entity.WeatherDaily;
import com.imooc.demo.entity.WeatherDailyKey;
import com.imooc.demo.entity.WeatherLocation;
import com.imooc.demo.service.WeatherService;
import com.imooc.demo.utils.A0628BeanConstants;
import com.imooc.demo.utils.DataBusUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private WeatherLocationMapper locationMapper;

    @Autowired
    private WeatherDailyMapper weatherDailyMapper;

    @Override
    public void queryWeatherDaily() throws Exception {

        WeatherLocation weatherLocation = null;
        weatherLocation = (WeatherLocation) DataBusUtils.getValue(A0628BeanConstants.WEATHER_LOCATION);

        weatherLocation = locationMapper.selectByName(weatherLocation.getName());

        if(weatherLocation == null) {
            throw new Exception("查询结果为空");
        }
        if(weatherLocation.getId() == "") {
            throw new Exception("城市ID不可为空");
        }

        WeatherDailyKey weatherDailyKey = null;
        weatherDailyKey = (WeatherDailyKey) DataBusUtils.getValue(A0628BeanConstants.WEATHER_DAILY_KEY);
        weatherDailyKey.setId(weatherLocation.getId());

        WeatherDaily weatherDaily = weatherDailyMapper.selectByPrimaryKey(weatherDailyKey);

        DataBusUtils.setValue(A0628BeanConstants.WEATHER_DAILY, weatherDaily);


    }
}
