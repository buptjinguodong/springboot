package com.imooc.demo.config.core;

import com.imooc.frame.flowctrl.config.XmlFlowctrlConfigParser;
import com.imooc.frame.flowctrl.flowcheck.DefaultFlowControl;
import com.imooc.frame.flowctrl.flowcheck.FlowControl;
import com.imooc.frame.flowctrl.registry.ResourceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class FlowctrlConfiguration {

    @Autowired
    @Qualifier("resourceRegistry")
    private ResourceRegistry resourceRegistry;

    @Autowired
    @Qualifier("flowConfigParser")
    private XmlFlowctrlConfigParser xmlFlowctrlConfigParser;

    @Bean(name="resourceRegistry")
    public ResourceRegistry createResourceRegistry() {
        ResourceRegistry resourceRegistry = new ResourceRegistry();
        return resourceRegistry;
    }

    @Bean(name="flowConfigParser")
    public XmlFlowctrlConfigParser createXmlFlowctrlConfigParser() {
        XmlFlowctrlConfigParser xmlFlowctrlConfigParser = new XmlFlowctrlConfigParser(resourceRegistry);
//        xmlFlowctrlConfigParser.setConfigrations("classpath*:application/flowctrl.xml");
//        List<Resource> resources = new ArrayList<>();
        Resource res1 = new ClassPathResource("application/flowctrl.xml");
        Resource[] resources = new Resource[1];
        resources[0] = res1;

        xmlFlowctrlConfigParser.setConfigrations(resources);
//        xmlFlowctrlConfigParser.setConfigration(res1);
        return xmlFlowctrlConfigParser;
    }

    @Bean(name="defaultFlowControl")
    public DefaultFlowControl createDefaultFlowControl() throws IOException {
        xmlFlowctrlConfigParser.parse();
        DefaultFlowControl defaultFlowControl = new DefaultFlowControl(resourceRegistry);
        return defaultFlowControl;
    }


}
