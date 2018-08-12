package com.imooc.frame.flowctrl.resource;


import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 流控组件-故障资源描述类
 */
public class FailureResMeta {

    /**
     * 故障资源id（具体报文字段值）
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

    private static final Log log = LogFactory.getLog(FailureResMeta.class);

    public static final String LOG001 = "";

    /**
     * 根据最大并发数和计数器构建资源对象
     *
     * @param id
     * @param maxCapacity
     * @param counter
     */
    public FailureResMeta(String id, AtomicInteger maxCapacity,
                          AtomicInteger counter) {
        this.id = id;
        this.maxCapacity = maxCapacity;
        this.counter = counter;
    }

    /**
     * 资源计数器以原子方式加1后返回
     */
    public int counterAdd() {
        return this.counter.incrementAndGet();
    }

    /**
     * 资源计数器以原子方式减1后返回
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
}
