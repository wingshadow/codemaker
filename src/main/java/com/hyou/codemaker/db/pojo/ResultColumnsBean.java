package com.hyou.codemaker.db.pojo;

import com.hyou.codemaker.common.bean.BaseBean;

public class ResultColumnsBean extends BaseBean
{
    private static final long serialVersionUID = -5274068611759714257L;
    private String tableSchema;
    private String tableName;
    private String columnName;
    private String ordinalPosition;
    private String dataType;
    private String characterMaximumLength;
    private String columnType;
    private String columnComment;
    private String nulLable;
    private String columnSize;
    private Integer dataPrecision;
    private Integer dataScale;


    public String getTableSchema()
    {
        return this.tableSchema;
    }

    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
    }

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return this.columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getOrdinalPosition() {
        return this.ordinalPosition;
    }

    public void setOrdinalPosition(String ordinalPosition) {
        this.ordinalPosition = ordinalPosition;
    }

    public String getDataType()
    {
        return this.dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getCharacterMaximumLength() {
        return this.characterMaximumLength;
    }

    public void setCharacterMaximumLength(String characterMaximumLength) {
        this.characterMaximumLength = characterMaximumLength;
    }

    public String getColumnComment() {
        return this.columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public String getColumnType() {
        return this.columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getNulLable() {
        return this.nulLable;
    }

    public void setNulLable(String nulLable) {
        this.nulLable = nulLable;
    }

    public String getColumnSize() {
        return this.columnSize;
    }

    public void setColumnSize(String columnSize) {
        this.columnSize = columnSize;
    }

    public Integer getDataPrecision() {
        return dataPrecision;
    }

    public void setDataPrecision(Integer dataPrecision) {
        this.dataPrecision = dataPrecision;
    }

    public Integer getDataScale() {
        return dataScale;
    }

    public void setDataScale(Integer dataScale) {
        this.dataScale = dataScale;
    }
}