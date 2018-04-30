package com.imooc.demo.service;

import com.google.gson.Gson;
import com.imooc.demo.entity.ParamDetail;
import com.imooc.demo.entity.ParamDir;
import com.imooc.demo.utils.ComFun;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParamServiceTest {

    @Autowired
    ParamService paramService;

    @Test
    public void testqueryParamDir() {
        ParamDir paramDir = new ParamDir();
        paramDir.setParamSeq("0000000001");
        List<ParamDir> list1;
        list1 = paramService.queryParamDir(paramDir);
        Gson gson = new Gson();
        String json = gson.toJson(list1);
        ComFun.log(json);
        assert (list1.size() > 0);
    }

    @Test
    public void testaddParamDetail(){
        ParamDetail paramDetail = new ParamDetail();
        paramDetail.setParamSeq("0000000002");
        List<ParamDetail> list1 = new ArrayList<ParamDetail>();
        ParamDetail paramDetail1 = new ParamDetail();
        paramDetail1.setParamSeq("0000000002");
        paramDetail1.setParamKey("001");
        paramDetail1.setParamValue("按年");
        paramDetail1.setParamRemark("001-按年");

        ParamDetail paramDetail2 = new ParamDetail();
        paramDetail2.setParamSeq("0000000002");
        paramDetail2.setParamKey("002");
        paramDetail2.setParamValue("按月");
        paramDetail2.setParamRemark("001-按月");

        list1.add(paramDetail1);
        list1.add(paramDetail2);

        paramService.addParamDetail(paramDetail, list1);
    }

    @Test
    public void testdeleteParamDetail(){
        ParamDetail paramDetail = new ParamDetail();
        paramDetail.setParamSeq("0000000002");
        paramService.deleteParamDetail(paramDetail);

    }

    @Test
    public void testeditParamDetail(){
        ParamDetail paramDetail = new ParamDetail();
        paramDetail.setParamSeq("0000000002");
        List<ParamDetail> list1 = new ArrayList<ParamDetail>();
        ParamDetail paramDetail1 = new ParamDetail();
        paramDetail1.setParamSeq("0000000002");
        paramDetail1.setParamKey("003");
        paramDetail1.setParamValue("按年1");
        paramDetail1.setParamRemark("001-按年1");

        ParamDetail paramDetail2 = new ParamDetail();
        paramDetail2.setParamSeq("0000000002");
        paramDetail2.setParamKey("004");
        paramDetail2.setParamValue("按月1");
        paramDetail2.setParamRemark("001-按月1");

        list1.add(paramDetail1);
        list1.add(paramDetail2);

        paramService.editParamDetail(paramDetail, list1);

    }

    @Test
    public void testqueryParamDetail(){
        ParamDetail paramDetail = new ParamDetail();
        paramDetail.setParamSeq("0000000002");
        List<ParamDetail> list1;
        list1 = paramService.queryParamDetail(paramDetail);
        Gson gson = new Gson();
        String json = gson.toJson(list1);
        ComFun.log(json);
        assert (list1.size() > 0);
    }

}
