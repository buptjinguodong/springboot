/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.imooc.demo.config.core;

import com.imooc.frame.exception.LogExceptionMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
public class ExceptionConfiguration {

    @Bean(name = "logExceptionMessage")
    public LogExceptionMessage createLogExceptionMessage() {

        List<Resource> resources = new ArrayList<>();

        String[] strings = new String[1];
        strings[0] = "application/demo_err";

        LogExceptionMessage.setBasenames(strings);

        return new LogExceptionMessage();
    }
}
