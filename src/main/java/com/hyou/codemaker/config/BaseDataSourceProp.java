package com.hyou.codemaker.config;

import com.hyou.codemaker.common.bean.BaseBean;

/**
 * 数据源配置
 * 
 * @author FengChangshuo
 * @version 1.0.0 2017年4月19日 下午2:31:17 created
 */
public class BaseDataSourceProp extends BaseBean {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -3665839357719610619L;
    
    /**
     * 数据库连接驱动类
     */
    private String driverClassName;
    
    /**
     * 数据库连接URL
     */
    private String url;
    
    /**
     * 数据库登录用户名
     */
    private String username;
    
    /**
     * 数据库登录密码
     */
    private String password;
    
    /**
     * 注册连接池是否使用jmx
     */
    private boolean jmxEnabled;
    
    /**
     * 空闲时是否验证连接，（如果验证不通过则移除连接）为true时必须设置validationQuery属性
     */
    private boolean testWhileIdle;
    
    /**
     * 对象再用连接连数据库之前是否验证连接可用性，为true时必须设置validationQuery属性
     */
    private boolean testOnBorrow;
    
    /**
     * 是否对数据库返回到池中的连接进行测试，如果为true时必须设置validationQuery属性
     */
    private boolean testOnReturn;
    
    /**
     * 验证连接可用性的时间间隔
     */
    private long validationInterval;
    
    /**
     * 验证连接sql语句
     */
    private String validationQuery;
    
    /**
     * 设置多长时间进行空闲连接
     */
    private int timeBetweenEvictionRunsMillis;
    
    /**
     * 同一时间池中的最大活动数
     */
    private int maxActive;
    
    /**
     * 连接池创建时的初如数量
     */
    private int initialSize;
    
    /**
     * 连接池最长等待时间 如果在此时间内仍没有链接刚抛出异常
     */
    private int maxWait;
    
    /**
     * 是否自动清除废弃链接
     */
    private boolean removeAbandoned;
    
    /**
     * 查询最长超时时间
     */
    private int removeAbandonedTimeout;
    
    /**
     * 空闲链接的最小占用时间
     */
    private int minEvictableIdleTimeMillis;
    
    /**
     * 最小连接数
     */
    private int minIdle;
    
    /**
     * 是否记录废弃链接日志
     */
    private boolean logAbandoned;
    
    /**
     * @return 数据库连接驱动类
     */
    public String getDriverClassName() {
        return this.driverClassName;
    }
    
    /**
     * @param driverClassName 数据库连接驱动类
     */
    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
    
    /**
     * @return 数据库连接URL
     */
    public String getUrl() {
        return url;
    }
    
    /**
     * @param url 数据库连接URL
     */
    public void setUrl(String url) {
        this.url = url;
    }
    
    /**
     * @return 数据库登录用户名
     */
    public String getUsername() {
        return this.username;
    }
    
    /**
     * @param username 数据库登录用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * @return 数据库登录密码
     */
    public String getPassword() {
        return this.password;
    }
    
    /**
     * @param password 数据库登录密码
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * @return 注册连接池是否使用jmx
     */
    public boolean isJmxEnabled() {
        return this.jmxEnabled;
    }
    
    /**
     * @param jmxEnabled 注册连接池是否使用jmx
     */
    public void setJmxEnabled(boolean jmxEnabled) {
        this.jmxEnabled = jmxEnabled;
    }
    
    /**
     * @return 空闲时是否验证连接，（如果验证不通过则移除连接）为true时必须设置validationQuery属性
     */
    public boolean isTestWhileIdle() {
        return this.testWhileIdle;
    }
    
    /**
     * @param testWhileIdle 空闲时是否验证连接，（如果验证不通过则移除连接）为true时必须设置validationQuery属性
     */
    public void setTestWhileIdle(boolean testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }
    
    /**
     * @return 对象再用连接连数据库之前是否验证连接可用性，为true时必须设置validationQuery属性
     */
    public boolean isTestOnBorrow() {
        return this.testOnBorrow;
    }
    
