/*
 * Copyright (c) 2018.
 * @auther dongGe
 * @time $today.year-$today.month-26.
 */

package com.imooc.demo.config.adapter;

import com.imooc.demo.adapter.AuthAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class AuthAdapterConfig extends WebMvcConfigurerAdapter{

    @Autowired
    private AuthAdapter authAdapter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authAdapter).addPathPatterns("/**");
    }
}
