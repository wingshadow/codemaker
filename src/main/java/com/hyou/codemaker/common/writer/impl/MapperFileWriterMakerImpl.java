package com.hyou.codemaker.common.writer.impl;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.hyou.codemaker.common.consts.ConstCommon;
import com.hyou.codemaker.common.writer.AbstractFileWriterMaker;
import com.hyou.codemaker.util.RegUtil;

/**
 * Mapper代码文件生成的路径获取
 * 
 * @author Changshuo.Feng
 * @version 1.0.0 2014年8月3日 上午1:47:17
 */
@Component("mapperFileWriterMaker")
public class MapperFileWriterMakerImpl extends AbstractFileWriterMaker {

    private static final Logger log = LoggerFactory.getLogger(MapperFileWriterMakerImpl.class);
    
    @Override
    public String getOutputFilePath() {
        
        String className = RegUtil.tableToClassName(getConfigBeanProp().getTableName());
        String fileName = className + "Mapper" + ConstCommon.MAPPER_XML_FILE;
        log.debug("className=[{}] fileName=[{}]", className, fileName);
        
        String destDir = getConfigBaseProp().getDestDir();
        
        File destDirFile = new File(destDir);
        if(!destDirFile.exists()) {
            destDirFile.mkdirs();
        }
        
        String filePath = destDir + File.separator + fileName;
        log.debug("filePath=[{}]", filePath);
        
        return filePath;
    }

}
