package com.imooc.demo.dao;

import com.imooc.demo.entity.ParamDir;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ParamDirMapper {

    List<ParamDir> select(ParamDir record);

    int deleteByPrimaryKey(String paramSeq);

    int insert(ParamDir record);

    int insertSelective(ParamDir record);

    ParamDir selectByPrimaryKey(String paramSeq);

    int updateByPrimaryKeySelective(ParamDir record);

    int updateByPrimaryKey(ParamDir record);
}