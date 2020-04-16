package com.imooc.crud.mine_mapper;

import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public interface MyBatchSelectMapper<T>{
    @SelectProvider(type = MyBatchSelectProvider.class,method = "dynamicSQL")
    void batchSelect(List<T> list);
}
