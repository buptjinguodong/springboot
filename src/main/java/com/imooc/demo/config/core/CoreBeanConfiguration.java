package com.imooc.demo.config.core;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreBeanConfiguration {
    @Bean(name="gson")
    public Gson createGson(){
        Gson gson = new Gson();
        return gson;
    }
}
