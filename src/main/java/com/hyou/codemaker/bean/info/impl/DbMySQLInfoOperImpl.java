package com.hyou.codemaker.bean.info.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.hyou.codemaker.bean.info.DbInfoOper;
import com.hyou.codemaker.bean.objdef.FieldCfg;
import com.hyou.codemaker.common.consts.ConstDataBase;
import com.hyou.codemaker.common.consts.ConstDataType;
import com.hyou.codemaker.config.ConfigBaseProp;
import com.hyou.codemaker.config.ConfigBeanProp;
import com.hyou.codemaker.db.dao.ColumnDao;
import com.hyou.codemaker.db.pojo.ParamColumnsBean;
import com.hyou.codemaker.db.pojo.ResultColumnsBean;
import com.hyou.codemaker.util.RegUtil;

/**
 * 从数据库中获取数据库表信息
 *
 * @author Changshuo.Feng
 * @version 1.3.1 2017-10-31 10:40:18 添加对Double数据类型的支持
 */
@Component("mySQLDbInfoOper")
public class DbMySQLInfoOperImpl implements DbInfoOper {

    private static final Logger log = LoggerFactory.getLogger(DbMySQLInfoOperImpl.class);

    @Resource(name = "configBaseProp")
    private ConfigBaseProp configBaseProp;

    @Resource(name = "configBeanProp")
    private ConfigBeanProp configBeanProp;

    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 通过数据库查询的方式获取指定表的配置
     */
    @Override
    public List<FieldCfg> getFieldCfgList() {

        String dataBaseType = configBaseProp.getDataBaseType();

        //查询表的列信息
        List<ResultColumnsBean> rsLst = getTableColumnInfos();
        if (CollectionUtils.isEmpty(rsLst)) {
            log.info("getTableColumnInfos 查询结果为空");
            return null;
        }

        List<FieldCfg> fieldCfgLst = new ArrayList<FieldCfg>();

        String columnName;
        String fieldName;
        String columnType;
        String dataType;
        String javaType;
        String jdbcType;
        FieldCfg fieldCfg;

        for (ResultColumnsBean resultColumnBean : rsLst) {
            log.debug("resultColumnBean=[{}]", resultColumnBean);

            fieldCfg = new FieldCfg();

            columnName = resultColumnBean.getColumnName();
            fieldCfg.setColumnName(columnName);

            fieldName = RegUtil.columnToFieldName(columnName);
            fieldCfg.setName(fieldName);

            columnType = resultColumnBean.getColumnType();
            dataType = resultColumnBean.getDataType();
            //数据库类型转换为java类型
            javaType = transToJavaDataBase(resultColumnBean, dataBaseType);
            fieldCfg.setJavaType(javaType);

            //数据库类型转换为jdbc类型
            jdbcType = transToMybatisDataType(resultColumnBean, dataBaseType);
            fieldCfg.setDatabaseType(jdbcType);

            fieldCfg.setComment(resultColumnBean.getColumnComment());

            fieldCfgLst.add(fieldCfg);
        }

        return fieldCfgLst;
    }

    /**
     * @return 从数据库查询指定表的表结构，每个字段的基本信息封装到ResultColumnsBean中
     */
    private List<ResultColumnsBean> getTableColumnInfos() {
        ColumnDao columnDao = sqlSessionTemplate.getMapper(ColumnDao.class);

        String schema = configBaseProp.getSchameName();
        String table = configBeanProp.getTableName();

        ParamColumnsBean paramBean = new ParamColumnsBean();
        paramBean.setTableSchema(schema);
        paramBean.setTableName(table);

        log.debug("ParamColumnsBean=[{}]", paramBean);
        if(configBaseProp.getDataBaseType().equals("mysql")){
            return columnDao.selectMysqlTableInfo(paramBean);
        }
        return columnDao.selectOracleTableInfo(paramBean);
    }

