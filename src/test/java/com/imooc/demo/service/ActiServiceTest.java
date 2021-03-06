package com.imooc.demo.service;

import com.google.gson.Gson;
import com.imooc.demo.dao.ActiDetailMapper;
import com.imooc.demo.dao.ActiInfoMapper;
import com.imooc.demo.entity.ActiDetail;
import com.imooc.demo.entity.ActiInfo;
import com.imooc.demo.utils.A0628BeanConstants;
import com.imooc.demo.utils.ComFun;
import com.imooc.demo.utils.DataBusUtils;
import com.imooc.demo.utils.DateUtil;
import com.imooc.demo.vo.A06280102OutVo;
import com.imooc.demo.vo.A06280103OutVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActiServiceTest {

    @Autowired
    private ActiService actiService;

    @Autowired
    private ActiInfoMapper actiInfoMapper;

    @Autowired
    private ActiDetailMapper actiDetailMapper;

    private Gson gson = new Gson();

    @Test
    public void test4EnquireActiList(){
        ActiInfo actiInfo = new ActiInfo();
        actiInfo.setActiAddr("地点");
        List<ActiInfo> actiInfoList = actiService.enquireActiList(actiInfo);
        ComFun.log(gson.toJson(actiInfoList));
    }

    @Rollback(false)
    @Test
    public void test4InsertActi(){
        ActiInfo actiInfo = new ActiInfo();
        actiInfo.setActiAbs("这是个好地点芳");
        actiInfo.setActiAddr("321地点123");
        actiInfo.setActiAplyTime(DateUtil.getNow());
        actiInfo.setActiCapacity(2);
        actiInfo.setActiCreator("带队人-栋哥");
        actiInfo.setActiCreatorId("ULC120109199001093511");
        actiInfo.setActiEndDate("20180511");
        actiInfo.setActiId("20180506000001");
        actiInfo.setActiPricePre(70);
        actiInfo.setActiPriceTotal(120);
        actiInfo.setActiStartDate("20180510");
        actiInfo.setActiTitle("云台山-5日常完");
        actiInfo.setActiStatusCd("01");
        actiInfo.setActiImgs("url/1.png");
        actiInfoMapper.insert(actiInfo);
    }

    @Test
    public void test4EnquireActiDetail(){
        String actiId = "20180506000001";
        ActiDetail actiDetail = actiService.enquireActiDetail(actiId);
        ComFun.log(gson.toJson(actiDetail));
    }

    @Test
    public void test4InsertActiDetail(){
        ActiDetail actiDetail = new ActiDetail();
        actiDetail.setActiId("20180506000001");
        actiDetail.setActiAplyDetail("报名事项");
        actiDetail.setActiBaseinfo("基本概述");
        actiDetail.setActiPrepare("活动准备");
        actiDetail.setActiPriceDetail("价格说明");
        actiDetailMapper.insert(actiDetail);
    }

    @Test
    public void test4DealActiInfo() {
        ActiInfo actiInfo = new ActiInfo();
        actiInfo.setActiId("20180507000001");
        actiInfo.setActiStatusCd("01");
        actiInfo.setActiTitle("shiyi下");

        DataBusUtils.setValue(A0628BeanConstants.ACTI_INFO, actiInfo);
        DataBusUtils.setValue(A0628BeanConstants.SVC_TPCD, "04");

        actiService.dealActiInfo();

        // 工厂 产生 响应Vo
        actiInfo  = (ActiInfo) DataBusUtils.getValue(A0628BeanConstants.ACTI_INFO);
        A06280102OutVo outVo = new A06280102OutVo();
        // actiInfo 可能为null 报错。
        BeanUtils.copyProperties(actiInfo,outVo);

        ComFun.log(gson.toJson(outVo));
    }

    @Test
    public void test4DealActiDetail() {
        ActiDetail actiDetail = new ActiDetail();
        actiDetail.setActiId("20180507000001");
        actiDetail.setActiPriceDetail("价格详情");
        actiDetail.setActiPrepare("准备阶段");

        DataBusUtils.setValue(A0628BeanConstants.ACTI_DETAIL, actiDetail);
        DataBusUtils.setValue(A0628BeanConstants.SVC_TPCD, "04");

        actiService.dealActiDetail();

        // 工厂 产生 响应Vo
        actiDetail  = (ActiDetail) DataBusUtils.getValue(A0628BeanConstants.ACTI_DETAIL);
        A06280103OutVo outVo = new A06280103OutVo();
        // actiInfo 可能为null 报错。
        BeanUtils.copyProperties(actiDetail,outVo);

        ComFun.log(gson.toJson(outVo));
    }
}
