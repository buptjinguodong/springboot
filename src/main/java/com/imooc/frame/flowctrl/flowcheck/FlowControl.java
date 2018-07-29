package com.imooc.frame.flowctrl.flowcheck;

import com.imooc.frame.flowctrl.resource.FailureResMeta;
import com.imooc.frame.flowctrl.resource.FlowResMeta;
import com.imooc.frame.swaparea.SwapArea;

import java.util.Map;

/**
 * 流控组件-流控借口
 */
public interface FlowControl {

    /**
     * 执行流控检查
     *
     * @param ctrlPointId
     * @param swapArea
     * @param transFailureResMap
     * @param transFlowResMap
     * @return
     */
    int doFlowCheck(String ctrlPointId, SwapArea swapArea, Map<String, FailureResMeta> transFailureResMap, Map<String, FlowResMeta> transFlowResMap);

    void increaseFlowRes(Map<String, FailureResMeta> transFailureResMap, Map<String, FlowResMeta> transFlowResMap);

    void releaseFlowRes(Map<String, FailureResMeta> transFailureResMap, Map<String, FlowResMeta> transFlowResMap);

}
