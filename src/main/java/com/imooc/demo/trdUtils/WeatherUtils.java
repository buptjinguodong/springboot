package com.imooc.demo.trdUtils;

import org.springframework.beans.factory.annotation.Value;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.SignatureException;
import java.util.Date;

public class WeatherUtils {

    private static String TIANQI_DAILY_WEATHER_URL;

    private static String TIANQI_API_SECRET_KEY;

    private static String TIANQI_API_USER_ID;

    static {
        TIANQI_DAILY_WEATHER_URL = TrdConstants.TIANQI_DAILY_WEATHER_URL;
        TIANQI_API_SECRET_KEY = TrdConstants.TIANQI_API_SECRET_KEY;
        TIANQI_API_USER_ID = TrdConstants.TIANQI_API_USER_ID;
    }

    /**
     * Generate HmacSHA1 signature with given data string and key
     * @param data
     * @param key
     * @return
     * @throws SignatureException
     */
    private static String generateSignature(String data, String key) throws SignatureException {
        String result;
        try {
            // get an hmac_sha1 key from the raw key bytes
            SecretKeySpec signingKey = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA1");
            // get an hmac_sha1 Mac instance and initialize with the signing key
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);
            // compute the hmac on input data bytes
            byte[] rawHmac = mac.doFinal(data.getBytes("UTF-8"));
            result = new sun.misc.BASE64Encoder().encode(rawHmac);
        }
        catch (Exception e) {
            throw new SignatureException("Failed to generate HMAC : " + e.getMessage());
        }
        return result;
    }

    /**
     * Generate the URL to get diary weather
     * @param location
     * @param language
     * @param unit
     * @param start
     * @param days
     * @return
     */
    public static String generateGetDiaryWeatherURL(
            String suffixUrl,
            String location,
            String language,
            String unit,
            String start,
            String days
    )  throws SignatureException, UnsupportedEncodingException {
        return TIANQI_DAILY_WEATHER_URL + suffixUrl + "?" + "key=" + TIANQI_API_SECRET_KEY + "&location=" + location + "&language=" + language + "&unit=" + unit + "&start=" + start + "&days=" + days;
    }

    public static String generateGetDiaryWeatherURL(
            String suffixUrl,
            String location
    )  throws SignatureException, UnsupportedEncodingException {
        return generateGetDiaryWeatherURL(
                suffixUrl,
                location,
                "zh-Hans",
                "c",
                "0",
                "3");
    }


    public static String generateGetDiaryWeatherSecURL(
            String suffixUrl,
            String location,
            String language,
            String unit,
            String start,
            String days
    )  throws SignatureException, UnsupportedEncodingException {
        String timestamp = String.valueOf(new Date().getTime());
        String params = "ts=" + timestamp + "&ttl=30&uid=" + TIANQI_API_USER_ID;
        String signature = URLEncoder.encode(generateSignature(params, TIANQI_API_SECRET_KEY), "UTF-8");
        return TIANQI_DAILY_WEATHER_URL + suffixUrl + "?" + params + "&sig=" + signature + "&location=" + location + "&language=" + language + "&unit=" + unit + "&start=" + start + "&days=" + days;
    }

}
