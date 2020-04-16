package com.imooc.crud.service;

import com.imooc.crud.bean.Department;
import com.imooc.crud.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;
    public  List<Department>  selectAll(){
        return departmentMapper.selectAll();
    }
}
