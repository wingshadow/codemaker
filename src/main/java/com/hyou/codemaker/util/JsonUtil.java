package com.hyou.codemaker.util;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JSON处理工具类
 * 
 * @author Changshuo.Feng
 * @version 2.0.0 2015年1月12日 上午11:00:27 初始创建
 */
public abstract class JsonUtil {
    
    /**
     * log
     */
    private static final Logger log = LoggerFactory.getLogger(JsonUtil.class);
    
    /**
     * Jackson进行JSON处理的类
     */
    private static ObjectMapper objectMapper = null;
    
    static {
        objectMapper = new ObjectMapper();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        objectMapper.setDateFormat(sdf);
    }
    
    /**
     * <pre>
     * 将目标对象序列化成String形式
     * 
     * 版本修改历史记录：
     * 1) 2.0.0 2015年1月12日 上午11:03:20 Changshuo.Feng 初始创建
     * </pre>
     * 
     * @param value 要序列化的对象
     * @return 序列化后的字符串
     * @throws JsonException JSON序列化异常
     */
    public static String writeValueAsString(Object value) throws JsonException {
        try {
            return objectMapper.writeValueAsString(value);
        } catch(IOException e) {
            log.error(e.getMessage(), e);
            throw new JsonException("JOSN writeValueAsString exception", e);
        }
    }
    
    /**
     * <pre>
     * 将目标对象序列化成byte数组形式
     * 
     * 版本修改历史记录：
     * 1) 2.0.0 2015年1月12日 上午11:16:39 Changshuo.Feng 初始创建
     * </pre>
     * 
     * @param value 要序列化的对象
     * @return 序列化后的字节数组
     * @throws JsonException JSON序列化异常
     */
    public static byte[] writeValueAsBytes(Object value) throws JsonException {
        try {
            return objectMapper.writeValueAsBytes(value);
        } catch(IOException e) {
            log.error(e.getMessage(), e);
            throw new JsonException("JOSN writeValueAsBytes exception", e);
        }
    }
    
    /**
     * <pre>
     * JSON字符串反序列化
     * 
     * 版本修改历史记录：
     * 1) 2.0.0 2015年1月12日 上午11:48:09 Changshuo.Feng 初始创建
     * </pre>
     * 
     * @param <T> 反序列化后的对象类型
     * @param content JSON字符串
     * @param valueType 反序列化的目标类型
     * @return 反序列化的值
     * @throws JsonException JSON反序列化异常
     */
    public static <T> T readValue(String content, Class<T> valueType) throws JsonException {
        try {
            return objectMapper.readValue(content, valueType);
        } catch(IOException e) {
            log.error(e.getMessage(), e);
            throw new JsonException("JOSN readValue exception", e);
        }
    }
    
    /**
     * <pre>
     * JSON字符串反序列化
     * 
     * 版本修改历史记录：
     * 1) 2.0.0 2015年1月12日 上午11:48:09 Changshuo.Feng 初始创建
     * </pre>
     * 
     * @param <T> 反序列化后的对象类型
     * @param content JSON字符串
     * @param valueTypeRef 反序列化的目标类型
     * @return 反序列化的值
     * @throws JsonException JSON反序列化异常
     */
    public static <T> T readValue(String content, TypeReference<T> valueTypeRef) throws JsonException {
        try {
            return objectMapper.readValue(content, valueTypeRef);
        } catch(IOException e) {
            log.error(e.getMessage(), e);
            throw new JsonException("JOSN readValue exception", e);
        }
    }
    
    /**
     * <pre>
     * JSON字符串反序列化
     * 
     * 版本修改历史记录：
     * 1) 2.0.0 2015年1月12日 上午11:48:09 Changshuo.Feng 初始创建
     * </pre>
     * 
     * @param <T> 反序列化后的对象类型
     * @param content JSON字符串
     * @param valueType 反序列化的目标类型
     * @return 反序列化的值
     * @throws JsonException JSON反序列化异常
     */
    public static <T> T readValue(String content, JavaType valueType) throws JsonException {
        try {
            return objectMapper.readValue(content, valueType);
        } catch(IOException e) {
            log.error(e.getMessage(), e);
            throw new JsonException("JOSN readValue exception", e);
        }
    }
    
    /**
     * <pre>
     * 获取JSON格式的字符串的结点解析对象，用于手动解析结构相对复杂或者无规律的JSON对象
     * 
     * 版本修改历史记录：
     * 1) 2.0.0 2016年4月21日 下午2:28:02 FengChangshuo created
     * </pre>
     * 
     * @param content
     * @return
     */
    public static JsonNode readTree(String content) {
        try {
            return objectMapper.readTree(content);
        } catch(IOException e) {
            log.error(e.getMessage(), e);
            throw new JsonException("JOSN readTree exception", e);
        }
    }
    
}
