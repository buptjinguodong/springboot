/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.imooc.frame.exception;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 异常Log消息资源类
 *
 */
public class LogExceptionMessage implements InitializingBean {

    private static final Log log = LogFactory.getLog(LogExceptionMessage.class);

    public static ConcurrentHashMap<String, String> LOGMESSAGE = new ConcurrentHashMap<>();

    private static Resource[] configrations = null;

    private static List<Resource> resources = new ArrayList<>();

    private static ResourceLoader loader = new DefaultResourceLoader();

    private static String[] basenames;

    private static Locale runtimeLocale;

    /**
     * 加载配置资源文件
     */
    public void parserResource() {

        if (runtimeLocale == null) {
            runtimeLocale = RuntimeStaticsParam.runtimeLocal;
        }

        if (runtimeLocale == null) {
            runtimeLocale = Locale.getDefault();
        }

        if (runtimeLocale == null) {
            log.error("配置文件和环境中都没有配置运行时Locale信息");
            throw new RuntimeException("lack runtime locale information");
        }

        String language = runtimeLocale.getLanguage();
        String country = runtimeLocale.getCountry();

        if (configrations == null || configrations.length < 1) {

            for(String filePath : basenames) {
                if (StringUtils.hasText(language)) {
                    filePath = filePath + "_" + language;
                }

                if (StringUtils.hasText(country)) {
                    filePath = filePath + "_" + country;
                }

                filePath = filePath + ".properties";

                Resource resource = loader.getResource(filePath);

                if (resource != null) {
                    if (resource.exists()) {
                        resources.add(resource);
                    } else {
                        log.error(filePath + "的国际化文件不存在");
                    }
                }
            }
        } else {
            for (Resource resource : configrations) {
                if (resource != null) {
                    if (resource.exists()) {
                        resources.add(resource);
                    } else {
                        try {
                            log.error(resource.getURL().toString() + "的国际化文件不存在");
                        } catch (IOException e) {
                            log.error("获取日志的国际化配置url信息发生异常", e);
                        }
                    }
                }
            }
        }
    }

    public static String getMessage(String code) {
        if (StringUtils.hasText(code)) {
            return LOGMESSAGE.get(code);
        } else {
            return null;
        }
    }

    /**
     * 加载配置资源
     */
    public void loadProperties() {
        log.info("开始加载日志的国际化配置信息");
        if (resources != null && resources.size() > 0) {
            String filePath = null;
            for (Resource resource : resources) {
                try {
                    filePath = resource.getURL().toString();
                    log.info("当前加载的国际化配置信息文件为" + filePath);
                    Properties properties = PropertiesLoaderUtils.loadProperties(resource);
                    for (Map.Entry entry : properties.entrySet()) {
                        if (LOGMESSAGE.containsKey(entry.getKey())) {
                            // 在不同的配置文件中有相同的key={0}发生了冲突
                            throw  new RuntimeException("在不同的配置文件中有相同的key=" + (String) entry.getKey() + "发生了冲突");
                        }
                        LOGMESSAGE.put((String) entry.getKey(),
                                (String) entry.getValue());
                    }
                } catch (IOException e) {
                    log.error("加载日志的国际化配置信息[" + filePath + "]发生异常", e);
                }
            }
        }

        log.info("完成加载日志的国际化配置信息");
    }



    @Override
    public void afterPropertiesSet() throws Exception {
        parserResource();
        loadProperties();
    }

    public static Resource[] getConfigrations() {
        return configrations;
    }

    public static void setConfigrations(Resource[] configrations) {
        LogExceptionMessage.configrations = configrations;
    }

    public static List<Resource> getResources() {
        return resources;
    }

    public static void setResources(List<Resource> resources) {
        LogExceptionMessage.resources = resources;
    }

    public static ResourceLoader getLoader() {
        return loader;
    }

    public static void setLoader(ResourceLoader loader) {
        LogExceptionMessage.loader = loader;
    }

    public static String[] getBasenames() {
        return basenames;
    }

    public static void setBasenames(String[] basenames) {
        LogExceptionMessage.basenames = basenames;
    }

    public static Locale getRuntimeLocale() {
        return runtimeLocale;
    }

    public static void setRuntimeLocale(Locale runtimeLocale) {
        LogExceptionMessage.runtimeLocale = runtimeLocale;
    }
}
