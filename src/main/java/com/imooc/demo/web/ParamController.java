package com.imooc.demo.web;

import com.google.gson.Gson;
import com.imooc.demo.entity.ParamDetail;
import com.imooc.demo.entity.ParamDir;
import com.imooc.demo.service.ParamService;
import com.imooc.demo.utils.ComFun;
import com.imooc.demo.utils.ConstantUtil;
import com.imooc.demo.vo.A06280201OutVo;
import com.imooc.demo.vo.A06280202InVo;
import com.imooc.demo.vo.A06280202OutVo;
import com.imooc.frame.exception.CommonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/param")
public class ParamController {

    @Autowired
    ParamService paramService;

    Gson gson = new Gson();

    @RequestMapping("/A06280201")
    public A06280201OutVo queryParamDir(@RequestBody ParamDir paramDir){
        A06280201OutVo outVo = new A06280201OutVo();
        List<ParamDir> paramDirList;
        ComFun.log(gson.toJson(paramDir));
        paramDirList = paramService.queryParamDir(paramDir);
        outVo.setRows(paramDirList);
        outVo.setTotal(paramDirList.size());
        return outVo;
    }

    @RequestMapping("/A06280202")
    public A06280202OutVo editParamDetail(@RequestBody A06280202InVo inVo) throws CommonException {
        List<ParamDetail> list1 = inVo.getList1();
        String svcTpcd = inVo.getSvcTpcd();
        ParamDetail paramDetail = new ParamDetail();
        paramDetail.setParamSeq(inVo.getParamSeq());

        A06280202OutVo outVo = new A06280202OutVo();

        switch (svcTpcd){
            case ConstantUtil.SVC_TPCD_ADD:
                // 新增
                paramService.addParamDetail(paramDetail, list1);
                break;
            case ConstantUtil.SVC_TPCD_DELETE:
                paramService.deleteParamDetail(paramDetail);
                break;
            case ConstantUtil.SVC_TPCD_EDIT:
                paramService.editParamDetail(paramDetail, list1);
                break;
            case ConstantUtil.SVC_TPCD_QUERY:
                break;
            default:
                throw new RuntimeException("A06280202,SVC_TPCD错误");
        }

        list1 = paramService.queryParamDetail(paramDetail);
        outVo.setList1(list1);
        outVo.setRows(list1);
        outVo.setTotal(list1.size());
        return outVo;
    }
}
