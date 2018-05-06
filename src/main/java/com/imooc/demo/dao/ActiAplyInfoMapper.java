package com.imooc.demo.dao;

import com.imooc.demo.entity.ActiAplyInfo;
import java.util.List;

public interface ActiAplyInfoMapper {

    List<ActiAplyInfo> select(ActiAplyInfo record);

    int deleteByPrimaryKey(String aplyId);

    int insert(ActiAplyInfo record);

    int insertSelective(ActiAplyInfo record);

    ActiAplyInfo selectByPrimaryKey(String aplyId);

    int updateByPrimaryKeySelective(ActiAplyInfo record);

    int updateByPrimaryKey(ActiAplyInfo record);
}