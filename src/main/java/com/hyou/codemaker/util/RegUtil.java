package com.hyou.codemaker.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.hyou.codemaker.common.consts.ConstCommon;

public class RegUtil {
    
    private static final String REG_UNDERLINE = "_[a-z]";
    
    private static Pattern pattern = Pattern.compile(REG_UNDERLINE);
    
    private static final String REG_UNDERLINE_TAB = "_[a-z0-9]";
    
    private static Pattern patternTab = Pattern.compile(REG_UNDERLINE_TAB);
    
    /**
     * 将数据库表的字段名称转换成驼峰风格命名的字符串
     * @param columnName like IS_DELETE
     * @return
     */
    public static String columnToFieldName(String columnName) {
        if(StringUtils.isEmpty(columnName)) {
            return null;
        }
        
        if(columnName.startsWith(ConstCommon.SPLIT_UNDER_LINE)) {
            columnName = columnName.substring(1);
        }
        
        columnName = columnName.toLowerCase();
        
        Matcher matcher = pattern.matcher(columnName);
        
        String group;
        StringBuffer sb = new StringBuffer();
        while(matcher.find()) {
            group = matcher.group();
            group = group.replace(ConstCommon.SPLIT_UNDER_LINE, ConstCommon.EMPTY_STR);
            matcher.appendReplacement(sb, group.toUpperCase());
        }
        
        matcher.appendTail(sb);
        
        return sb.toString();
    }
    
    /**
     * 根据表名转成相应的Bean类名. t_table_name → TableName
     * 
     * @param tableName
     * @return
     */
    public static String tableToClassName(String tableName) {
        if(StringUtils.isEmpty(tableName)) {
            return null;
        }
        
        String vtableName = tableName.toLowerCase();
        if (vtableName.startsWith(ConstCommon.TABLE_PREFIX)) {
            vtableName = vtableName.substring(2);
        }
        
        Matcher matcher = patternTab.matcher(vtableName);
        
        String group;
        StringBuffer sb = new StringBuffer();
        while(matcher.find()) {
            group = matcher.group();
            group = group.replace(ConstCommon.SPLIT_UNDER_LINE, ConstCommon.EMPTY_STR);
            matcher.appendReplacement(sb, group.toUpperCase());
        }
        
        matcher.appendTail(sb);
        
        String firstChar = sb.substring(0, 1).toUpperCase();
        sb.deleteCharAt(0);
        sb.insert(0, firstChar);
        
        return sb.toString();
    }
    
}
