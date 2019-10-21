package com.hyou.codemaker;

import com.hyou.codemaker.common.consts.ConstTemplate;
import com.hyou.codemaker.common.writer.impl.FormFileWriterMakerImpl;
import com.hyou.codemaker.config.ConfigBeanProp;
import com.hyou.codemaker.handler.*;
import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * 入口
 */
@SpringBootApplication(scanBasePackages = "com.hyou.codemaker")
public class Application {
    
    private static final Logger log = LoggerFactory.getLogger(Application.class);
    
    /**
     * @param args 如果args为空，则按默认的单表模式处理。
     *             如果args不为空，则按多表生成模式处理。其中该参数即为各个表名。
     */
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(new Object[]{Application.class});
        app.setWebEnvironment(false);
        ApplicationContext context = app.run(args);
        if (ArrayUtils.isEmpty(args)) {
            doVelocityMerge(context);
            return;
        }

        ConfigBeanProp configBeanProp = (ConfigBeanProp) context.getBean("configBeanProp", ConfigBeanProp.class);


        for (String tableName : args) {
            try {
                configBeanProp.setTableName(tableName);
                doVelocityMerge(context);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }

        }
    }
    
    /**
     * <pre>
     * 版本修改历史记录：
     * 1) 1.3.2 2017年12月8日 下午3:30:10 FengChangshuo 增加ServiceAbstractMaker的实现，生成Service抽象类
     * </pre>
     * 
     * @param context Spring上下文
     */
    private static void doVelocityMerge(ApplicationContext context) {

        BeanMaker beanMaker = context.getBean("beanMaker", BeanMaker.class);
        beanMaker.velocityMerge(ConstTemplate.BEAN_VM);

        MapperMaker mapperMaker = context.getBean("mapperMaker", MapperMaker.class);
        mapperMaker.velocityMerge(ConstTemplate.MAPPER_VM);

        ServiceInterfaceMaker serviceMaker = context.getBean("serviceInterfaceMaker", ServiceInterfaceMaker.class);
        serviceMaker.velocityMerge(ConstTemplate.SERVICE_INTERFACE_VM);

        ServiceImplMaker serviceImplMaker = context.getBean("serviceImplMaker", ServiceImplMaker.class);
        serviceImplMaker.velocityMerge(ConstTemplate.SERVICE_NO_DAO_IMPL_VM);

//        ServiceAbstractMaker serviceAbstractMaker = context.getBean("serviceAbstractMaker", ServiceAbstractMaker.class);
//        serviceAbstractMaker.velocityMerge();

        FormMaker formMaker = context.getBean("formMaker", FormMaker.class);
        FormFileWriterMakerImpl writerMaker = context.getBean(
                "formFileWriterMaker",FormFileWriterMakerImpl.class);
        writerMaker.setName("ListForm");
        formMaker.setWriterMaker(writerMaker);
        formMaker.velocityMerge(ConstTemplate.LIST_FORM_VM);


//        FormVueMaker formVueMaker = context.getBean("formVueMaker", FormVueMaker.class);
//        formVueMaker.velocityMerge();

//        IndexMaker indexMaker = context.getBean("indexMaker", IndexMaker.class);
//        indexMaker.velocityMerge();

        ControlllerMaker controllerMaker = context.getBean("controllerMaker", ControlllerMaker.class);
        controllerMaker.velocityMerge(ConstTemplate.CONTROLLER);
    }
    
}
