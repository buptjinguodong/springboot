package com.imooc.demo.service;

import com.imooc.demo.entity.SongInfo;

import java.util.List;


public interface SongService {

    // 列示查询
    List<SongInfo> listSongInfo();

    // 条件查询
    SongInfo querySongInfo();

    // 新增
    void insertSongInfo();

    // 修改
    void updateSongInfo();

    // 删除
    void deleteSongInfo();
}
