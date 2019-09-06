package com.hyou.codemaker.common.writer;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import javax.annotation.Resource;

import com.hyou.codemaker.config.ConfigBaseProp;
import com.hyou.codemaker.config.ConfigBeanProp;

/**
 * 将模板生成的内容输出到指定文件
 * 
 * @author Changshuo.Feng
 * @version 1.0.0 2014年8月3日 上午12:19:52
 */
public abstract class AbstractFileWriterMaker implements WriterMaker {
    
    @Resource(name = "configBaseProp")
    private ConfigBaseProp configBaseProp;
    
    @Resource(name = "configBeanProp")
    private ConfigBeanProp configBeanProp;
    
    public abstract String getOutputFilePath();
    
    /**
     * 获取BufferedWriter对象以用于输出内容到指定文件。
     * 文件以UTF-8格式编码
     */
    @Override
    public BufferedWriter getWriter() throws Exception {
        
        String filePath = getOutputFilePath();
        FileOutputStream fos = new FileOutputStream(filePath);
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        
        return new BufferedWriter(osw);
    }

    /**
     * @return the configBaseProp
     */
    public ConfigBaseProp getConfigBaseProp() {
        return this.configBaseProp;
    }

    /**
     * @return the configBeanProp
     */
    public ConfigBeanProp getConfigBeanProp() {
        return this.configBeanProp;
    }

}
