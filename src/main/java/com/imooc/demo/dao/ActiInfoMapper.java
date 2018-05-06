package com.imooc.demo.dao;

import com.imooc.demo.entity.ActiInfo;

import java.util.List;

public interface ActiInfoMapper {

    List<ActiInfo> select(ActiInfo record);

    int deleteByPrimaryKey(String actiId);

    int insert(ActiInfo record);

    int insertSelective(ActiInfo record);

    ActiInfo selectByPrimaryKey(String actiId);

    int updateByPrimaryKeySelective(ActiInfo record);

    int updateByPrimaryKey(ActiInfo record);
}