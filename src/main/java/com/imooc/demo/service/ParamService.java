package com.imooc.demo.service;

import com.imooc.demo.entity.ParamDetail;
import com.imooc.demo.entity.ParamDir;

import java.util.List;

public interface ParamService {
    List<ParamDir> queryParamDir(ParamDir paramDir);

    void addParamDetail(ParamDetail paramDetail, List<ParamDetail> list1);

    void deleteParamDetail(ParamDetail paramDetail);

    void editParamDetail(ParamDetail paramDetail, List<ParamDetail> list1);

    List<ParamDetail> queryParamDetail(ParamDetail paramDetail);
}