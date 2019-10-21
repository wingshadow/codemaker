package com.hyou.codemaker.handler;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.velocity.VelocityContext;
import org.springframework.stereotype.Component;

import com.hyou.codemaker.common.consts.ConstTemplate;
import com.hyou.codemaker.common.velocity.BaseMerge;
import com.hyou.codemaker.common.writer.WriterMaker;
import com.hyou.codemaker.util.RegUtil;

@Component("daoMaker")
public class DaoMaker extends BaseMerge {

    /**
     * 内容生成器
     */
    @Resource(name = "daoFileWriterMaker")
    private WriterMaker writerMaker;
    
    /**
     * <pre>
     * 根据模板生成代码
     * 
     * 版本修改历史记录：
     * 1) 1.3.0 2017-10-19 14:11:47 FengChangshuo Bean类名添加“DO”后缀
     * </pre>
     */
    @Override
    public void velocityMerge(String vmTemplate) {
        
        String daoPackageName = getConfigBaseProp().getDaoPackage();
        String beanPackageName = getConfigBaseProp().getPojoPackage();
        String tableName = getConfigBeanProp().getTableName();
        String beanClassName = RegUtil.tableToClassName(tableName);
        String daoClassName = beanClassName + "Dao";
        String daoIocName = daoClassName.substring(0,1).toLowerCase() + daoClassName.substring(1);
        String beanParamName = beanClassName.substring(0,1).toLowerCase() + beanClassName.substring(1);
        
        String createDate = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        String author = getConfigBaseProp().getAuthor();
        String version = getConfigBaseProp().getVersion();
        
        /*
         * Make a context object and populate with the data. This is where
         * the Velocity engine gets the data to resolve the references (ex.
         * $list) in the template
         */
        VelocityContext context = new VelocityContext();
        context.put("daoPackageName", daoPackageName);
        context.put("beanPackageName", beanPackageName);
        context.put("createDate", createDate);
        context.put("daoIocName", daoIocName);
        context.put("daoClassName", daoClassName);
        context.put("beanClass", beanClassName);
        context.put("beanParamName", beanParamName);
        context.put("tableName", tableName);
        context.put("author", author);
        context.put("version", version);
        
        velocityMerge(context, writerMaker, vmTemplate);
    }

}
