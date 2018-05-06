package com.imooc.demo.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    /**
     * 获取时间戳
     * 输出结果:
     */
    public static Timestamp getTimeStamp(){
        Date date = new Date();
        long times = date.getTime(); //废弃函数，不建议使用
        Timestamp timestamp = new Timestamp(times);
        return timestamp;
        // OR return new Date().getTime()
    }

    /**
     * 获取格式化时间
     * 输出格式: 2015-08-04 20:55:35
     */
    public static String getFormatDate(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        return dateString;
    }

    public static Date timestampToDate(Timestamp timestamp){
        long times = timestamp.getTime();
        Date date = new Date(times);
        return date;
    }

    public static String getStringDate(){
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    public static Date getNow(){
        return new Date();
    }
}
