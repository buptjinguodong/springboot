package com.imooc.demo.service;

public interface CommunicationService {

    /**
     * 执行外呼操作 - simpleTransaction
     */
    public void doSimpleTransaction();

    /**
     * 数据库操作 - database
     */
    public void doDatabase();

    /**
     * 获取系统时间 - getServerTime
     */
    public void doGetServerTime();




}
