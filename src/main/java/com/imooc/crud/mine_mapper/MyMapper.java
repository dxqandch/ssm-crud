package com.imooc.crud.mine_mapper;

import tk.mybatis.mapper.common.Mapper;

public interface MyMapper<T> extends Mapper<T>,MyBatchSelectMapper<T> {
}
