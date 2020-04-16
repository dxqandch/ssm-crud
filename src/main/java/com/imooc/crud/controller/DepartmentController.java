package com.imooc.crud.controller;

import com.imooc.crud.bean.Department;
import com.imooc.crud.bean.Msg;
import com.imooc.crud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @ResponseBody
    @RequestMapping("/depts")
    public Msg getDepts(){
        List<Department> departments = departmentService.selectAll();
        return Msg.success().add("depts",departments);
    }
}
