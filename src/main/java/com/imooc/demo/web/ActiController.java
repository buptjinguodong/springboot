package com.imooc.demo.web;


import com.imooc.demo.entity.ActiInfo;
import com.imooc.demo.service.ActiService;
import com.imooc.demo.utils.A0628BeanConstants;
import com.imooc.demo.utils.DataBusUtils;
import com.imooc.demo.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/acti")
public class ActiController {

    @Autowired
    private ActiService actiService;

    @RequestMapping("/A06280101")
    public A06280101OutVo enquireActiList(A06280101InVo inVo){
        ActiInfo actiInfo = new ActiInfo();
        List<ActiInfo> actiInfoList = null;
        actiInfo.setActiAddr(inVo.getTravelKeyWord());
        actiInfoList = actiService.enquireActiList(actiInfo);

        A06280101OutVo outVo = new A06280101OutVo();
        outVo.setRows(actiInfoList);
        outVo.setTotal(actiInfoList.size());
        return outVo;
    }

    @RequestMapping("/A06280102")
    public A06280102OutVo dealActiDetail(A06280102InVo inVo){
        // 工厂 产生 业务实体
        ActiInfo actiInfo = inVo;
        DataBusUtils.setValue(A0628BeanConstants.ACTI_INFO, actiInfo);
        DataBusUtils.setValue(A0628BeanConstants.SVC_TPCD, inVo.getSvcTpcd());

        actiService.dealActiDetail();

        // 工厂 产生 响应Vo
        actiInfo  = (ActiInfo) DataBusUtils.getValue(A0628BeanConstants.ACTI_INFO);
        A06280102OutVo outVo = new A06280102OutVo();
        BeanUtils.copyProperties(actiInfo,outVo);
        return outVo;
    }
}
