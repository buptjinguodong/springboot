package com.imooc.demo.web;

import com.imooc.demo.entity.ActiInfo;
import com.imooc.demo.entity.CommunicationEntity;
import com.imooc.demo.utils.A0628BeanConstants;
import com.imooc.demo.utils.DataBusConstants;
import com.imooc.demo.utils.DataBusUtils;
import com.imooc.demo.vo.CommunicationAjaxInVo;
import com.imooc.demo.vo.CommunicationAjaxOutVo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sun.net.www.http.HttpClient;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/communication")
public class CommunicationController {

    @Resource(name="restTemplate")
    RestTemplate restTemplate;

    @RequestMapping("/ajax")
    public CommunicationAjaxOutVo communicationAjax(CommunicationAjaxInVo inVo){

        // 解析Ajax请求报文
        /**
         * 请求报文：
         * fwServiceId
         * fwTranId
         * jsonData
         * type - AJAX_METHOD - no
         * headers - no
         * timeout - AJAX_TIMEOUT - no
         * success - no
         * failure - no
         */
        CommunicationEntity communicationEntity = new CommunicationEntity();
        BeanUtils.copyProperties(inVo, communicationEntity);
        DataBusUtils.setValue(DataBusConstants.COMMUNICATION_ENTITY, communicationEntity);



        // 获取 fwServiceId : "simpleTransaction" "database" "getServerTime" ...

        /**
         * 根据 fwServiceId 的不同，执行不同的处理逻辑
         *
         * 如果 fwServiceId == "simpleTransaction"
         * 获取 fwTranId - 交易码
         * 获取 jsonData - 字符串形式 无需反序列处理
         */

        // 根据返回结果，按需返回



        return null;
    }
}
