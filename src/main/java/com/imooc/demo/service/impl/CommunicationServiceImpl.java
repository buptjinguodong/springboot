package com.imooc.demo.service.impl;

import com.imooc.demo.entity.CommunicationEntity;
import com.imooc.demo.service.CommunicationService;
import com.imooc.demo.utils.DataBusConstants;
import com.imooc.demo.utils.DataBusUtils;

public class CommunicationServiceImpl implements CommunicationService {
    @Override
    public void doSimpleTransaction() {

        // 获取业务实体
        CommunicationEntity entity = (CommunicationEntity) DataBusUtils.getValue(DataBusConstants.COMMUNICATION_ENTITY);

        // 准备外呼数据

        // 执行外呼

        // 处理外呼响应

        // 保存外呼结果


    }

    @Override
    public void doDatabase() {

    }

    @Override
    public void doGetServerTime() {

    }
}
