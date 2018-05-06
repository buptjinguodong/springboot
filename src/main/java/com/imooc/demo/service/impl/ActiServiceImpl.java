package com.imooc.demo.service.impl;

import com.imooc.demo.dao.ActiDetailMapper;
import com.imooc.demo.dao.ActiInfoMapper;
import com.imooc.demo.entity.ActiDetail;
import com.imooc.demo.entity.ActiInfo;
import com.imooc.demo.service.ActiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActiServiceImpl implements ActiService {

    @Autowired
    ActiInfoMapper actiInfoMapper;

    @Autowired
    ActiDetailMapper actiDetailMapper;

    public List<ActiInfo> enquireActiList(ActiInfo actiInfo){
        return actiInfoMapper.select(actiInfo);
    }

    @Override
    public ActiDetail enquireActiDetail(String actiId) {
        ActiDetail res = null;
        res = actiDetailMapper.selectByPrimaryKey(actiId);
        return res;
    }

}
