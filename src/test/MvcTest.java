import com.github.pagehelper.PageInfo;
import com.imooc.crud.bean.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml","file:src/main/webapp/WEB-INF/springmvc-servlet.xml"})
public class MvcTest {
    @Autowired
    WebApplicationContext context;
    MockMvc mockMvc;
    @Before
    public void iniMokcMvc(){
    mockMvc=MockMvcBuilders.webAppContextSetup(context).build();

    }
    @Test
    public void testPage() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "1")).andReturn();
        MockHttpServletRequest request = result.getRequest();
        PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
        List list = pageInfo.getList();
        for (Object o : list) {
            Employee o1 = (Employee) o;
            System.out.println(o1.getEmpName());
            System.out.println(o1.getDepartment().getDeptName());
        }
        System.out.println("当前页码" + pageInfo.getPageNum());
    }
}
