package com.hyou.codemaker.util;

/**
 * JSON序列化或反序列化处理时产生的异常
 * 
 * @author FengChangshuo
 * @version 1.0.0 2015年12月9日 下午3:22:09 created
 */
public class JsonException extends RuntimeException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -7353394480389439337L;
    
    public JsonException(String message, Throwable e) {
        super(message, e);
    }
    
}
