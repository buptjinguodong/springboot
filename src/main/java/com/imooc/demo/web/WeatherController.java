package com.imooc.demo.web;


import com.imooc.demo.entity.*;
import com.imooc.demo.service.WeatherService;
import com.imooc.demo.utils.A0628BeanConstants;
import com.imooc.demo.utils.DataBusUtils;
import com.imooc.demo.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @RequestMapping("/A16280101")
    public A16280101OutVo enquireActiList(A16280101InVo inVo) throws Exception {

        // 工厂 产生 业务实体
        WeatherLocation weatherLocation = new WeatherLocation();
        BeanUtils.copyProperties(inVo, weatherLocation);
        DataBusUtils.setValue(A0628BeanConstants.WEATHER_LOCATION, weatherLocation);
        WeatherDailyKey weatherDailyKey = new WeatherDailyKey();
        weatherDailyKey.setDate(inVo.getStart());
        DataBusUtils.setValue(A0628BeanConstants.WEATHER_DAILY_KEY, weatherDailyKey);

        // 请求校验 - 免

        // 执行业务逻辑处理
        weatherService.queryWeatherDaily();

        // 工厂 产生 响应Vo
        WeatherDaily weatherDaily = (WeatherDaily) DataBusUtils.getValue(A0628BeanConstants.WEATHER_DAILY);
        A16280101Sub1OutVo sub1OutVo = new A16280101Sub1OutVo();
        BeanUtils.copyProperties(weatherDaily,sub1OutVo);
        A16280101OutVo outVo = new A16280101OutVo();
        List<A16280101Sub1OutVo> sub1OutVoList = new ArrayList<A16280101Sub1OutVo>();
        sub1OutVoList.add(sub1OutVo);
        outVo.setRows(sub1OutVoList);
        outVo.setTotal(sub1OutVoList.size());

        return outVo;
    }
}
