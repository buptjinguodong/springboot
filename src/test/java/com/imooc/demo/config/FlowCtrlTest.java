package com.imooc.demo.config;

import com.google.gson.Gson;
import com.imooc.demo.entity.ParamDetail;
import com.imooc.demo.entity.ParamDir;
import com.imooc.demo.utils.ComFun;
import com.imooc.frame.flowctrl.config.FlowctrlConfigParser;
import com.imooc.frame.flowctrl.flowcheck.DefaultFlowControl;
import com.imooc.frame.flowctrl.registry.ResourceRegistry;
import com.imooc.frame.flowctrl.resource.FlowResGroupMeta;
import com.imooc.frame.flowctrl.resource.FlowResMeta;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Map;

// 使用Spring的UT来跑测试
@RunWith(SpringRunner.class)
@SpringBootTest
public class FlowCtrlTest {

    @Autowired
    @Qualifier("flowConfigParser")
    FlowctrlConfigParser flowConfigParser;

    @Autowired
    @Qualifier("resourceRegistry")
    ResourceRegistry registry;

    @Autowired
    @Qualifier("defaultFlowControl")
    DefaultFlowControl defaultFlowControl;

    @Autowired
    Gson gson;

    @Before
    public void setup() throws IOException {
        ComFun.log("~~setup~~");
    }

    @Test
    public void query() throws IOException {
        ComFun.log("FlowCtrlTestQuery Start~~~");
        assert registry.getIsctrl().equals("1");
        ComFun.log("FlowCtrlTestQuery End ~~~~");
    }

    @Test
    public void test4noctrlresource() {
        ComFun.log("~~test4noctrlresource~~");
        Map<String, FlowResGroupMeta> noCtrolResGroupMap = registry.getNoCtrlResGoupMap();
        FlowResGroupMeta flowResGroupMeta = noCtrolResGroupMap.get("1");
        assert flowResGroupMeta.getId().equals("1");
        assert flowResGroupMeta.getName().equals("['_service_id']");
        assert flowResGroupMeta.getType().equals("single");

        ComFun.log(gson.toJson(registry));

        ComFun.log("~~test4noctrlresource-END~~");

    }

    @Test
    public void test4defaultFlowControl() {
        ComFun.log("test4defaultFlowControl Start~~~");
        int ctrlRes = defaultFlowControl.doFlowCheck("3",null,null,null);

        assert ctrlRes == 3;

        ComFun.log("test4defaultFlowControl End ~~~~");
    }

}
