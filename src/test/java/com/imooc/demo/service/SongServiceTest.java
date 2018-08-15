package com.imooc.demo.service;

import com.google.gson.Gson;
import com.imooc.demo.entity.SongInfo;
import com.imooc.demo.utils.ComFun;
import com.imooc.demo.utils.DataBusConstants;
import com.imooc.demo.utils.DataBusUtils;
import com.imooc.demo.vo.A16280201OutVo;
import com.imooc.demo.vo.A16280202OutVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SongServiceTest {

    @Autowired
    SongService songService;

    @Autowired
    Gson gson;

    @Test
    public void test4listSongInfo() {

        SongInfo songInfo = new SongInfo();
        DataBusUtils.setValue(DataBusConstants.SONG_INFO, songInfo);

        // 请求校验 - pass

        // 处理请求
        songService.listSongInfo();

        // 返回结果
        List<SongInfo> songInfoList =(List<SongInfo>) DataBusUtils.getValue(DataBusConstants.SONG_INFO_LIST);
        A16280201OutVo outVo = new A16280201OutVo();
        outVo.setList1(songInfoList);

        ComFun.log(gson.toJson(outVo));
    }

    @Test
    public void test4insertSongInfo() {

        SongInfo songInfo = new SongInfo();
        songInfo.setSongId(1);
        songInfo.setSongerId(500);
        songInfo.setSongWord("lkjljlkjlaaa");
        DataBusUtils.setValue(DataBusConstants.SONG_INFO, songInfo);

        // 请求校验 - pass

        // 处理请求
        songService.insertSongInfo();

        // 返回结果
        SongInfo songInfo1 =(SongInfo) DataBusUtils.getValue(DataBusConstants.SONG_INFO);
        A16280202OutVo outVo = new A16280202OutVo();
        BeanUtils.copyProperties(songInfo1, outVo);

        ComFun.log(gson.toJson(outVo));
    }

    @Test
    public void test4updateSongInfo() {

        SongInfo songInfo = new SongInfo();
        songInfo.setSongId(1);
        songInfo.setSongerId(500);
        songInfo.setSongWord("lkjljlkjlaaaccc");
        DataBusUtils.setValue(DataBusConstants.SONG_INFO, songInfo);

        // 请求校验 - pass

        // 处理请求
        songService.updateSongInfo();

        // 返回结果
        SongInfo songInfo1 =(SongInfo) DataBusUtils.getValue(DataBusConstants.SONG_INFO);
        A16280202OutVo outVo = new A16280202OutVo();
        BeanUtils.copyProperties(songInfo1, outVo);

        ComFun.log(gson.toJson(outVo));
    }

    @Test
    public void test4deleteSongInfo() {

        SongInfo songInfo = new SongInfo();
        songInfo.setSongId(1);
        songInfo.setSongerId(500);
        songInfo.setSongWord("lkjljlkjlaaa");
        DataBusUtils.setValue(DataBusConstants.SONG_INFO, songInfo);

        // 请求校验 - pass

        // 处理请求
        songService.deleteSongInfo();

        // 返回结果
        SongInfo songInfo1 =(SongInfo) DataBusUtils.getValue(DataBusConstants.SONG_INFO);
        A16280202OutVo outVo = new A16280202OutVo();
        BeanUtils.copyProperties(songInfo1, outVo);

        ComFun.log(gson.toJson(outVo));
    }

}
