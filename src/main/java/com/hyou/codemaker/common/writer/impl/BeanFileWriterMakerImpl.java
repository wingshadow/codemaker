package com.hyou.codemaker.common.writer.impl;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.hyou.codemaker.common.consts.ConstCommon;
import com.hyou.codemaker.common.writer.AbstractFileWriterMaker;
import com.hyou.codemaker.util.RegUtil;

/**
 * Bean代码文件生成的路径获取
 * 
 * @author Changshuo.Feng
 * @version 1.0.0 2014年8月3日 上午1:47:17
 */
@Component("beanFileWriterMaker")
public class BeanFileWriterMakerImpl extends AbstractFileWriterMaker {

    private static final Logger log = LoggerFactory.getLogger(BeanFileWriterMakerImpl.class);
    
    /**
     * <pre>
     * 版本修改历史记录：
     * 1) 1.3.0 2017-10-19 13:45:50 FengChangshuo 文件名添加“DO”标识
     * </pre>
     */
    @Override
    public String getOutputFilePath() {
        
        String destDir = getConfigBaseProp().getDestDir();
        String className = RegUtil.tableToClassName(getConfigBeanProp().getTableName());
        String fileName = className + "DO" + ConstCommon.JAVA_FILE;
        log.debug("destDir=[{}] className=[{}] fileName=[{}]", destDir, className, fileName);
        
        File destDirFile = new File(destDir);
        if(!destDirFile.exists()) {
            destDirFile.mkdirs();
        }
        
        String filePath = destDir + File.separator + fileName;
        log.debug("filePath=[{}]", filePath);
        
        return filePath;
    }

}
