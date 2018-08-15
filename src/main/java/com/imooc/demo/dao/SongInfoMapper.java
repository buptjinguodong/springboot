package com.imooc.demo.dao;

import com.imooc.demo.entity.SongInfo;

import java.util.List;

public interface SongInfoMapper {

    List<SongInfo> select(SongInfo record);

    int deleteByPrimaryKey(Integer songId);

    int insert(SongInfo record);

    int insertSelective(SongInfo record);

    SongInfo selectByPrimaryKey(Integer songId);

    int updateByPrimaryKeySelective(SongInfo record);

    int updateByPrimaryKey(SongInfo record);
}