package com.imooc.crud.mine_mapper;

import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;

import java.util.Set;

public class MyBatchSelectProvider extends MapperTemplate {
    public MyBatchSelectProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }
    public void batchSelect(MappedStatement statement){
StringBuilder builder=new StringBuilder("select ");
        Class<?> entityClass = super.getEntityClass(statement);
        String tableName = super.tableName(entityClass);
        Set<EntityColumn> columns = EntityHelper.getColumns(entityClass);
        builder.append("<set>");
        for (EntityColumn column : columns) {
            builder.append("colums,");
        }
        builder.append("<set>");
    }
}
