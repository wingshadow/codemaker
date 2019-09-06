package com.hyou.codemaker.bean.field;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.hyou.codemaker.bean.info.DbInfoOper;
import com.hyou.codemaker.bean.objdef.FieldCfg;
import com.hyou.codemaker.bean.objdef.FieldDef;
import com.hyou.codemaker.util.MethodUtil;

/**
 * 类属性对象封装构造实现
 * @author Changshuo.Feng
 * @version 1.0.0 2014年8月2日 下午12:24:30
 */
@Component("defaultFieldsMaker")
public class DefaultFieldsMakerImpl implements FieldsMaker {

    private static final Logger log = LoggerFactory.getLogger(DefaultFieldsMakerImpl.class);

    @Resource(name = "mySQLDbInfoOper")
    private DbInfoOper infoOper;

    @Override
    public List<FieldDef> getFieldsList() {

        // 从配置或者数据库中获取Bean的各属性信息集合
        List<FieldCfg> fieldCfgLst = infoOper.getFieldCfgList();

        if(CollectionUtils.isEmpty(fieldCfgLst)) {
            log.info("infoOper.getFieldCfgList is empty");
            return null;
        }

        FieldDef item;
        List<FieldDef> fieldDefLst = new ArrayList<>();
        for(FieldCfg fieldCfg : fieldCfgLst) {
            item = new FieldDef();
            item.setName(fieldCfg.getName());
            item.setType(fieldCfg.getJavaType());
            item.setComment(fieldCfg.getComment());
            item.setGetter(MethodUtil.makeGetterMethodName(fieldCfg.getName(), fieldCfg.getJavaType()));
            item.setSetter(MethodUtil.makeSetterMethodName(fieldCfg.getName()));
            fieldDefLst.add(item);
        }

        return fieldDefLst;
    }

}
