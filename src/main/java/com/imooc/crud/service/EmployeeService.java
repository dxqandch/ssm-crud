package com.imooc.crud.service;

import com.imooc.crud.bean.Department;
import com.imooc.crud.bean.Employee;
import com.imooc.crud.mapper.DepartmentMapper;
import com.imooc.crud.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    @Autowired
    public EmployeeMapper employeeMapper;
    @Autowired
    private DepartmentMapper departmentMapper;
   public Employee selectEmployeeById(Integer empId){
       Employee employee = employeeMapper.selectByPrimaryKey(empId);
       return employee;
   }

    public List<Employee> getAll() {
        List<Employee> employees = employeeMapper.selectAll();
        if (employees != null) {

        List<Department> departments = departmentMapper.selectAll();
        if (departments != null) {
            Map<Integer,String> map=new HashMap<Integer,String>();
        for (Department department : departments) {
            int id=department.getDeptId();
            String name=department.getDeptName();
            map.put(id,name);
        }
        for (Employee employee : employees) {
            String str = map.get(employee.getdId());
            Department department = new Department(employee.getdId(),str);
            employee.setDepartment(department);
        }
        }
            return employees;
        }else {
            throw new NullPointerException("error");
        }
    }

    public void addEmp(Employee employee) {
        employeeMapper.insertSelective(employee);
    }

    public boolean checkUser(String name) {
        Example example = new Example(Employee.class);
        example.createCriteria().andEqualTo("empName",name);
        int count = employeeMapper.selectCountByExample(example);
        return count==0;
    }

    public Employee getEmp(Integer id) {
        Employee employee = employeeMapper.selectByPrimaryKey(id);
        return employee;
    }

    public void updateEmp(Employee employee) {
        employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public void deleteEmp(Integer id) {
        employeeMapper.deleteByPrimaryKey(id);
    }

    public void deleteBatch(List<Integer> ids) {

       Example example=new Example(Employee.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("empId",ids);
        employeeMapper.deleteByExample(example);
    }
}
