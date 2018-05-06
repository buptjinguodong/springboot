package com.imooc.demo.web;


import com.imooc.demo.entity.ActiInfo;
import com.imooc.demo.service.ActiService;
import com.imooc.demo.vo.A06280101InVo;
import com.imooc.demo.vo.A06280101OutVo;
import com.imooc.demo.vo.A06280201OutVo;
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
}
