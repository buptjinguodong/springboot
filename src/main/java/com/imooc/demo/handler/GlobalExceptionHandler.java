package com.imooc.demo.handler;

import com.imooc.frame.exception.CommonException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 标识为SpringMVC的异常处理类
 * 建议：编写不同的异常处理类，对应于不同的异常
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value=Exception.class)
    // 直接放回错误信息
    @ResponseBody
    private Map<String, Object> exceptionHandler(HttpServletRequest req, Exception e){
        Map<String, Object> modelMap  = new HashMap<String, Object>();
        modelMap.put("success", false);
        modelMap.put("errMsg", e.getMessage());
        return modelMap;
    }

    @ExceptionHandler(value=CommonException.class)
    // 直接放回错误信息
    @ResponseBody
    private Map<String, Object> commonExceptionHandler(HttpServletRequest req, CommonException e){
        Map<String, Object> modelMap  = new HashMap<String, Object>();
        modelMap.put("success", false);
        modelMap.put("errorCode", e.getCode());
        modelMap.put("errorMsg", e.getMessage());
        return modelMap;
    }
}
