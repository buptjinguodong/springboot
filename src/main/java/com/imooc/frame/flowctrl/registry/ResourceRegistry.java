package com.imooc.frame.flowctrl.registry;

import com.imooc.frame.flowctrl.resource.FailureResGroupMeta;
import com.imooc.frame.flowctrl.resource.FlowResGroupMeta;
import com.imooc.frame.flowctrl.resource.StrategyMeta;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ResourceRegistry {
    private static final Log log = LogFactory.getLog(ResourceRegistry.class);

    /**
     * 流控开关
     */
    private String isctrl;

    /**
     * 存储流控接入点的List
     */
    private Map<String, List<String>> flowCtrlPoint;

    /**
     * 存储资源组的map，key为流量资源组id，value为流量资源组
     */
    private Map<String, FlowResGroupMeta> flowResGroupMap;

    /**
     * 存储故障资源组的map，key为故障资源类别（路径表达式），value为对应古故障资源组
     */
    private Map<String, FailureResGroupMeta> failureResGroupMap;

    /**
     * 存储流控策略的map
     */
    private Map<String, StrategyMeta> strategyMap;

    /**
     * 存储免流控交易组的map，key为组id，注意，此处存储的FlowResGroupMeta里面的map是没有内容的
     * 有效的免流控资源id都存储在noCtrlResMap的每个元素的list中
     */
    private Map<String, FlowResGroupMeta> noCtrlResGoupMap;

    /**
     * 存储免流控交易的map，key为组id，value为免流控资源的值列表
     */
    private Map<String, List<String>> noCtrlResMap;

    /**
     * 存储流控类型的map，key为流控类型，value为流控类型描述
     */
    private Map<String, String> flowTypeMap;

    /**
     * 存储组流控策略的map
     */
    private Map<String, StrategyMeta> groupStrategyMap;

    /**
     * 构造方法
     * <p></p>
     *
     */
    public ResourceRegistry() {
        this.flowCtrlPoint = new ConcurrentHashMap<String, List<String>>();
        this.flowResGroupMap = new ConcurrentHashMap<String, FlowResGroupMeta>();
        this.failureResGroupMap = new ConcurrentHashMap<String, FailureResGroupMeta>();
        this.strategyMap = new ConcurrentHashMap<String, StrategyMeta>();
        this.isctrl = "1";
        this.noCtrlResGoupMap = new ConcurrentHashMap<String, FlowResGroupMeta>();
        this.noCtrlResMap = new ConcurrentHashMap<String, List<String>>();
        this.flowTypeMap = new ConcurrentHashMap<String, String>();
        this.groupStrategyMap = new ConcurrentHashMap<String, StrategyMeta>();
    }

    public String getIsctrl() {
        return isctrl;
    }

    public void setIsctrl(String isctrl) {
        this.isctrl = isctrl;
    }

    public Map<String, List<String>> getFlowCtrlPoint() {
        return flowCtrlPoint;
    }

    public void setFlowCtrlPoint(Map<String, List<String>> flowCtrlPoint) {
        this.flowCtrlPoint = flowCtrlPoint;
    }

    public Map<String, FlowResGroupMeta> getFlowResGroupMap() {
        return flowResGroupMap;
    }

    public void setFlowResGroupMap(Map<String, FlowResGroupMeta> flowResGroupMap) {
        this.flowResGroupMap = flowResGroupMap;
    }

    public Map<String, FailureResGroupMeta> getFailureResGroupMap() {
        return failureResGroupMap;
    }

    public void setFailureResGroupMap(Map<String, FailureResGroupMeta> failureResGroupMap) {
        this.failureResGroupMap = failureResGroupMap;
    }

    public Map<String, StrategyMeta> getStrategyMap() {
        return strategyMap;
    }

    public void setStrategyMap(Map<String, StrategyMeta> strategyMap) {
        this.strategyMap = strategyMap;
    }

    public Map<String, FlowResGroupMeta> getNoCtrlResGoupMap() {
        return noCtrlResGoupMap;
    }

    public void setNoCtrlResGoupMap(Map<String, FlowResGroupMeta> noCtrlResGoupMap) {
        this.noCtrlResGoupMap = noCtrlResGoupMap;
    }

    public Map<String, List<String>> getNoCtrlResMap() {
        return noCtrlResMap;
    }

    public void setNoCtrlResMap(Map<String, List<String>> noCtrlResMap) {
        this.noCtrlResMap = noCtrlResMap;
    }

    public Map<String, String> getFlowTypeMap() {
        return flowTypeMap;
    }

    public void setFlowTypeMap(Map<String, String> flowTypeMap) {
        this.flowTypeMap = flowTypeMap;
    }

    public Map<String, StrategyMeta> getGroupStrategyMap() {
        return groupStrategyMap;
    }

    public void setGroupStrategyMap(Map<String, StrategyMeta> groupStrategyMap) {
        this.groupStrategyMap = groupStrategyMap;
    }

    public FlowResGroupMeta addNoCtrlResGoupMap(FlowResGroupMeta flowResGroupMeta) {
        return this.noCtrlResGoupMap.put(flowResGroupMeta.getId(), flowResGroupMeta);
    }

    public List<String> getNoCtrlResMap(String resgroupNodeIdAttr) {
        return this.noCtrlResMap.get(resgroupNodeIdAttr);
    }

    public void addNoCtrlFlowRes(String resgroupNodeIdAttr, List<String> resList) {
        this.noCtrlResMap.put(resgroupNodeIdAttr, resList);
    }

    public void addFlowResGoupMap(FlowResGroupMeta flowResGroupMeta) {
        this.flowResGroupMap.put(flowResGroupMeta.getId(), flowResGroupMeta);
    }
}
