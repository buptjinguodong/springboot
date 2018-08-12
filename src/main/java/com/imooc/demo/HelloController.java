package com.imooc.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {
    @RequestMapping(value="/hello")
    public String hello(){
        return "Hello SpringBoot!";

    }
}
