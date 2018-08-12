package com.imooc.frame.flowctrl.flowcheck;

import com.imooc.frame.flowctrl.registry.ResourceRegistry;
import com.imooc.frame.flowctrl.resource.FailureResMeta;
import com.imooc.frame.flowctrl.resource.FlowResMeta;
import com.imooc.frame.swaparea.SwapArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Map;

public class DefaultFlowControl implements FlowControl{

    public ResourceRegistry getRegistry() {
        return registry;
    }

    public void setRegistry(ResourceRegistry registry) {
        this.registry = registry;
    }

    private ResourceRegistry registry;

    public DefaultFlowControl(ResourceRegistry resourceRegistry) {
        this.registry = resourceRegistry;
    }

    @Override
    public int doFlowCheck(String ctrlPointId, SwapArea swapArea, Map<String, FailureResMeta> transFailureResMap, Map<String, FlowResMeta> transFlowResMap) {
        // 检查流控开关
        if ("0".equals(registry.getIsctrl())) {
            // 流控开关为关闭，不进行流控
            return 3;
        }

        return 0;
    }

    @Override
    public void increaseFlowRes(Map<String, FailureResMeta> transFailureResMap, Map<String, FlowResMeta> transFlowResMap) {

    }

    @Override
    public void releaseFlowRes(Map<String, FailureResMeta> transFailureResMap, Map<String, FlowResMeta> transFlowResMap) {

    }
}
