package com.imooc.demo.dao;

import com.imooc.demo.entity.ParamDetail;
import com.imooc.demo.entity.ParamDetailKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ParamDetailMapper {

    List<ParamDetail> select(ParamDetail record);

    int deleteByPrimaryKey(ParamDetailKey key);

    int deleteByParamSeq(ParamDetailKey key);

    int insert(ParamDetail record);

    int insertSelective(ParamDetail record);

    ParamDetail selectByPrimaryKey(ParamDetailKey key);

    int updateByPrimaryKeySelective(ParamDetail record);

    int updateByPrimaryKey(ParamDetail record);
}