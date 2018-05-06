package com.imooc.demo.dao;

import com.imooc.demo.entity.ActiAplyDetail;

import java.util.List;

public interface ActiAplyDetailMapper {

    List<ActiAplyDetail> select(ActiAplyDetail record);

    int deleteByPrimaryKey(String aplyId);

    int insert(ActiAplyDetail record);

    int insertSelective(ActiAplyDetail record);

    ActiAplyDetail selectByPrimaryKey(String aplyId);

    int updateByPrimaryKeySelective(ActiAplyDetail record);

    int updateByPrimaryKey(ActiAplyDetail record);
}