    private String transToMybatisDataType(ResultColumnsBean resultColumnsBean, String dataBaseType) {
        String dataType = resultColumnsBean.getDataType();
        if (StringUtils.equals(dataBaseType, ConstDataBase.DATABASE_MYSQL)) {
            if (ConstDataType.MYSQL_INT.equalsIgnoreCase(dataType)) {
                dataType = ConstDataType.MYBATIS_JDBC_INT;
            } else if (ConstDataType.MYSQL_DATETIME.equalsIgnoreCase(dataType)) {
                dataType = ConstDataType.MYBATIS_JDBC_TIMESTAMP;
            }
        } else if (StringUtils.equals(dataBaseType, ConstDataBase.DATABASE_ORACLE)) {
            if (ConstDataType.ORACLE_NUMBER.equalsIgnoreCase(dataType)) {
                int length = resultColumnsBean.getDataPrecision();
                int scale = resultColumnsBean.getDataScale();
                if (scale == 0) {
                    if (length >= 10) {
                        dataType = ConstDataType.MYBATIS_JDBC_BIGINT;
                    } else {
                        dataType = ConstDataType.MYBATIS_JDBC_INT;
                    }
                } else {
                    dataType = ConstDataType.MYBATIS_JDBC_DOUBLE;
                }
            } else if (ConstDataType.ORACLE_VARCHAR.equals(dataType)) {
                dataType = ConstDataType.MYBATIS_JDBC_VARCHAR;
            } else if (ConstDataType.ORACLE_DATE.equals(dataType)) {
                dataType = ConstDataType.MYBATIS_JDBC_TIMESTAMP;
            } else if(ConstDataType.ORACLE_CHAR.equals(dataType)){
                dataType = ConstDataType.MYBATIS_JDBC_CHAR;
            }

        }
        return dataType.toUpperCase();
    }

    private String transToJavaDataBase(ResultColumnsBean resultColumnsBean, String dataBaseType) {

        String dataType = resultColumnsBean.getDataType();
        String columnType = resultColumnsBean.getColumnType();
        if (dataBaseType.equals(ConstDataBase.DATABASE_ORACLE)) {
            if (ConstDataType.ORACLE_CHAR.equalsIgnoreCase(dataType)) {
                return ConstDataType.JAVA_STRING;
            } else if (ConstDataType.ORACLE_VARCHAR.equalsIgnoreCase(dataType)) {
                return ConstDataType.JAVA_STRING;
            } else if (ConstDataType.ORACLE_DATE.equalsIgnoreCase(dataType)) {
                return ConstDataType.JAVA_DATE;
            } else if (ConstDataType.ORACLE_NUMBER.equalsIgnoreCase(dataType)) {
                int length = resultColumnsBean.getDataPrecision();
                int scale = resultColumnsBean.getDataScale();
                if (scale == 0) {
                    if (length >= 10) {
                        return ConstDataType.JAVA_LONG;
                    } else {
                        return ConstDataType.JAVA_INTEGER;
                    }
                } else {
                    return ConstDataType.JAVA_DOUBLE;
                }
            } else if (ConstDataType.ORACLE_TIMESTAMP.equalsIgnoreCase(dataType)) {
                return ConstDataType.JAVA_DATE;
            }
        } else {
            if (ConstDataType.MYSQL_VARCHAR.equalsIgnoreCase(dataType)) {
                // varchar -> String
                return ConstDataType.JAVA_STRING;

            } else if (ConstDataType.MYSQL_CHAR.equalsIgnoreCase(dataType)) {
                // char -> String
                return ConstDataType.JAVA_STRING;

            } else if (ConstDataType.MYSQL_INT.equalsIgnoreCase(dataType)) {
                // int -> int
                return ConstDataType.JAVA_INTEGER;

            } else if (ConstDataType.MYSQL_DECIMAL.equalsIgnoreCase(dataType)) {

                // decimal(18,0) -> Long
                if (columnType.matches("decimal\\([ ]{0,}[\\d]{1,},[ ]{0,}0[ ]{0,}\\)")) {
                    return ConstDataType.JAVA_LONG;
                }

                // decimal(18,2) -> Double
                return ConstDataType.JAVA_DOUBLE;

            } else if (ConstDataType.MYSQL_BIGINT.equalsIgnoreCase(dataType)) {
                // bigint -> Long
                return ConstDataType.JAVA_LONG;

            } else if (ConstDataType.MYSQL_DATETIME.equalsIgnoreCase(dataType)) {
                // datetime -> String
                return ConstDataType.JAVA_DATE;
            } else if (ConstDataType.MYSQL_SMALLINT.equalsIgnoreCase(dataType)) {
                // smallint -> Integer
                return ConstDataType.JAVA_INTEGER;
            } else if (ConstDataType.MYSQL_DOUBLE.equalsIgnoreCase(dataType)) {
                // double -> Double
                return ConstDataType.JAVA_DOUBLE;
            }
        }
        return ConstDataType.JAVA_STRING;
    }


}
