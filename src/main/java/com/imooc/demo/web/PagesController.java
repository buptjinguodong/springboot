package com.imooc.demo.web;

import com.imooc.demo.utils.ComFun;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/pages")
public class PagesController {

    @RequestMapping(value="/param/commonParamEdit")
    public String commonParamEdit(){
        return "" +
                "param/commonParamEdit";
    }

    @RequestMapping(value="/param/commonParamDetailEdit")
    public String commonParamDetailEdit(){
        return "param/commonParamDetailEdit";
    }

    @RequestMapping(value="/admin/acti/infoEdit")
    public String adminActiEdit() { return "admin/acti/infoEdit"; }

    @RequestMapping(value="/client/{pagename}")
    public String clientPage(@PathVariable String pagename) {
        return pagename;
    }

    @RequestMapping(value="/admin/{pagename}")
    public String adminPage(@PathVariable String pagename) { return "admin/" + pagename; }


}
