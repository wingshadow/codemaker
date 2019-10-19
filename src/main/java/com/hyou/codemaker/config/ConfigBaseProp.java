package com.hyou.codemaker.config;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.hyou.codemaker.common.bean.BaseBean;

/**
 * 基本配置部分
 * 
 * @author FengChangshuo
 * @version 1.0.0 2017年6月26日 下午4:44:02 created
 */
@Component("configBaseProp")
@ConfigurationProperties(prefix = "config.base")
public class ConfigBaseProp extends BaseBean {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -285639777059501098L;

    private String basePackage;

    /**
     * 生成的代码文件的存放目录
     */
    private String destDir;

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    /**
     * 生成的pojo类的包路径
     */
    private String pojoPackage;
    
    /**
     * 生成dao类的包路径
     */
    private String daoPackage;
    
    /**
     * 生成Service接口类的包路径
     */
    private String serviceItfcPackage;
    
    /**
     * 生成的Service抽象类的包路径
     */
    private String serviceAbsPackage;
    
    /**
     * 生成Service实现类的包路径
     */
    private String serviceImplPackage;
    
    /**
     * 数据库实例名
     */
    private String schameName;
    
    /**
     * 代码作者
     */
    private String author;
    
    /**
     * 代码版本
     */
    private String version;

    private String dataBaseType;

    private String controllerPackage;
    
    /**
     * @return 生成的代码文件的存放目录
     */
    public String getDestDir() {
        return this.destDir;
    }
    
    /**
     * @param destDir 生成的代码文件的存放目录
     */
    public void setDestDir(String destDir) {
        this.destDir = destDir;
    }
    
    /**
     * @return 生成的pojo类的包路径
     */
    public String getPojoPackage() {
        return this.pojoPackage;
    }
    
    /**
     * @param pojoPackage 生成的pojo类的包路径
     */
    public void setPojoPackage(String pojoPackage) {
        this.pojoPackage = pojoPackage;
    }
    
    /**
     * @return 数据库实例名
     */
    public String getSchameName() {
        return this.schameName;
    }
    
    /**
     * @param schameName 数据库实例名
     */
    public void setSchameName(String schameName) {
        this.schameName = schameName;
    }

    /**
     * @return 生成dao类的包路径
     */
    public String getDaoPackage() {
        return this.daoPackage;
    }

    /**
     * @param daoPackage 生成dao类的包路径
     */
    public void setDaoPackage(String daoPackage) {
        this.daoPackage = daoPackage;
    }

    /**
     * @return 生成Service接口类的包路径
     */
    public String getServiceItfcPackage() {
        return this.serviceItfcPackage;
    }

    /**
     * @param serviceItfcPackage 生成Service接口类的包路径
     */
    public void setServiceItfcPackage(String serviceItfcPackage) {
        this.serviceItfcPackage = serviceItfcPackage;
    }

    /**
     * @return 生成Service实现类的包路径
     */
    public String getServiceImplPackage() {
        return this.serviceImplPackage;
    }

    /**
     * @param serviceImplPackage 生成Service实现类的包路径
     */
    public void setServiceImplPackage(String serviceImplPackage) {
        this.serviceImplPackage = serviceImplPackage;
    }

    /**
     * @return 生成的Service抽象类的包路径
     */
    public String getServiceAbsPackage() {
        return this.serviceAbsPackage;
    }

    /**
     * @param serviceAbsPackage 生成的Service抽象类的包路径
     */
    public void setServiceAbsPackage(String serviceAbsPackage) {
        this.serviceAbsPackage = serviceAbsPackage;
    }

    /**
     * @return 代码作者
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * @param author 代码作者
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return 代码版本
     */
    public String getVersion() {
        return this.version;
    }

    /**
     * @param version 代码版本
     */
    public void setVersion(String version) {
        this.version = version;
    }

    public String getDataBaseType() {
        return dataBaseType;
    }

    public void setDataBaseType(String dataBaseType) {
        this.dataBaseType = dataBaseType;
    }

    public String getControllerPackage() {
        return controllerPackage;
    }

    public void setControllerPackage(String controllerPackage) {
        this.controllerPackage = controllerPackage;
    }
}
