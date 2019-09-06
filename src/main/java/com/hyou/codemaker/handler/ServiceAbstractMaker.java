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

/**
 * 生成abstract service的代码文件的实现
 * 
 * @author FengChangshuo
 * @version 1.3.2 2017年12月8日 下午3:23:57 created
 */
@Component("serviceAbstractMaker")
public class ServiceAbstractMaker extends BaseMerge {
    
    /**
     * 内容生成器
     */
    @Resource(name = "serviceAbsFileWriterMaker")
    private WriterMaker writerMaker;
    
    @Override
    public void velocityMerge() {
        
        String serviceItfcPckageName = getConfigBaseProp().getServiceItfcPackage();
        String serviceAbsPackageName = getConfigBaseProp().getServiceAbsPackage();
        String beanPackageName = getConfigBaseProp().getPojoPackage();
        String tableName = getConfigBeanProp().getTableName();
        String beanClassName = RegUtil.tableToClassName(tableName);
        String serviceInterfaceName = beanClassName + "Service";
        String serviceClassName = "Abstract" + beanClassName + "Service";
        String beanParamName = beanClassName.substring(0,1).toLowerCase() + beanClassName.substring(1);
        String serviceIocName = serviceInterfaceName.substring(0,1).toLowerCase() + serviceInterfaceName.substring(1);
        String daoPackageName = getConfigBaseProp().getDaoPackage();
        String daoClassName = beanClassName + "Dao";
        String daoIocName = daoClassName.substring(0,1).toLowerCase() + daoClassName.substring(1);
        
        String createDate = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        String author = getConfigBaseProp().getAuthor();
        String version = getConfigBaseProp().getVersion();
        
        /*
         * Make a context object and populate with the data. This is where
         * the Velocity engine gets the data to resolve the references (ex.
         * $list) in the template
         */
        VelocityContext context = new VelocityContext();
        context.put("serviceItfcPckageName", serviceItfcPckageName);
        context.put("serviceAbsPackageName", serviceAbsPackageName);
        context.put("beanPackageName", beanPackageName);
        context.put("beanClass", beanClassName + "DO");
        context.put("tableName", tableName);
        context.put("createDate", createDate);
        context.put("serviceInterfaceName", serviceInterfaceName);
        context.put("serviceClassName", serviceClassName);
        context.put("beanParamName", beanParamName);
        context.put("serviceIocName", serviceIocName);
        context.put("daoPackageName", daoPackageName);
        context.put("daoClassName", daoClassName);
        context.put("daoIocName", daoIocName);
        context.put("author", author);
        context.put("version", version);
        
        velocityMerge(context, writerMaker, ConstTemplate.SERVICE_ABSTRACT_VM);
    }
    
}
