package com.hyou.codemaker.handler;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.velocity.VelocityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.hyou.codemaker.bean.info.DbInfoOper;
import com.hyou.codemaker.bean.objdef.FieldCfg;
import com.hyou.codemaker.common.consts.ConstCommon;
import com.hyou.codemaker.common.consts.ConstTemplate;
import com.hyou.codemaker.common.velocity.BaseMerge;
import com.hyou.codemaker.common.writer.WriterMaker;
import com.hyou.codemaker.config.ConfigBaseProp;
import com.hyou.codemaker.config.ConfigMapperProp;
import com.hyou.codemaker.util.RegUtil;

/**
 * Mapper文件代码生成类入口
 * 
 * @author Changshuo.Feng
 * @version 1.0.0 2014年8月3日 上午1:03:54
 */
@Component("mapperMaker")
public class MapperMaker extends BaseMerge {

    private static final Logger log = LoggerFactory.getLogger(MapperMaker.class);
    
    @Resource(name = "configMapperProp")
    private ConfigMapperProp configMapperProp;
    
    @Resource(name = "mySQLDbInfoOper")
    private DbInfoOper infoOper;

    @Resource(name = "configBaseProp")
    private ConfigBaseProp configBaseProp;
    
    /**
     * 内容生成器
     */
    @Resource(name = "mapperFileWriterMaker")
    private WriterMaker writerMaker;
    
    @Override
    public void velocityMerge() {
        // 获取数据对象
        List<FieldCfg> fieldCfgLst = infoOper.getFieldCfgList();
        if(CollectionUtils.isEmpty(fieldCfgLst)) {
            log.info("infoOper.getFieldsList result is null or size is 0");
            return;
        }
        for(FieldCfg cs : fieldCfgLst){
            if(cs.getDatabaseType().equals("VARCHAR2")){
                cs.setDatabaseType("VARCHAR");
            }
        }
        
        // 将数据对象结合模板引擎，将最终内容打印到终端或生成到指定文件
        velocityMerge(fieldCfgLst);
    }
    
    /**
     * <pre>
     * 版本修改历史记录：
     * 1) 1.3.0 2017-10-19 14:12:35 FengChangshuo Bean类名添加“DO”后缀
     * </pre>
     */
    private void velocityMerge(List<FieldCfg> fieldCfgLst) {
        
        String packageName = getConfigBaseProp().getPojoPackage();
        String tableName = getConfigBeanProp().getTableName();
        String className = RegUtil.tableToClassName(tableName);
        
        boolean useDao = configMapperProp.isUseDao();
        String namespacePrefix = configMapperProp.getNamespacePrefix();
        String namespace = namespacePrefix + ConstCommon.DOT_STR + className;
        
        if (useDao) {
            namespace = namespace + "Dao";
        } else {
            namespace = namespace + "Mapper";
        }
        
        /*
         * Make a context object and populate with the data. This is where
         * the Velocity engine gets the data to resolve the references (ex.
         * $list) in the templatem
         */
        VelocityContext context = new VelocityContext();
        context.put("fieldCfgLst", fieldCfgLst);
        context.put("namespace", namespace);
        context.put("packageName", packageName);
        context.put("tableName", tableName);
        context.put("className", className + "DO");
        String vm = ConstTemplate.MAPPER_VM;
        if("oracle".equalsIgnoreCase(configBaseProp.getDataBaseType())){
            vm = ConstTemplate.MAPPER_VM_ORACLE;
        }
        velocityMerge(context, writerMaker, vm);
    }
    
}
