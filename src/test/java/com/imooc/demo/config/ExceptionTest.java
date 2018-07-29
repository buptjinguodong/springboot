/*
 * Copyright (c) 2018.
 * @auther dongGe
 * @time $today.year-$today.month-26.
 */

package com.imooc.demo.config;

import com.google.gson.Gson;
import com.imooc.demo.utils.ComFun;
import com.imooc.frame.exception.CommonException;
import com.imooc.frame.exception.LogExceptionMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// 使用Spring的UT来跑测试
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExceptionTest {

    @Autowired
    Gson gson;

    @Test
    public void test4logExceptionMessage() throws CommonException {

        ComFun.log(LogExceptionMessage.getMessage("YPWA02810001"));

        ComFun.log(gson.toJson(LogExceptionMessage.LOGMESSAGE));

        CommonException commonException = new CommonException("YPWA02810001",5);
        ComFun.log(commonException.getMessage());

        throw commonException;
    }
}
