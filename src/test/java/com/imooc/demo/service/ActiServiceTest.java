package com.imooc.demo.service;

import com.google.gson.Gson;
import com.imooc.demo.dao.ActiDetailMapper;
import com.imooc.demo.dao.ActiInfoMapper;
import com.imooc.demo.entity.ActiDetail;
import com.imooc.demo.entity.ActiInfo;
import com.imooc.demo.utils.ComFun;
import com.imooc.demo.utils.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
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
}
