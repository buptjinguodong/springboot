package com.imooc.demo.quartz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataWeatherCity {
    private List<List<String>> cityArrList;
    private static DataWeatherCity dataWeatherCity;

    public List<List<String>> getCityArrList() {
        return cityArrList;
    }

    public void setCityArrList(List<List<String>> cityArrList) {
        this.cityArrList = cityArrList;
    }

    public static DataWeatherCity getInstance() {
        if( dataWeatherCity != null) {

            return dataWeatherCity;
        }else {
            dataWeatherCity = genDataWeatherCity();
            return dataWeatherCity;
        }
    }

    private DataWeatherCity(){}

    private static DataWeatherCity genDataWeatherCity() {
        dataWeatherCity = new DataWeatherCity();
        List<List<String>> cityArrListTem;
        String [][] cityArrListSrc = {
                {"Longyou","龙游"},
                {"Quzhou","衢州"},
                {"Jinhua","金华"},
                {"Hangzhou","杭州"},
                {"Ningbo","宁波"},
                {"Nanjing","南京"},
                {"Qingdao","青岛"},
                {"Zhangjiakou","张家口"},
                {"Qinhuangdao","秦皇岛"},
                {"Shanghai","上海"},
                {"Tianjin","天津"},
                {"Beijing","北京"},
                {"Guangzhou","广州"},
                {"Shenzhen","深圳"}
        };

        cityArrListTem = new ArrayList<>();

        for(String[] cityArrSrc: cityArrListSrc) {
            List<String> cityArr = new ArrayList<>();
            for(String citySrc : cityArrSrc) {
                cityArr.add(citySrc);
            }
            cityArrListTem.add(cityArr);
        }
        dataWeatherCity.cityArrList = cityArrListTem;
        return dataWeatherCity;
    }
}
