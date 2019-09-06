package com.hyou.codemaker.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 读数据源配置：从库，用于查询操作。
 * 
 * @author FengChangshuo
 * @version 1.0.0 2017年4月18日 上午10:05:07 created
 */
@Component("dataSourceProp")
@ConfigurationProperties(prefix = "jdbc.ds")
public class DataSourceProp extends BaseDataSourceProp {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -6531568782855319080L;
    
}
