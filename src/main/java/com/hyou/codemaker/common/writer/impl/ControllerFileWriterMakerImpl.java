package com.hyou.codemaker.common.writer.impl;

import com.hyou.codemaker.common.consts.ConstCommon;
import com.hyou.codemaker.common.writer.AbstractFileWriterMaker;
import com.hyou.codemaker.util.RegUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * 生成Service实现类代码文件使用
 * @author Changshuo.Feng
 * @version 1.0.0 2014年8月18日 下午4:01:48
 */
@Slf4j
@Getter
@Setter
@Component("controllerFileWriterMaker")
public class ControllerFileWriterMakerImpl extends AbstractFileWriterMaker {

    private String name;

    @Override
    public String getOutputFilePath() {
        String destDir = getConfigBaseProp().getDestDir();
        String beanClassName = RegUtil.tableToClassName(getConfigBeanProp().getTableName());
        String destFileName = beanClassName + "Controller" + ConstCommon.JAVA_FILE;
        if(StringUtils.isNotBlank(name)){
            destFileName = name + ConstCommon.JAVA_FILE;
        }
        File destDirFile = new File(destDir);
        if(!destDirFile.exists()) {
            destDirFile.mkdirs();
        }
        
        String filePath = destDir + File.separator + destFileName;
        log.debug("filePath=[{}]", filePath);
        
        return filePath;
    }

}
