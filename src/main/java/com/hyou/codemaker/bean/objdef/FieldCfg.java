package com.hyou.codemaker.bean.objdef;

import java.io.Serializable;

public class FieldCfg implements Serializable
{
    private String comment;
    private String javaType;
    private String name;
    private String columnName;
    private String databaseType;
    private String nullable;
    private String columnSize;

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getComment()
    {
        return this.comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public String getJavaType()
    {
        return this.javaType;
    }

    public void setJavaType(String javaType)
    {
        this.javaType = javaType;
    }

    public String getDatabaseType()
    {
        return this.databaseType;
    }

    public void setDatabaseType(String databaseType)
    {
        this.databaseType = databaseType;
    }

    public String getColumnName()
    {
        return this.columnName;
    }

    public void setColumnName(String columnName)
    {
        this.columnName = columnName;
    }

    public String getNullable() {
        return this.nullable;
    }

    public void setNullable(String nullable) {
        this.nullable = nullable;
    }

    public String getColumnSize() {
        return this.columnSize;
    }

    public void setColumnSize(String columnSize) {
        this.columnSize = columnSize;
    }
}