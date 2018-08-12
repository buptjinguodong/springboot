package com.imooc.frame.flowctrl.config;

import com.imooc.frame.flowctrl.registry.ResourceRegistry;
import com.imooc.frame.flowctrl.resource.FlowResGroupMeta;
import com.imooc.frame.flowctrl.resource.FlowResMeta;
import com.imooc.frame.util.XMLUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.util.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class XmlFlowctrlConfigParser implements FlowctrlConfigParser{

    private static final Logger log = LoggerFactory.getLogger(XmlFlowctrlConfigParser.class);

    public static final String LOG001 = "";
    public static final String LOG002 = "";
    public static final String LOG003 = "";
    public static final String LOG004 = "";
    public static final String LOG005 = "";
    public static final String LOG006 = "";
    public static final String LOG007 = "";
    public static final String LOG008 = "";
    public static final String LOG009 = "准备加载并解析报文适配配置，配置文件数量为{0}！";
    public static final String LOG010 = "";
    public static final String LOG011 = "";
    public static final String LOG012 = "";
    public static final String LOG013 = "";
    public static final String LOG014 = "";

    /**
     * 默认配置文件路径
     */
    public static final String DEFAULT_CONFIG_PATH = "flowctrl/flowctrl.xml";

    /**
     * 流控接入点相关配置属性名称
     * @return
     */
    protected static final String ISCTRL_ATTR = "isctrl";
    protected static final String CTRLPOINT_ELM = "ctrlpoint";
    protected static final String POINT_ELM = "point";
    protected static final String CTRLPOINT_ID_ATTR = "id";
    protected static final String CTRLPOINT_VALUE_ATTR = "value";

    /**
     * 流控资源相关配置属性名称
     */
    protected static final String RESOURCE_ELM = "resource";
    protected static final String RESGROUP_ELM = "resgroup";
    protected static final String RESGROUP_ID_ATTR = "id";
    protected static final String RESGROUP_NAME_ATTR = "name";
    protected static final String RESGROUP_TYPE_ATTR = "type";
    protected static final String RESGROUP_TOTAL_ATTR = "total";
    protected static final String RESMEMBER_ELM = "resmember";
    protected static final String RESMEMBER_ID_ATTR = "id";
    protected static final String RESMEMBER_QUANTITY_ATTR = "quantity";
    protected static final String RESMEMBER_PERCENTAGE_ATTR = "percentage";
    protected static final String RESMEMBER_STRATEGY_ATTR = "strategy";
    protected static final String NOCTRLRESOURCE_ELM = "noctrlresource";
    protected static final String RESGROUP_FLOWTYPE_ATTR = "flowtype";
    protected static final String RESGROUP_FLOWTYPEDESC_ATTR = "flowtypedesc";
    protected static final String RESGROUP_GROUPSTRATEGY_ATTR = "groupstrategy";
    protected static final String RESGROUP_STRATEGY_ELM = "groupstrategy";

    /**
     * 流控策略相关配置属性名称
     */
    protected static final String STRATEGY_EML = "strategy";
    protected static final String STGYMEMBER_EML = "stgymember";
    protected static final String STRATYGY_NAME_ATTR = "name";
    protected static final String STRATEGY_CLASSNAME_ATTR = "classname";



    public Resource[] getConfigrations() {
        return configrations;
    }

    public void setConfigrations(Resource[] configrations) {
        this.configrations = configrations;
    }


    /**
     * 配置文件资源数组
     */
    private Resource[] configrations = null;

    /**
     * 资源注册管理器
     */
    private ResourceRegistry registry = null;

    /**
     * spring上下文
     */
    private ApplicationContext applicationContext = null;

    /**
     * 构造方法注入
     *
     * @param registry
     */
    public XmlFlowctrlConfigParser(ResourceRegistry registry) {
        this.registry = registry;
    }

    @Override
    public void parse() throws IOException {
        if (configrations != null) {
            log.debug(LOG009);
        } else {
            // 未找到报文适配配置文件，放弃加载过程。
            log.error(LOG010);
        }
        log.debug(LOG001);
        for (Resource recource : configrations) {
            InputStream is = recource.getInputStream();
            Document document = XMLUtils.getDocument(is);
            // 解析流控开关配置
            parseIsCtrl(document.getDocumentElement());
            // 解析免流控交易配置
            parseNoCtrlFlowRes(document.getDocumentElement());
            // 解析流控点配置
            parseCtrlPoint(document.getDocumentElement());
            // 解析流控策略配置

            // 解析流控资源配置
            parseFlowRes(document.getDocumentElement());
            // 解析流控资源组策略
        }

    }

    /**
     * 解析流控接入点配置信息
     * @param element
     */
    private void parseCtrlPoint(Element element) {
        // Map<String, List<String>> flowCtrlPoint;
        // 获取控制点Node
        List<Node> nodeList = XMLUtils.childNodeList(element, CTRLPOINT_ELM);
        if (nodeList == null || nodeList.size() == 0) {
            return ;
        }
        for (Node item : nodeList) {
            Node ctrlpointNode = item;
            List<Node> pointNodeList = XMLUtils.childNodeList(ctrlpointNode, POINT_ELM);
            if (pointNodeList == null) {
                return;
            }
            for (Node itemJ : pointNodeList) {
                // 解析流控点point
                Node pointNode = itemJ;
                String pointIdAttr = XMLUtils.getNodeAttributeValue(pointNode, CTRLPOINT_ID_ATTR);
                String pointValueAttr = XMLUtils.getNodeAttributeValue(pointNode, CTRLPOINT_VALUE_ATTR);
                String[] pointValueArr = pointValueAttr.split(",");
                List<String> pointValueArrList = Arrays.asList(pointValueArr);
                registry.getFlowCtrlPoint().put(pointIdAttr, pointValueArrList);
            }
        }
    }


    /**
     * 解析流控配置
     */
    private void parseFlowRes(Element element) {
        log.info("Doing parseFlowRes");
        // 获取流控node
        List<Node> nodeList = XMLUtils.childNodeList(element, RESOURCE_ELM);
        if (nodeList == null || nodeList.size() == 0) {
            return ;
        }
        for (Node item : nodeList) {
            Node resourceNode = item;
            List<Node> resgroupNodeList = XMLUtils.childNodeList(resourceNode, RESGROUP_ELM);
            if (resgroupNodeList == null) {
                return;
            }
            for (Node itemJ : resgroupNodeList) {
                // 解析资源组
                Node resgroupNode = itemJ;
                String resgroupNodeIdAttr = XMLUtils.getNodeAttributeValue(resgroupNode, RESGROUP_ID_ATTR);
                String resgroupNodeNameAttr = XMLUtils.getNodeAttributeValue(resgroupNode, RESGROUP_NAME_ATTR);
                String resgroupNodeTypeAttr = XMLUtils.getNodeAttributeValue(resgroupNode, RESGROUP_TYPE_ATTR);
                String resgroupNodeTotalAttr = XMLUtils.getNodeAttributeValue(resgroupNode, RESGROUP_TOTAL_ATTR);
                String resgroupNodeFlowtypeAttr = XMLUtils.getNodeAttributeValue(resgroupNode, RESGROUP_FLOWTYPE_ATTR);
                String resgroupNodeFlowtypedescAttr = XMLUtils.getNodeAttributeValue(resgroupNode, RESGROUP_FLOWTYPEDESC_ATTR);
                String resgroupNodeGroupstrategyAttr = XMLUtils.getNodeAttributeValue(resgroupNode, RESGROUP_GROUPSTRATEGY_ATTR);
                FlowResGroupMeta flowResGroupMeta = new FlowResGroupMeta(
                        resgroupNodeIdAttr,
                        resgroupNodeNameAttr,
                        resgroupNodeTypeAttr,
                        resgroupNodeTotalAttr,
                        resgroupNodeFlowtypeAttr,
                        resgroupNodeFlowtypedescAttr,
                        resgroupNodeGroupstrategyAttr
                );
                registry.addFlowResGoupMap(flowResGroupMeta);

                // 解析资源
                List<Node> resmemberNodeList = XMLUtils.childNodeList(resgroupNode, RESMEMBER_ELM);
                Map<String, FlowResMeta> flowResMap = new HashMap<>();
                Node resmemberNode = null;
                String resmemberNodeIdAttr = null;
                String resmemberNodeQuantityAttr = null;
                String resmemberNodePercentageAttr = null;
                String resmemberNodeStrategyAttr = null;
                for (Node itemK : resmemberNodeList) {
                    resmemberNode = itemK;
                    resmemberNodeIdAttr = XMLUtils.getNodeAttributeValue(resmemberNode, RESMEMBER_ID_ATTR);
                    resmemberNodeQuantityAttr = XMLUtils.getNodeAttributeValue(resmemberNode, RESMEMBER_QUANTITY_ATTR);
                    resmemberNodePercentageAttr = XMLUtils.getNodeAttributeValue(resmemberNode, RESMEMBER_PERCENTAGE_ATTR);
                    resmemberNodeStrategyAttr = XMLUtils.getNodeAttributeValue(resmemberNode, RESMEMBER_STRATEGY_ATTR);
                    Integer maxCapacity = 0;
                    if ("absolute".equalsIgnoreCase(resgroupNodeTypeAttr)) {
                        maxCapacity = Integer.parseInt(resmemberNodeQuantityAttr);
                    } else if ("percentage".equalsIgnoreCase(resgroupNodeTypeAttr)) {
                        maxCapacity = Integer.valueOf ((int) (Integer.parseInt((resgroupNodeTotalAttr)) * Float.parseFloat(resmemberNodePercentageAttr) / 100.0));
                    } else if ("both".equalsIgnoreCase(resgroupNodeTypeAttr)) {
                        maxCapacity = Integer.valueOf ((int) (Integer.parseInt((resgroupNodeTotalAttr)) * Float.parseFloat(resmemberNodePercentageAttr) / 100.0));
                        if (StringUtils.hasText(resmemberNodeQuantityAttr) && maxCapacity > Integer.parseInt(resmemberNodeQuantityAttr)) {
                            maxCapacity = Integer.parseInt(resmemberNodeQuantityAttr);
                        }
                    }
                    FlowResMeta flowResMeta = new FlowResMeta(
                            resmemberNodeIdAttr,
                            new AtomicInteger(maxCapacity),
                            new AtomicInteger(0),
                            resmemberNodeStrategyAttr,
                            resmemberNodeQuantityAttr!=null?new AtomicInteger(Integer.parseInt(resmemberNodeQuantityAttr)):null,
                            resmemberNodePercentageAttr!=null?new AtomicInteger(Integer.parseInt(resmemberNodePercentageAttr)):null,
                            new AtomicInteger(0)
                    );
                    flowResMap.put(resmemberNodeIdAttr, flowResMeta);
                }
                flowResGroupMeta.setFlowResMap(flowResMap);
            }
        }
        log.info("End parseFlowRes");
    }

    /**
     * 解析免流控配置
     * @param element
     */
    private void parseNoCtrlFlowRes(Element element) {
        log.info("Doing parseNoCtrlFlowRes");
        // 获取免流控node
        List<Node> nodeList = XMLUtils.childNodeList(element, NOCTRLRESOURCE_ELM);
        if (nodeList == null || nodeList.size() == 0) {
            return ;
        }
        for (Node item : nodeList) {
            Node noctrlresourceNode = item;
            List<Node> resgroupNodeList = XMLUtils.childNodeList(noctrlresourceNode, RESGROUP_ELM);
            if (resgroupNodeList == null || resgroupNodeList.size() == 0) {
                return ;
            }
            for (Node itemJ : resgroupNodeList) {
                Node resgroupNode = itemJ;
                // 解析资源组
                String resgroupNodeIdAttr = XMLUtils.getNodeAttributeValue(resgroupNode, RESGROUP_ID_ATTR);
                String resgroupNodeNameAttr = XMLUtils.getNodeAttributeValue(resgroupNode, RESGROUP_NAME_ATTR);
                String resgroupNodeTypeAttr = XMLUtils.getNodeAttributeValue(resgroupNode, RESGROUP_TYPE_ATTR);
                String resgroupNodeTotalAttr = XMLUtils.getNodeAttributeValue(resgroupNode, RESGROUP_TOTAL_ATTR);
                String resgroupNodeFlowtypeAttr = XMLUtils.getNodeAttributeValue(resgroupNode, RESGROUP_FLOWTYPE_ATTR);
                String resgroupNodeFlowtypedescAttr = XMLUtils.getNodeAttributeValue(resgroupNode, RESGROUP_FLOWTYPEDESC_ATTR);
                String resgroupNodeGroupstrategyAttr = XMLUtils.getNodeAttributeValue(resgroupNode, RESGROUP_GROUPSTRATEGY_ATTR);
                FlowResGroupMeta flowResGroupMeta = new FlowResGroupMeta(
                        resgroupNodeIdAttr,
                        resgroupNodeNameAttr,
                        resgroupNodeTypeAttr,
                        resgroupNodeTotalAttr,
                        resgroupNodeFlowtypeAttr,
                        resgroupNodeFlowtypedescAttr,
                        resgroupNodeGroupstrategyAttr
                );
                Map<String, FlowResMeta> flowResMap = new HashMap<>();

                // 解析资源
                List<Node> resmemberNodeList = XMLUtils.childNodeList(resgroupNode, RESMEMBER_ELM);
                if (resmemberNodeList == null || resmemberNodeList.size() == 0) {
                    return ;
                }
                Node resmemberNode = null;
                String resmemberNodeIdAttr = null;
                List<String> resList = registry.getNoCtrlResMap(resgroupNodeIdAttr);
                if (resList == null) {
                    resList = new ArrayList<>();
                }
                for (Node itemK : resmemberNodeList) {
                    resmemberNode = itemK;
                    resmemberNodeIdAttr = XMLUtils.getNodeAttributeValue(resmemberNode, RESMEMBER_ID_ATTR);

                    if ("single".equalsIgnoreCase(resgroupNodeTypeAttr)) {
                        String[] valArray = resmemberNodeIdAttr.split(",");
                        for (String resId : valArray) {
                            resList.add(resId);
                        }
                    } else if ("complex".equalsIgnoreCase(resgroupNodeFlowtypeAttr)) {
                        resList.add(resmemberNodeIdAttr);
                    }
                }
                registry.addNoCtrlFlowRes(resgroupNodeIdAttr, resList);
                registry.addNoCtrlResGoupMap(flowResGroupMeta);
            }

        }
        log.info("End parseNoCtrlFlowRes");
    }

    private void parseIsCtrl(Element element) {
        log.info("Doing parseIsCtrl");
        registry.setIsctrl(XMLUtils.getNodeAttributeValue(element, ISCTRL_ATTR));
        log.info("End parseIsCtrl");
    }


    public void setConfigration(Resource res1) {

    }
}
