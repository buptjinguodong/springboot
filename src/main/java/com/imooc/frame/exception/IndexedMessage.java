package com.imooc.frame.exception;

public interface IndexedMessage {

    /**
     * 获取异常代码
     */
    String getCode();

    /**
     * 获取异常参数
     */
    Object[] getParameters();
}
