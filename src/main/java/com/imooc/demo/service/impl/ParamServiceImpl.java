package com.imooc.demo.service.impl;

import com.imooc.demo.dao.ParamDetailMapper;
import com.imooc.demo.dao.ParamDirMapper;
import com.imooc.demo.entity.ParamDetail;
import com.imooc.demo.entity.ParamDir;
import com.imooc.demo.service.ParamService;
import com.imooc.demo.utils.ComFun;
import com.imooc.frame.exception.CommonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParamServiceImpl implements ParamService {

    @Autowired
    ParamDirMapper paramDirMapper;

    @Autowired
    ParamDetailMapper paramDetailMapper;

    @Override
    public List<ParamDir> queryParamDir(ParamDir paramDir) {
        return paramDirMapper.select(paramDir);
    }

    @Override
    public void addParamDetail(ParamDetail paramDetail, List<ParamDetail> list1) throws CommonException {
        int res;
        List<ParamDetail> paramDetailList = queryParamDetail(paramDetail);
        if(paramDetailList.size() > 0){
            // 已存在
            throw new RuntimeException("参数：" + paramDetail.getParamSeq() + " 已存在");
        }else{
            for(ParamDetail data : list1){
                res = paramDetailMapper.insert(data);
                if(res != 1){
                    deleteParamDetail(paramDetail);
                    throw new RuntimeException("参数：" + paramDetail.getParamSeq() + " 插入失败");
                }
            }

        }
    }

    @Override
    public void deleteParamDetail(ParamDetail paramDetail) throws CommonException {
        int res;
        List<ParamDetail> paramDetailList = queryParamDetail(paramDetail);
        if(paramDetailList.size() > 0){
            res = paramDetailMapper.deleteByParamSeq(paramDetail);
            if(res <= 0){
                throw new RuntimeException("参数：" + paramDetail.getParamSeq() + " 删除失败");
            }
        }else{
//            throw new RuntimeException("参数：" + paramDetail.getParamSeq() + " 不存在");
            throw new CommonException("YACA16280001");
        }

    }

    @Override
    public void editParamDetail(ParamDetail paramDetail, List<ParamDetail> list1) throws CommonException {
        List<ParamDetail> paramDetailList = queryParamDetail(paramDetail);
        if(paramDetailList.size() > 0){
            ComFun.log("开始删除参数");
            deleteParamDetail(paramDetail);
            ComFun.log("删除完成");
            ComFun.log("开始插入参数");
            addParamDetail(paramDetail, list1);
            ComFun.log("插入参数完成");
        }else{
//            throw new RuntimeException("参数：" + paramDetail.getParamSeq() + " 不存在");
            throw new CommonException("YACA16280001");
        }
    }

    @Override
    public List<ParamDetail> queryParamDetail(ParamDetail paramDetail) {
        List<ParamDetail> paramDetailList = paramDetailMapper.select(paramDetail);
        return paramDetailList;
    }
}
