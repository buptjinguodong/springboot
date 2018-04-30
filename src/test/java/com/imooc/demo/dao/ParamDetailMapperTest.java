package com.imooc.demo.dao;

import com.imooc.demo.entity.ParamDetail;
import com.imooc.demo.entity.ParamDir;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

// 使用Spring的UT来跑测试
@RunWith(SpringRunner.class)
@SpringBootTest
public class ParamDetailMapperTest {

    @Autowired
    ParamDetailMapper paramDetailMapper;

    @Autowired
    ParamDirMapper paramDirMapper;

    @Test
    public void query(){
        ParamDir paramDir = new ParamDir();
        List<ParamDir> listParamDir;
        listParamDir = paramDirMapper.select(paramDir);
        System.out.println(listParamDir);
    }

    @Test
    public void queryById(){
        ParamDir paramDir;
        paramDir = paramDirMapper.selectByPrimaryKey("0000000002");
        System.out.println(paramDir);
    }

    @Test
    public void insert(){
        ParamDir paramDir = new ParamDir();
        paramDir.setParamSeq("0000000005");
        paramDir.setParamDesc("活动时间");
        int res = paramDirMapper.insert(paramDir);
        System.out.println(res);
    }

    @Test
    public void update(){
        ParamDir paramDir = new ParamDir();
        paramDir.setParamSeq("0000000001");
        paramDir.setParamDesc("活动类型1");
        int res = paramDirMapper.updateByPrimaryKey(paramDir);
        System.out.println(res);
    }

    @Test
    public void delete(){
        int res = paramDirMapper.deleteByPrimaryKey("0000000001");
        System.out.println(res);
    }

    @Test
    public void query1(){
        ParamDetail paramDetail = new ParamDetail();
        List<ParamDetail> listParamDetail;
        listParamDetail = paramDetailMapper.select(paramDetail);
        System.out.println(listParamDetail);
    }

    @Test
    public void queryById1(){
        ParamDetail paramDetail = new ParamDetail();
        paramDetail.setParamSeq("0000000001");
        paramDetail.setParamKey("001");
        paramDetail = paramDetailMapper.selectByPrimaryKey(paramDetail);
        System.out.println(paramDetail);
    }

    @Test
    public void insert1(){
        ParamDetail paramDetail = new ParamDetail();
        paramDetail.setParamSeq("0000000001");
        paramDetail.setParamKey("001");
        paramDetail.setParamValue("微旅行");
        paramDetail.setParamRemark("001-微旅行");
        int res = paramDetailMapper.insert(paramDetail);
        System.out.println(res);
    }

    @Test
    public void update1(){
        ParamDetail paramDetail = new ParamDetail();
        paramDetail.setParamSeq("0000000001");
        paramDetail.setParamKey("001");
        paramDetail.setParamValue("微旅行");
        paramDetail.setParamRemark("001-微旅行1");
        int res = paramDetailMapper.updateByPrimaryKey(paramDetail);
        System.out.println(res);
    }

    @Test
    public void delete1(){
        ParamDetail paramDetail = new ParamDetail();
        paramDetail.setParamSeq("0000000001");
        paramDetail.setParamKey("001");
        int res = paramDetailMapper.deleteByPrimaryKey(paramDetail);
        System.out.println(res);
    }
}