    /**
     * @param testOnBorrow 对象再用连接连数据库之前是否验证连接可用性，为true时必须设置validationQuery属性
     */
    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }
    
    /**
     * @return 是否对数据库返回到池中的连接进行测试，如果为true时必须设置validationQuery属性
     */
    public boolean isTestOnReturn() {
        return this.testOnReturn;
    }
    
    /**
     * @param testOnReturn 是否对数据库返回到池中的连接进行测试，如果为true时必须设置validationQuery属性
     */
    public void setTestOnReturn(boolean testOnReturn) {
        this.testOnReturn = testOnReturn;
    }
    
    /**
     * @return 验证连接可用性的时间间隔
     */
    public long getValidationInterval() {
        return this.validationInterval;
    }
    
    /**
     * @param validationInterval 验证连接可用性的时间间隔
     */
    public void setValidationInterval(long validationInterval) {
        this.validationInterval = validationInterval;
    }
    
    /**
     * @return 验证连接sql语句
     */
    public String getValidationQuery() {
        return this.validationQuery;
    }
    
    /**
     * @param validationQuery 验证连接sql语句
     */
    public void setValidationQuery(String validationQuery) {
        this.validationQuery = validationQuery;
    }
    
    /**
     * @return 设置多长时间进行空闲连接
     */
    public int getTimeBetweenEvictionRunsMillis() {
        return this.timeBetweenEvictionRunsMillis;
    }
    
    /**
     * @param timeBetweenEvictionRunsMillis 设置多长时间进行空闲连接
     */
    public void setTimeBetweenEvictionRunsMillis(int timeBetweenEvictionRunsMillis) {
        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
    }
    
    /**
     * @return 同一时间池中的最大活动数
     */
    public int getMaxActive() {
        return this.maxActive;
    }
    
    /**
     * @param maxActive 同一时间池中的最大活动数
     */
    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }
    
    /**
     * @return 连接池创建时的初如数量
     */
    public int getInitialSize() {
        return this.initialSize;
    }
    
    /**
     * @param initialSize 连接池创建时的初如数量
     */
    public void setInitialSize(int initialSize) {
        this.initialSize = initialSize;
    }
    
    /**
     * @return 连接池最长等待时间 如果在此时间内仍没有链接刚抛出异常
     */
    public int getMaxWait() {
        return this.maxWait;
    }
    
    /**
     * @param maxWait 连接池最长等待时间 如果在此时间内仍没有链接刚抛出异常
     */
    public void setMaxWait(int maxWait) {
        this.maxWait = maxWait;
    }
    
    /**
     * @return 是否自动清除废弃链接
     */
    public boolean isRemoveAbandoned() {
        return this.removeAbandoned;
    }
    
    /**
     * @param removeAbandoned 是否自动清除废弃链接
     */
    public void setRemoveAbandoned(boolean removeAbandoned) {
        this.removeAbandoned = removeAbandoned;
    }
    
    /**
     * @return 查询最长超时时间
     */
    public int getRemoveAbandonedTimeout() {
        return this.removeAbandonedTimeout;
    }
    
    /**
     * @param removeAbandonedTimeout 查询最长超时时间
     */
    public void setRemoveAbandonedTimeout(int removeAbandonedTimeout) {
        this.removeAbandonedTimeout = removeAbandonedTimeout;
    }
    
    /**
     * @return 空闲链接的最小占用时间
     */
    public int getMinEvictableIdleTimeMillis() {
        return this.minEvictableIdleTimeMillis;
    }
    
    /**
     * @param minEvictableIdleTimeMillis 空闲链接的最小占用时间
     */
    public void setMinEvictableIdleTimeMillis(int minEvictableIdleTimeMillis) {
        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
    }
    
    /**
     * @return 最小连接数
     */
    public int getMinIdle() {
        return this.minIdle;
    }
    
    /**
     * @param minIdle 最小连接数
     */
    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }
    
    /**
     * @return 是否记录废弃链接日志
     */
    public boolean isLogAbandoned() {
        return this.logAbandoned;
    }
    
    /**
     * @param logAbandoned 是否记录废弃链接日志
     */
    public void setLogAbandoned(boolean logAbandoned) {
        this.logAbandoned = logAbandoned;
    }
    
}
