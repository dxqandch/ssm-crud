package com.imooc.crud.mapper;

import com.imooc.crud.bean.Employee;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
@Component
public interface EmployeeMapper extends Mapper<Employee> {
}
