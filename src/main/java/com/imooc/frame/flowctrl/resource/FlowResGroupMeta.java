package com.imooc.frame.flowctrl.resource;

import com.imooc.demo.utils.ComFun;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class FlowResGroupMeta {

    private static final Log log = LogFactory.getLog(FlowResGroupMeta.class);
    public  static final String LOG001 = "";

    /**
     * 资源组id
     */
    private String id;

    /**
     * 资源组名称
     */
    private String name;

    /**
     * 免流控资源组类别，single-单一条件；complex-复合条件
     * 流控资源组并发控制类别，absolute-根据绝对值控制并发；percentage-根据百分比控制并发；both-上述两个条件一起控制
     */
    private String type;

    /**
     * 资源组总并发数限制，与百分比配置联合使用
     */
    private AtomicInteger total;

    /**
     * 流控类型，针对每个资源组，该值唯一
     */
    private String flowtype;

    /**
     * 流控类型描述
     */
    private String flowtypedesc;

    /**
     * 存储流控资源的map，key为流量资源id，value为流量资源信息
     */
    private Map<String, FlowResMeta> flowResMap;

    /**
     * 流量组策略
     */
    private String groupStrategy = null;

    /**
     *
     * @param id
     * @param name
     * @param type
     * @param total
     * @param flowtype
     * @param flowtypedesc
     * @param groupStrategy
     */
    public FlowResGroupMeta(String id, String name, String type, String total, String flowtype, String flowtypedesc, String groupStrategy) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.flowtype = flowtype;
        this.flowtypedesc = flowtypedesc;
        this.groupStrategy = groupStrategy;

        try {
            if (total != null) {
                this.total = new AtomicInteger(Integer.parseInt(total));
            } else {
                this.total = null;
            }
        } catch (NumberFormatException ne) {
            ComFun.log(ne.getMessage());
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public AtomicInteger getTotal() {
        return total;
    }

    public void setTotal(AtomicInteger total) {
        this.total = total;
    }

    public String getFlowtype() {
        return flowtype;
    }

    public void setFlowtype(String flowtype) {
        this.flowtype = flowtype;
    }

    public String getFlowtypedesc() {
        return flowtypedesc;
    }

    public void setFlowtypedesc(String flowtypedesc) {
        this.flowtypedesc = flowtypedesc;
    }

    public Map<String, FlowResMeta> getFlowResMap() {
        return flowResMap;
    }

    public void setFlowResMap(Map<String, FlowResMeta> flowResMap) {
        this.flowResMap = flowResMap;
    }

    public String getGroupStrategy() {
        return groupStrategy;
    }

    public void setGroupStrategy(String groupStrategy) {
        this.groupStrategy = groupStrategy;
    }
}
