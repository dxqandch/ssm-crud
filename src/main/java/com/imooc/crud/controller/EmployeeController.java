package com.imooc.crud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imooc.crud.bean.Employee;
import com.imooc.crud.bean.Msg;
import com.imooc.crud.service.EmployeeService;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    /**
     * 分页查询员工
     *
     * @return
     */
    // @RequestMapping("/emps")
    public String getEmps(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        //引入pagehelper
        PageHelper.startPage(pn, 5);
        List<Employee> employees = employeeService.getAll();

        PageInfo pageInfo = new PageInfo(employees, 1);
        model.addAttribute(pageInfo);
        return "list";
    }

    @RequestMapping("/emps")
    @ResponseBody()
    public Msg getEmpsWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        PageHelper.startPage(pn, 5);
        List<Employee> employees = employeeService.getAll();
        PageInfo pageInfo = new PageInfo(employees, 1);
        return Msg.success().add("pageInfo", pageInfo);
    }

    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    @ResponseBody
    public Msg addEmp(@Valid Employee employee, BindingResult result) {
        Map<String, Object> map = new HashMap<>();
//        if (result.hasErrors()) {
//            List<FieldError> fieldErrors = result.getFieldErrors();
//            for (FieldError fieldError : fieldErrors) {
//                map.put(fieldError.getField(), fieldError.getDefaultMessage());
//            }
//            return Msg.fail().add("errorFields", map);
//        } else {
            employeeService.addEmp(employee);
            return Msg.success();
        }
//    }

    /**
     * @param name
     * @return
     */
    @RequestMapping("/checkuser")
    @ResponseBody
    public Msg checkuser(@RequestParam("empName") String name) {
        //先判断用户名合法
        String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
        if (!name.matches(regx)) {
            return Msg.fail().add("va_msg", "用户名由2-5位汉字或者6-16为字母数字组合组成");
        }

        boolean b = employeeService.checkUser(name);
        if (b) {
            return Msg.success();
        } else {
            return Msg.fail().add("va_msg", "用户名已被占用");
        }
    }
    @ResponseBody
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.GET)
    public Msg getEmp(@PathVariable Integer id){
        Employee employee = employeeService.getEmp(id);
        return Msg.success().add("employee",employee);
    }
    @ResponseBody
    @RequestMapping(value = "/emp/{empId}",method = RequestMethod.PUT)
    public Msg updateEmp(Employee employee){
        employeeService.updateEmp(employee);
        System.out.println(employee);
        return Msg.success();
    }

    @RequestMapping(value = "/emp/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public Msg deleteEmp(@PathVariable("id") String ids){
        if (ids.contains("-")){
            String[] str_id=ids.split("-");
            List<Integer> del_ids=new ArrayList<>();
            for (String s : str_id) {
                del_ids.add(Integer.parseInt(s));
            }
            employeeService.deleteBatch(del_ids);
        }else {
            int id = Integer.parseInt(ids);
            employeeService.deleteEmp(id);
        }
        return Msg.success();

    }
}
