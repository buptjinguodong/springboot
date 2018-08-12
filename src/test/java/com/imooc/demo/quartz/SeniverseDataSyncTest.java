package com.imooc.demo.quartz;

import com.imooc.demo.trdUtils.WeatherUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;
import java.security.SignatureException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeniverseDataSyncTest {

    @Autowired
    SeniverseDataSync seniverseDataSync;

    @Test
    public void test4synWeatherDailyAll() throws UnsupportedEncodingException, SignatureException {
        seniverseDataSync.synWeatherDailyAll();
    }

    @Test
    public void test4synWeatherDaily() throws UnsupportedEncodingException, SignatureException {
        seniverseDataSync.synWeatherDaily("Ruili");

    }

    @Test
    public void test4WeatherUtils() {
        try {
            String url = WeatherUtils.generateGetDiaryWeatherURL(
                    "weather/daily.json",
                    "shanghai",
                    "zh-Hans",
                    "c",
                    "1",
                    "1"
            );
            System.out.println("URL:" + url);
        } catch (Exception e) {
            System.out.println("Exception:" + e);
        }
    }
}
