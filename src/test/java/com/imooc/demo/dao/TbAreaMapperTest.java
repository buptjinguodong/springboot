package com.imooc.demo.dao;

import com.imooc.demo.entity.TbArea;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.imooc.demo.dao.TbAreaMapper;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

// 使用Spring的UT来跑测试
@RunWith(SpringRunner.class)
@SpringBootTest
public class TbAreaMapperTest {

    @Autowired
    private TbAreaMapper tbAreaMapper;

    @Test
    @Ignore
    public void queryArea() {
        List<TbArea> areaList = tbAreaMapper.queryArea();
        assertEquals(2,((List) areaList).size());
    }

    @Test
    @Ignore
    public void queryAreaById() {
        TbArea tbArea = tbAreaMapper.queryAreaById(1);
        assertEquals("东苑", tbArea.getAreaName());

    }

    @Test
    @Ignore
    public void insertArea() {
        TbArea tbArea = new TbArea();
        tbArea.setAreaName("南苑");
        tbArea.setPriority(1);
        int effectedNum = tbAreaMapper.insertArea(tbArea);
        assertEquals(1,effectedNum);
    }

    @Test
    @Ignore
    public void updateArea() {
        TbArea tbArea = new TbArea();
        tbArea.setAreaName("南苑");
        tbArea.setAreaId(3);
        tbArea.setLastEditTime(new Date());
        int effectedNum = tbAreaMapper.updateArea(tbArea);
        assertEquals(1,effectedNum);
    }

    @Test
//    @Ignore
    public void deleteArea() {
        int effectedNum = tbAreaMapper.deleteArea(3);
        assertEquals(1,effectedNum);
    }
}