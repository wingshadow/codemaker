package com.hyou.codemaker.bean.info;

import java.util.List;

import com.hyou.codemaker.bean.objdef.FieldCfg;

/**
 * 数据信息获取操作（从数据库或配置文件里获取各类属性的定义，并进行数据的封装）
 * 
 * @author Changshuo.Feng
 * @version 1.0.0 2014年8月2日 下午12:32:26
 */
public interface DbInfoOper {

    List<FieldCfg> getFieldCfgList();
    
}
