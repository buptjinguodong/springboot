/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.imooc.frame.exception;

import org.springframework.beans.factory.InitializingBean;

import java.util.Locale;

public class RuntimeStaticsParam implements InitializingBean {

    public static Locale runtimeLocal = new Locale("zh", "CN");
    public String language = "zh";
    public String region = "CN";

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        runtimeLocal = new Locale(this.language, this.region);
    }
}
