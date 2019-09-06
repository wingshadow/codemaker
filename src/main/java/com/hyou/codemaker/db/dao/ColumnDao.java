package com.hyou.codemaker.db.dao;

import java.util.List;

import com.hyou.codemaker.db.pojo.ParamColumnsBean;
import com.hyou.codemaker.db.pojo.ResultColumnsBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 数据库查询指定表的各数据列的信息
 * 
 * @author FengChangshuo
 * @version 1.0.0 2017年6月26日 下午4:17:13 created
 */
@Mapper
@Repository
public interface ColumnDao {

    /**
     * 查询表的各列类型信息
     * 
     * @param paramColumnsBean 表信息查询参数
     * @return 表信息查询结果
     */
    List<ResultColumnsBean> selectTableInfo(ParamColumnsBean paramColumnsBean);
    
}
