package com.hyou.codemaker.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.TransactionInterceptor;

/**
 * 事务配置
 * 
 * @author FengChangshuo
 * @version 1.0.0 2017年4月19日 下午3:46:31 created
 */
@Configuration
public class ApplicationContextTransactionManager {
    
    @Bean
    public PlatformTransactionManager txManager(@Qualifier("dataSource") DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }
    
    @Bean
    public TransactionInterceptor txInterceptor(
            @Qualifier("txManager") PlatformTransactionManager txManager) {
        TransactionInterceptor transactionInterceptor = new TransactionInterceptor();
        transactionInterceptor.setTransactionManager(txManager);
        
        Properties transactionAttributes = new Properties();
        transactionAttributes.setProperty("get*", "PROPAGATION_SUPPORTS,readOnly");
        transactionAttributes.setProperty("select*", "PROPAGATION_SUPPORTS,readOnly");
        transactionAttributes.setProperty("nt*", "PROPAGATION_REQUIRES_NEW,-Exception");
        transactionAttributes.setProperty("nv*", "PROPAGATION_NEVER,-Exception");
        transactionAttributes.setProperty("*", "PROPAGATION_REQUIRED,-Exception");
        
        transactionInterceptor.setTransactionAttributes(transactionAttributes);
        return transactionInterceptor;
    }
    
    @Bean
    public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {
        BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
        beanNameAutoProxyCreator.setBeanNames("*InfoOper");
        beanNameAutoProxyCreator.setInterceptorNames("txInterceptor");
        return beanNameAutoProxyCreator;
    }
    
//    @Bean
//    public MyBeanNameAutoProxyCreator beanNameAutoProxyCreator() {
//        MyBeanNameAutoProxyCreator beanNameAutoProxyCreator = new MyBeanNameAutoProxyCreator();
//        beanNameAutoProxyCreator.setBeanNames("*Service");
//        beanNameAutoProxyCreator.setPackageNames("com.hyou.demos");
//        beanNameAutoProxyCreator.setInterceptorNames("txInterceptor");
//        return beanNameAutoProxyCreator;
//    }
    
}
