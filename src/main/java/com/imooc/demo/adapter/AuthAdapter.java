/*
 * Copyright (c) 2018.
 * @auther dongGe
 * @time $today.year-$today.month-26.
 */

package com.imooc.demo.adapter;

import com.imooc.demo.utils.ComFun;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthAdapter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        ComFun.log("~~~~~~~PreHandle~~~~~~~");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                            @Nullable ModelAndView modelAndView) throws Exception {
        ComFun.log("~~~~~~~postHandle~~~~~~~");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                 @Nullable Exception ex) throws Exception {
        ComFun.log("~~~~~~~afterHandle~~~~~~~");
    }

}
