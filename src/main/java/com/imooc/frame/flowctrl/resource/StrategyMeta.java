package com.imooc.frame.flowctrl.resource;

/**
 * 流控组件-流控策略描述类
 */
public class StrategyMeta {

    /**
     * 流控策略名
     */
    private String name;

    /**
     * 流控实现类
     */
    private String classname;

    public StrategyMeta(String name, String classname) {
        this.name = name;
        this.classname = classname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }
}
