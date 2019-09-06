package com.hyou.codemaker.common.bean;

import java.io.Serializable;

import com.hyou.codemaker.util.JsonUtil;

public class BaseBean implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -6297743583250907047L;

    @Override
    public String toString() {
        return JsonUtil.writeValueAsString(this);
    }
	
}
