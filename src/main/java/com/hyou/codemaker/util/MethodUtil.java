package com.hyou.codemaker.util;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MethodUtil {
    
    private static final Logger log = LoggerFactory.getLogger(MethodUtil.class);

    /**
     * 生成Getter方法名
     * 
     * @param fieldName 属性名
     * @return Getter方法名
     */
    public static String makeGetterMethodName(String fieldName, String type) {
        if(StringUtils.isEmpty(fieldName)) {
            log.info("fieldName is null.");
            return null;
        }
        if(StringUtils.isEmpty(type)) {
            log.info("type is null");
            return null;
        }
        
        if (type.equalsIgnoreCase("boolean")) {
            return "is" + upperFirstChar(fieldName);
        }
        
        return "get" + upperFirstChar(fieldName);
    }
    
    /**
     * 生成setter方法名
     * @param fieldName 属性名
     * @return setter方法名
     */
    public static String makeSetterMethodName(String fieldName) {
        if(StringUtils.isEmpty(fieldName)) {
            log.info("fieldName is null.");
            return null;
        }
        
        return "set" + upperFirstChar(fieldName);
    }
    
    public static String upperFirstChar(String fieldName) {
        String first = fieldName.substring(0, 1);
        first = first.toUpperCase();
        
        return first + fieldName.substring(1);
    }
}
