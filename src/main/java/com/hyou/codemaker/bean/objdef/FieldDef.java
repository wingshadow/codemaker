package com.hyou.codemaker.bean.objdef;

public class FieldDef
{
    private String comment;
    private String type;
    private String name;
    private String alias;
    private String getter;
    private String setter;
    private String nullable;
    private String columnSize;

    public String getComment()
    {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getType()
    {
        return this.type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getGetter()
    {
        return this.getter;
    }

    public void setGetter(String getter)
    {
        this.getter = getter;
    }

    public String getSetter()
    {
        return this.setter;
    }

    public void setSetter(String setter)
    {
        this.setter = setter;
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

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}