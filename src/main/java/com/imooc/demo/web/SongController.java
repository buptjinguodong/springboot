package com.imooc.demo.web;


import com.imooc.demo.entity.SongInfo;
import com.imooc.demo.service.SongService;
import com.imooc.demo.utils.ConstantUtil;
import com.imooc.demo.utils.DataBusConstants;
import com.imooc.demo.utils.DataBusUtils;
import com.imooc.demo.vo.A16280201InVo;
import com.imooc.demo.vo.A16280201OutVo;
import com.imooc.demo.vo.A16280202InVo;
import com.imooc.demo.vo.A16280202OutVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/song")
public class SongController {

    @Autowired
    private SongService songService;

    @RequestMapping("/A16280201")
    public A16280201OutVo A16280201(@RequestBody A16280201InVo inVo) {

        // 解析报文，创建业务实体
        SongInfo songInfo = new SongInfo();
        BeanUtils.copyProperties(inVo, songInfo);
        DataBusUtils.setValue(DataBusConstants.SONG_INFO, songInfo);

        // 请求校验 - pass

        // 处理请求
        songService.listSongInfo();

        // 返回结果
        List<SongInfo> songInfoList =(List<SongInfo>) DataBusUtils.getValue(DataBusConstants.SONG_INFO_LIST);
        A16280201OutVo outVo = new A16280201OutVo();
        outVo.setList1(songInfoList);
        return outVo;
    }

    @RequestMapping("/A16280202")
    public A16280202OutVo A16280202(@RequestBody A16280202InVo inVo) {

        // 解析报文，创建业务实体
        SongInfo songInfo = new SongInfo();
        BeanUtils.copyProperties(inVo, songInfo);
        DataBusUtils.setValue(DataBusConstants.SONG_INFO, songInfo);


        // 请求校验 - pass

        // 处理请求
        String svcTpcd = inVo.getSvcTpcd();
        switch (svcTpcd){
            case ConstantUtil.SVC_TPCD_ADD:
                // 新增
                songService.insertSongInfo();
                break;
            case ConstantUtil.SVC_TPCD_DELETE:
                songService.deleteSongInfo();
                break;
            case ConstantUtil.SVC_TPCD_EDIT:
                songService.updateSongInfo();
                break;
            case ConstantUtil.SVC_TPCD_QUERY:
                songService.querySongInfo();
                break;
            default:
                throw new RuntimeException("A16280202,SVC_TPCD错误");
        }

        // 返回结果
        SongInfo songInfo1 =(SongInfo) DataBusUtils.getValue(DataBusConstants.SONG_INFO);
        A16280202OutVo outVo = new A16280202OutVo();
        BeanUtils.copyProperties(songInfo1, outVo);
        return outVo;
    }
}
