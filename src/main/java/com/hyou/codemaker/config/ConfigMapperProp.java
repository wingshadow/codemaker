package com.hyou.codemaker.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.hyou.codemaker.common.bean.BaseBean;

@Component("configMapperProp")
@ConfigurationProperties(prefix = "config.mapper")
public class ConfigMapperProp extends BaseBean {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 5005368918502213479L;
    
    /**
     * 是否启动使用SQLMapper接口方式生成
     */
    private boolean useDao;
    
    /**
     * 命名空间前缀
     */
    private String namespacePrefix;
    
    /**
     * @return 是否启动使用SQLMapper接口方式生成
     */
    public boolean isUseDao() {
        return this.useDao;
    }
    
    /**
     * @param withDao 是否启动使用SQLMapper接口方式生成
     */
    public void setUseDao(boolean useDao) {
        this.useDao = useDao;
    }
    
    /**
     * @return 命名空间前缀
     */
    public String getNamespacePrefix() {
        return this.namespacePrefix;
    }
    
    /**
     * @param namespacePrefix 命名空间前缀
     */
    public void setNamespacePrefix(String namespacePrefix) {
        this.namespacePrefix = namespacePrefix;
    }
    
}
