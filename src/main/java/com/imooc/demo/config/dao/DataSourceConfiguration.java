package com.imooc.demo.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

// Spring容器，检索相关的@Bean
@Configuration
// 配置mybatis mapper 的扫描路径
@MapperScan("com.imooc.demo.dao")
public class DataSourceConfiguration {

    @Value("${jdbc.driver}")
    private String jdbcDriver;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String jdbcUsername;
    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Bean(name="dataSource")
    public ComboPooledDataSource createDataDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        // 设置数据库驱动
        dataSource.setDriverClass(jdbcDriver);
        // 设置连接URL
        dataSource.setJdbcUrl(jdbcUrl);
        // 设置用户名
        dataSource.setUser(jdbcUsername);
        // 设置密码
        dataSource.setPassword(jdbcPassword);
        // 关闭连接后不自动Commit，如此才可激活事物来管理。
        dataSource.setAutoCommitOnClose(false);
        return dataSource;
    }
}
