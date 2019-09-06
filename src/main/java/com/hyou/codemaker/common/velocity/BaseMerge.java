package com.hyou.codemaker.common.velocity;

import java.io.BufferedWriter;
import java.io.IOException;

import javax.annotation.Resource;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hyou.codemaker.common.consts.ConstTemplate;
import com.hyou.codemaker.common.writer.WriterMaker;
import com.hyou.codemaker.config.ConfigBaseProp;
import com.hyou.codemaker.config.ConfigBeanProp;

public abstract class BaseMerge {
    
    private static final Logger log = LoggerFactory.getLogger(BaseMerge.class);
    
    @Resource(name = "configBeanProp")
    private ConfigBeanProp configBeanProp;
    
    @Resource(name = "configBaseProp")
    private ConfigBaseProp configBaseProp;
    
    public void velocityMerge(VelocityContext context, WriterMaker writerMaker, String vmFile) {
        
        BufferedWriter writer = null;
        
        try {

            /*
             * setup
             */
            Velocity.init();

            /*
             * get the Template object. This is the parsed version of your
             * template input file. Note that getTemplate() can throw
             * ResourceNotFoundException : if it doesn't find the template
             * ParseErrorException : if there is something wrong with the VTL
             * Exception : if something else goes wrong (this is generally
             * indicative of as serious problem...)
             */
            Template template = null;

            try {
                template = Velocity.getTemplate(vmFile, ConstTemplate.CODE_UTF8);
            } catch (ResourceNotFoundException rnfe) {
                log.error("Example : error : cannot find template " + vmFile, rnfe);
            } catch (ParseErrorException pee) {
                log.error("Example : Syntax error in template " + vmFile, pee);
            }

            /*
             * Now have the template engine process your template using the data
             * placed into the context. Think of it as a 'merge' of the template
             * and the data to produce the output stream.
             */
            writer = writerMaker.getWriter();

            if (template != null) {
                template.merge(context, writer);
            }

            /*
             * flush and cleanup
             */
            writer.flush();
            
        } catch (Exception e) {
            log.error("exception e:", e);
        } finally {
            if(writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
    }
    
    public abstract void velocityMerge();

    public ConfigBeanProp getConfigBeanProp() {
        return this.configBeanProp;
    }

    public ConfigBaseProp getConfigBaseProp() {
        return this.configBaseProp;
    }

}
