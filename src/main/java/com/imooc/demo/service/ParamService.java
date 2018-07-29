package com.imooc.demo.service;

import com.imooc.demo.entity.ParamDetail;
import com.imooc.demo.entity.ParamDir;
import com.imooc.frame.exception.CommonException;

import java.util.List;

public interface ParamService {
    List<ParamDir> queryParamDir(ParamDir paramDir);

    void addParamDetail(ParamDetail paramDetail, List<ParamDetail> list1) throws CommonException;

    void deleteParamDetail(ParamDetail paramDetail) throws CommonException;

    void editParamDetail(ParamDetail paramDetail, List<ParamDetail> list1) throws CommonException;

    List<ParamDetail> queryParamDetail(ParamDetail paramDetail);
}