package com.hyou.codemaker.handler;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.velocity.VelocityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.hyou.codemaker.bean.field.FieldsMaker;
import com.hyou.codemaker.bean.objdef.FieldDef;
import com.hyou.codemaker.common.consts.ConstTemplate;
import com.hyou.codemaker.common.velocity.BaseMerge;
import com.hyou.codemaker.common.writer.WriterMaker;
import com.hyou.codemaker.util.RegUtil;

/**
 * Bean代码生成主入口类
 * 
 * @author Changshuo.Feng
 * @version 1.0.0 2014年8月2日 上午11:17:10
 */
@Component("beanMaker")
public class BeanMaker extends BaseMerge {
    
    private static final Logger log = LoggerFactory.getLogger(BeanMaker.class);
    
    /**
     * 类属性对象集合生成接口
     */
    @Resource(name = "defaultFieldsMaker")
    private FieldsMaker fieldsMaker;
    
    /**
     * 内容生成器
     */
    @Resource(name = "beanFileWriterMaker")
    private WriterMaker writerMaker;
    
    @Override
    public void velocityMerge(String vmTemplate) {
        
        // 获取数据对象
        List<FieldDef> rs = fieldsMaker.getFieldsList();
        if(CollectionUtils.isEmpty(rs)) {
            log.info("fieldsMaker.getFieldsList result is empty");
            return;
        }
        
        // 将数据对象结合模板引擎，将最终内容打印到终端或生成到指定文件
        velocityMerge(rs,vmTemplate);
    }
    
    /**
     * <pre>
     * 版本修改历史记录：
     * 1) 1.3.0 2017-10-19 14:03:50 FengChangshuo 文件名添加“DO”标识
     * </pre>
     */
    private void velocityMerge(List<FieldDef> fieldDefLst,String vmTemplate) {
        
        String packageName = getConfigBaseProp().getPojoPackage();
        String basePackage = getConfigBaseProp().getBasePackage();
        String tableName = getConfigBeanProp().getTableName();
        String className = RegUtil.tableToClassName(tableName);
        
        String createDate = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        String author = getConfigBaseProp().getAuthor();
        String version = getConfigBaseProp().getVersion();
        
        /*
         * Make a context object and populate with the data. This is where
         * the Velocity engine gets the data to resolve the references (ex.
         * $list) in the template
         */
        VelocityContext context = new VelocityContext();
        context.put("fieldList", fieldDefLst);
        context.put("basePackage", basePackage);
        context.put("packageName", packageName);
        context.put("className", className);
        context.put("createDate", createDate);
        context.put("tableName", tableName);
        context.put("author", author);
        context.put("version", version);


        velocityMerge(context, writerMaker, vmTemplate);
    }
    
}
