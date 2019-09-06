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
 * Service层接口代码生成器
 * @author Changshuo.Feng
 * @version 1.0.0 2014年8月18日 下午4:42:03
 */
@Component("serviceInterfaceMaker")
public class ServiceInterfaceMaker extends BaseMerge {

    /**
     * 内容生成器
     */
    @Resource(name = "serviceFileWriterMaker")
    private WriterMaker writerMaker;
    
    /**
     *<pre>
     * 根据模板生成代码
     * 
     * 版本修改历史记录：
     * 1) 1.3.0 2017-10-19 14:14:36 FengChangshuo Bean类名添加“DO”后缀
     * </pre>
     */
    @Override
    public void velocityMerge() {
        
        String servicePackageName = getConfigBaseProp().getServiceItfcPackage();
        String beanPackageName = getConfigBaseProp().getPojoPackage();
        String beanClassName = RegUtil.tableToClassName(getConfigBeanProp().getTableName());
        String serviceInterfaceName = beanClassName + "Service";
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
        context.put("iServicePackageName", servicePackageName);
        context.put("beanPackageName", beanPackageName);
        context.put("beanClass", beanClassName + "DO");
        context.put("createDate", createDate);
        context.put("serviceInterfaceName", serviceInterfaceName);
        context.put("beanParamName", beanParamName);
        context.put("author", author);
        context.put("version", version);
        
        velocityMerge(context, writerMaker, ConstTemplate.SERVICE_INTERFACE_VM);
        
    }
    
}
