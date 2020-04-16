package service;

import com.imooc.crud.bean.Employee;
import com.imooc.crud.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class EmployeeServiceTest {
    String a="a2s";
   private ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
    private EmployeeService employeeService=context.getBean(EmployeeService.class);
    @Test
    public void selectTest1(){
        a.length();
        List<Employee> employees = employeeService.getAll();
        for (Employee employee : employees) {
            System.out.println(employee);
            System.out.println(employee.getDepartment().getDeptName());
        }
    }
    @Test
    public void selectTest2(){
        Employee employee = employeeService.selectEmployeeById(1);

        System.out.println(employee);
    }
    @Test void test3(){
        Employee emp = employeeService.getEmp(1);
        System.out.println(emp);
    }
}
