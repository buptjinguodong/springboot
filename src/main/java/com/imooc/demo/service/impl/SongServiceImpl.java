package com.imooc.demo.service.impl;

import com.imooc.demo.dao.SongInfoMapper;
import com.imooc.demo.entity.SongInfo;
import com.imooc.demo.service.SongService;
import com.imooc.demo.utils.DataBusConstants;
import com.imooc.demo.utils.DataBusUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongInfoMapper songInfoMapper;

    @Override
    public List<SongInfo> listSongInfo() {
        List<SongInfo> songInfoList = songInfoMapper.select(new SongInfo());

        DataBusUtils.setValue(DataBusConstants.SONG_INFO_LIST, songInfoList);

        return songInfoList;
    }

    @Override
    public SongInfo querySongInfo() {
        SongInfo songInfo = (SongInfo) DataBusUtils.getValue(DataBusConstants.SONG_INFO);

        songInfo = songInfoMapper.selectByPrimaryKey(songInfo.getSongId());

        DataBusUtils.setValue(DataBusConstants.SONG_INFO, songInfo);

        return songInfo;
    }

    @Override
    public void insertSongInfo() {
        SongInfo songInfo = (SongInfo) DataBusUtils.getValue(DataBusConstants.SONG_INFO);
        songInfoMapper.insert(songInfo);
    }

    @Override
    public void updateSongInfo() {
        SongInfo songInfo = (SongInfo) DataBusUtils.getValue(DataBusConstants.SONG_INFO);
        songInfoMapper.updateByPrimaryKey(songInfo);
    }

    @Override
    public void deleteSongInfo() {
        SongInfo songInfo = (SongInfo) DataBusUtils.getValue(DataBusConstants.SONG_INFO);
        songInfoMapper.deleteByPrimaryKey(songInfo.getSongId());
    }
}
