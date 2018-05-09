package com.imooc.demo.service;

import com.imooc.demo.entity.ActiDetail;
import com.imooc.demo.entity.ActiInfo;

import java.util.List;

public interface ActiService {

    List<ActiInfo> enquireActiList(ActiInfo actiInfo);

    ActiDetail enquireActiDetail(String actiId);

    void dealActiDetail();
}
