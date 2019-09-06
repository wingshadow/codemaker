package com.hyou.codemaker.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.PoolConfiguration;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * 跟数据源有关的Bean配置
 * 
 * @author FengChangshuo
 * @version 1.0.0 2017年4月19日 下午2:34:10 created
 */
@Configuration
public class ApplicationContextDataSource {
    
    private static final Logger log = LoggerFactory.getLogger(ApplicationContextDataSource.class);
    
    @Resource(name = "dataSourceProp")
    private DataSourceProp dataSourceProp;
    
    /**
     * @return 数据源
     */
    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        log.info("dataSourceProp : {}", dataSourceProp);
        return makeDataSource(dataSourceProp);
    }
    
    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource)
            throws Exception {
        return sqlSessionFactoryCreater(dataSource);
    }
    
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(
            @Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    
    /**
     * 构造Tomcat数据源实例
     * 
     * @param dataSourceProp 数据源配置参数
     * @return 数据源对象
     */
    private DataSource makeDataSource(BaseDataSourceProp dataSourceProp) {
        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
        
        PoolConfiguration poolProperties = new PoolProperties();
        poolProperties.setDriverClassName(dataSourceProp.getDriverClassName());
        poolProperties.setUrl(dataSourceProp.getUrl());
        poolProperties.setUsername(dataSourceProp.getUsername());
        poolProperties.setPassword(dataSourceProp.getPassword());
        poolProperties.setJmxEnabled(dataSourceProp.isJmxEnabled());
        poolProperties.setTestWhileIdle(dataSourceProp.isTestWhileIdle());
        poolProperties.setTestOnBorrow(dataSourceProp.isTestOnBorrow());
        poolProperties.setTestOnReturn(dataSourceProp.isTestOnReturn());
        poolProperties.setValidationInterval(dataSourceProp.getValidationInterval());
        poolProperties.setValidationQuery(dataSourceProp.getValidationQuery());
        poolProperties.setTimeBetweenEvictionRunsMillis(dataSourceProp.getTimeBetweenEvictionRunsMillis());
        poolProperties.setMaxActive(dataSourceProp.getMaxActive());
        poolProperties.setInitialSize(dataSourceProp.getInitialSize());
        poolProperties.setMaxWait(dataSourceProp.getMaxWait());
        poolProperties.setRemoveAbandoned(dataSourceProp.isRemoveAbandoned());
        poolProperties.setRemoveAbandonedTimeout(dataSourceProp.getRemoveAbandonedTimeout());
        poolProperties.setMinEvictableIdleTimeMillis(dataSourceProp.getMinEvictableIdleTimeMillis());
        poolProperties.setMinIdle(dataSourceProp.getMinIdle());
        poolProperties.setLogAbandoned(dataSourceProp.isLogAbandoned());
        
        String jdbcInterceptors = "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"
                + "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer";
        poolProperties.setJdbcInterceptors(jdbcInterceptors);
        
        dataSource.setPoolProperties(poolProperties);
        return dataSource;
    }
    
    private SqlSessionFactory sqlSessionFactoryCreater(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        
        PathMatchingResourcePatternResolver resourceLoader = new PathMatchingResourcePatternResolver();
        sqlSessionFactory.setConfigLocation(resourceLoader.getResource("classpath:mybatis-config.xml"));
        
        org.springframework.core.io.Resource[] mapperLocations = resourceLoader
                .getResources("classpath*:com/hyou/codemaker/db/mapper/**/*Mapper.xml");
        sqlSessionFactory.setMapperLocations(mapperLocations);
        
        return sqlSessionFactory.getObject();
    }
    
}
