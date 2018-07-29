package com.imooc.demo.quartz;

import com.google.gson.Gson;
import com.imooc.demo.dao.WeatherDailyMapper;
import com.imooc.demo.dao.WeatherLocationMapper;
import com.imooc.demo.entity.WeatherDaily;
import com.imooc.demo.entity.WeatherDailyKey;
import com.imooc.demo.entity.WeatherLocation;
import com.imooc.demo.trdEntity.WeatherDailyEntity;
import com.imooc.demo.trdEntity.WeatherEntity;
import com.imooc.demo.trdEntity.WeatherLocationEntity;
import com.imooc.demo.trdEntity.WeatherResEntity;
import com.imooc.demo.trdUtils.WeatherUtils;
import com.imooc.demo.utils.ComFun;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.security.SignatureException;
import java.util.List;

@Component
public class SeniverseDataSync {

    @Resource(name="restTemplate")
    RestTemplate restTemplate;

    @Autowired
    private WeatherDailyMapper weatherDailyMapper;

    @Autowired
    private WeatherLocationMapper weatherLocationMapper;

    @Resource(name="gson")
    Gson gson;

    public void synWeatherDailyAll() throws UnsupportedEncodingException, SignatureException {
        DataWeatherCity dataWeatherCity = DataWeatherCity.getInstance();
        List<List<String>> cityArrList = dataWeatherCity.getCityArrList();
        for(List<String> cityArr : cityArrList) {
            synWeatherDaily(cityArr.get(0));
        }
    }


    public boolean synWeatherDaily(String cityName) throws UnsupportedEncodingException, SignatureException {
        // 准备weather daily 接口URI
        String suffixUrl = "weather/daily.json";
        String aimUrl = WeatherUtils.generateGetDiaryWeatherURL(
                suffixUrl,
                cityName
        );
        System.out.println(aimUrl);
        // 使用restTemplate 获取第三方数据
        WeatherResEntity weatherResEntity = null;
        try {
            weatherResEntity = restTemplate.getForObject(aimUrl, WeatherResEntity.class);
        } catch (Exception e) {
            e.printStackTrace();
            ComFun.log("WeatherResEntity 获取异常 | [" + aimUrl + "]");
            return false;
        }

        if(weatherResEntity.getStatus_code() != null && weatherResEntity.getStatus_code() != "" ) {
            System.out.println(gson.toJson(weatherResEntity));
            ComFun.log("WeatherResEntity 获取异常 | 返回错误嘛 [" + weatherResEntity.getStatus_code() + "]");
            return false;
        }


        // 处理 Location 数据
        WeatherLocationEntity weatherLocationEntity = weatherResEntity.getResults().get(0).getLocation();
        List<WeatherDailyEntity> weatherDailyEntityList = weatherResEntity.getResults().get(0).getDaily();
        WeatherLocation weatherLocation = new WeatherLocation();
        BeanUtils.copyProperties(weatherLocationEntity, weatherLocation);
        weatherLocation.setTimezoneOffset(weatherLocationEntity.getTimezone_offset());
        WeatherLocation weatherLocation1 = weatherLocationMapper.selectByPrimaryKey(weatherLocation.getId());
        if(weatherLocation1 != null) {
            weatherLocation.setVno(weatherLocation1.getVno()+1);
            weatherLocationMapper.updateByPrimaryKey(weatherLocation);
        }else {
            weatherLocation.setVno(1);
            weatherLocationMapper.insert(weatherLocation);
        }

        // 处理 Daily 数据
        WeatherDaily weatherDaily = new WeatherDaily();

        String gsonStr = gson.toJson(weatherResEntity);
        System.out.println(gsonStr);

        for(WeatherDailyEntity weatherDailyEntity : weatherDailyEntityList) {
            BeanUtils.copyProperties(weatherDailyEntity, weatherDaily);
            weatherDaily.setId(weatherLocation.getId());
            WeatherDailyKey weatherDailyKey = new WeatherDailyKey();
            BeanUtils.copyProperties(weatherDaily, weatherDailyKey);

            weatherDaily.setCodeDay(weatherDailyEntity.getCode_day());
            weatherDaily.setCodeNight(weatherDailyEntity.getCode_night());
            weatherDaily.setTextDay(weatherDailyEntity.getText_day());
            weatherDaily.setTextNight(weatherDailyEntity.getText_night());
            weatherDaily.setPrecip(weatherDailyEntity.getPrecip());
            weatherDaily.setWindDirection(weatherDailyEntity.getWind_direction());
            weatherDaily.setWindDirectionDegree(weatherDailyEntity.getWind_direction_degree());
            weatherDaily.setWindScale(weatherDailyEntity.getWind_scale());
            weatherDaily.setWindSpeed(weatherDailyEntity.getWind_speed());

            WeatherDaily weatherDaily1 = weatherDailyMapper.selectByPrimaryKey(weatherDailyKey);

            gsonStr = gson.toJson(weatherDaily);
            System.out.println(gsonStr);

            if(weatherDaily1 != null) {
                weatherDaily.setVno(weatherDaily1.getVno()+1);
                weatherDailyMapper.updateByPrimaryKey(weatherDaily);
            } else {
                weatherDaily.setVno(1);
                weatherDailyMapper.insert(weatherDaily);
            }
        }

        return true;
    }
}
