package com.imooc.frame.flowctrl.resource;


import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 流控组件-流控资源描述类
 */
public class FlowResMeta {

    /**
     * 流量资源id（具体报文值）
     */
    private String id;

    /**
     * 最大容许的并发数
     */
    private AtomicInteger maxCapacity;

    /**
     * 并发量计数器
     */
    private AtomicInteger counter;

    /**
     * 流控策略
     */
    private String strategy;

    /**
     * 交易配置的最大并发数
     */
    private AtomicInteger quantity;

    /**
     * 交易配置的最大并发数占比
     */
    private AtomicInteger percentage;

    /**
     * 交易配置的初始值
     */
    private AtomicInteger initCapacity;

    private static final Log log = LogFactory.getLog(FlowResMeta.class);

    public static final String LOG001 = "";

    public FlowResMeta(String id, AtomicInteger maxCapacity,
                       AtomicInteger counter, String strategy, AtomicInteger quantity,
                       AtomicInteger percentage, AtomicInteger initCapacity) {
        this.id = id;
        this.maxCapacity = maxCapacity;
        this.counter = counter;
        this.strategy = strategy;
        this.quantity = quantity;
        this.percentage = percentage;
        this.initCapacity = initCapacity;
    }

    /**
     * 资源计数器以原子方式加1后返回
     *
     * @return 加1后返回的计数器当前值
     */
    public int counterAdd() {
        return this.counter.incrementAndGet();
    }

    /**
     * 资源计数器以原子方式减1后返回
     *
     * @return 减1后返回的计数器当前值
     */
    public int counterMinus() {
        return this.counter.decrementAndGet();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AtomicInteger getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(AtomicInteger maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public AtomicInteger getCounter() {
        return counter;
    }

    public void setCounter(AtomicInteger counter) {
        this.counter = counter;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public AtomicInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(AtomicInteger quantity) {
        this.quantity = quantity;
    }

    public AtomicInteger getPercentage() {
        return percentage;
    }

    public void setPercentage(AtomicInteger percentage) {
        this.percentage = percentage;
    }

    public AtomicInteger getInitCapacity() {
        return initCapacity;
    }

    public void setInitCapacity(AtomicInteger initCapacity) {
        this.initCapacity = initCapacity;
    }
}
