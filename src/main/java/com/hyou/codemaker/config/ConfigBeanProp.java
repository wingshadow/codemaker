package com.hyou.codemaker.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.hyou.codemaker.common.bean.BaseBean;

@Component("configBeanProp")
@ConfigurationProperties(prefix = "config.bean")
public class ConfigBeanProp extends BaseBean {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -7213509503090119305L;
    
    /**
     * 数据库表名
     */
    private String tableName;

    /**
     * @return 数据库表名
     */
    public String getTableName() {
        return this.tableName;
    }

    /**
     * @param tableName 数据库表名
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    
}
