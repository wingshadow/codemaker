package com.hyou.codemaker.common.consts;

/**
 * 数据类型常量
 * 
 * @author FengChangshuo
 * @version 1.3.1 2017-10-31 10:40:55 添加对Double数据类型的支持
 */
public class ConstDataType {

    /**
     * Java中的数据类型
     */
    public static final String JAVA_STRING = "String";
    public static final String JAVA_INTEGER = "Integer";
    public static final String JAVA_LONG = "Long";
    public static final String JAVA_FLOAT= "Float";
    public static final String JAVA_DOUBLE = "Double";
    public static final String JAVA_DATE = "Date";
    
    /**
     * MySQL中的列类型
     */
    public static final String MYSQL_VARCHAR = "varchar";
    public static final String MYSQL_CHAR = "char";
    public static final String MYSQL_INT = "int";
    public static final String MYSQL_FLOAT = "Float";
    public static final String MYSQL_BIGINT = "bigint";
    public static final String MYSQL_DOUBLE = "double";
    public static final String MYSQL_DECIMAL = "decimal";
    public static final String MYSQL_DATETIME = "datetime";
    public static final String MYSQL_SMALLINT = "smallint";
    /**
     * oracle
     */
    public static final String ORACLE_VARCHAR = "VARCHAR2";
    public static final String ORACLE_CHAR = "CHAR";
    public static final String ORACLE_NUMBER = "NUMBER";
    public static final String ORACLE_DATE = "DATE";
    public static final String ORACLE_TIMESTAMP= "TIMESTAMP";


    
    /**
     * public enum JdbcType :
     *     ARRAY, BIT, 
     *     TINYINT, SMALLINT, INTEGER, BIGINT, 
     *     FLOAT, REAL, 
     *     DOUBLE, NUMERIC, DECIMAL, 
     *     CHAR, VARCHAR, LONGVARCHAR, 
     *     DATE, TIME, TIMESTAMP, 
     *     BINARY, VARBINARY, 
     *     LONGVARBINARY, NULL, OTHER, 
     *     BLOB, CLOB, BOOLEAN, 
     *     CURSOR, UNDEFINED, NVARCHAR, NCHAR, NCLOB, STRUCT;
     */
    public static final String MYBATIS_JDBC_INT = "INTEGER";
    public static final String MYBATIS_JDBC_TIMESTAMP = "TIMESTAMP";
    public static final String MYBATIS_JDBC_BIGINT = "bigint";
    public static final String MYBATIS_JDBC_DOUBLE = "double";
    public static final String MYBATIS_JDBC_VARCHAR = "VARCHAR";
    public static final String MYBATIS_JDBC_DATE = "DATE";
    public static final String MYBATIS_JDBC_CHAR = "CHAR";
}
