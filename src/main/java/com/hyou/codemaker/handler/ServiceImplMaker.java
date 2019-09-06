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
 * Service层接口实现类代码生成器
 * @author Changshuo.Feng
 * @version 1.0.0 2014年8月18日 下午4:42:03
 */
@Component("serviceImplMaker")
public class ServiceImplMaker extends BaseMerge {
    
    /**
     * 内容生成器
     */
    @Resource(name = "serviceImplFileWriterMaker")
    private WriterMaker writerMaker;
    
    /**
     * <pre>
     * 根据模板生成代码
     * 
     * 版本修改历史记录：
     * 1) 1.3.0 2017-10-19 14:14:36 FengChangshuo Bean类名添加“DO”后缀, 新增变量"serviceItfcPckageName"
     * </pre>
     */
    @Override
    public void velocityMerge() {
        
        String serviceItfcPckageName = getConfigBaseProp().getServiceItfcPackage();
        String serviceAbsPackageName = getConfigBaseProp().getServiceAbsPackage();
        String servicePackageName = getConfigBaseProp().getServiceImplPackage();
        String beanPackageName = getConfigBaseProp().getPojoPackage();
        String tableName = getConfigBeanProp().getTableName();
        String beanClassName = RegUtil.tableToClassName(tableName);
        String serviceInterfaceName = beanClassName + "Service";
        String serviceClassName = beanClassName + "ServiceImpl";
        String serviceAbsClassName = "Abstract" + serviceInterfaceName;
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
        context.put("servicePackageName", servicePackageName);
        context.put("beanPackageName", beanPackageName);
        context.put("beanClass", beanClassName + "DO");
        context.put("tableName", tableName);
        context.put("createDate", createDate);
        context.put("serviceInterfaceName", serviceInterfaceName);
        context.put("serviceClassName", serviceClassName);
        context.put("serviceAbsPackageName", serviceAbsPackageName);
        context.put("serviceAbsClassName", serviceAbsClassName);
        context.put("beanParamName", beanParamName);
        context.put("serviceIocName", serviceIocName);
        context.put("daoPackageName", daoPackageName);
        context.put("daoClassName", daoClassName);
        context.put("daoIocName", daoIocName);
        context.put("author", author);
        context.put("version", version);
        
        velocityMerge(context, writerMaker, ConstTemplate.SERVICE_IMPL_VM);
        
    }
    
}
