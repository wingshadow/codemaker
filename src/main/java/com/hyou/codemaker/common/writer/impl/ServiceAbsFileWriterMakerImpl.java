package com.hyou.codemaker.common.writer.impl;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.hyou.codemaker.common.consts.ConstCommon;
import com.hyou.codemaker.common.writer.AbstractFileWriterMaker;
import com.hyou.codemaker.util.RegUtil;

/**
 * 生成Abstract Service类，该类实现Service接口，并生成通用的基本的增删改查的方法。
 * 
 * @author FengChangshuo
 * @version 1.3.2 2017年12月8日 下午3:21:59 created
 */
@Component("serviceAbsFileWriterMaker")
public class ServiceAbsFileWriterMakerImpl extends AbstractFileWriterMaker {
    
    private static final Logger log = LoggerFactory.getLogger(ServiceAbsFileWriterMakerImpl.class);
    
    @Override
    public String getOutputFilePath() {
        String destDir = getConfigBaseProp().getDestDir();
        
        String beanClassName = RegUtil.tableToClassName(getConfigBeanProp().getTableName());
        String serviceClassName = "Abstract" + beanClassName + "Service";
        String destFileName = serviceClassName + ConstCommon.JAVA_FILE;
        log.debug("destFileName=[{}]", destFileName);
        
        File destDirFile = new File(destDir);
        if (!destDirFile.exists()) {
            destDirFile.mkdirs();
        }
        
        String filePath = destDir + File.separator + destFileName;
        log.debug("filePath=[{}]", filePath);
        
        return filePath;
    }
    
}
