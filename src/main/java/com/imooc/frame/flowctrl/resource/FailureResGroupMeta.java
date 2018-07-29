package com.imooc.frame.flowctrl.resource;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 流控组件-流控资源组描述类
 */
public class FailureResGroupMeta {

    /**
     * 故障资源类别（路径表达式），用于从请求信息中识别对应的资源id
     */
    private String failureResType;

    /**
     * 存储故障资源的map，key为故障资源id（具体报文字段值），value为对应的故障资源信息
     */
    private Map<String, FailureResMeta> failureResMap;

    public FailureResGroupMeta(String failureResType) {
        this.failureResType = failureResType;
        this.failureResMap = new ConcurrentHashMap<String, FailureResMeta>();
    }

    public String getFailureResType() {
        return failureResType;
    }

    public void setFailureResType(String failureResType) {
        this.failureResType = failureResType;
    }

    public Map<String, FailureResMeta> getFailureResMap() {
        return failureResMap;
    }

    public void setFailureResMap(Map<String, FailureResMeta> failureResMap) {
        this.failureResMap = failureResMap;
    }
}
