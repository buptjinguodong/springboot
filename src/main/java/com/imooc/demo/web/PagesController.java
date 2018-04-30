package com.imooc.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pages")
public class PagesController {

    @RequestMapping("/param/commonParamEdit")
    public String commonParamEdit(){
        return "param/commonParamEdit";
    }
}
