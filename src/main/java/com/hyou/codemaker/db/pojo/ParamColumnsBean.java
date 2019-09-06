package com.hyou.codemaker.db.pojo;

import com.hyou.codemaker.common.bean.BaseBean;

public class ParamColumnsBean extends BaseBean
{
    private static final long serialVersionUID = 2288060549736806238L;
    private String tableSchema;
    private String tableName;

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
}