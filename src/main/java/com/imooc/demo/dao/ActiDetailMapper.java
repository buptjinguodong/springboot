package com.imooc.demo.dao;

import com.imooc.demo.entity.ActiDetail;

public interface ActiDetailMapper {

    int deleteByPrimaryKey(String actiId);

    int insert(ActiDetail record);

    int insertSelective(ActiDetail record);

    ActiDetail selectByPrimaryKey(String actiId);

    int updateByPrimaryKeySelective(ActiDetail record);

    int updateByPrimaryKey(ActiDetail record);
}