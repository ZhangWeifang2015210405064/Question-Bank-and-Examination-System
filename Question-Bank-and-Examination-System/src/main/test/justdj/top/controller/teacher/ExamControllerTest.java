package justdj.top.controller.teacher;

import justdj.top.JUnit4ClassRunner;
import justdj.top.pojo.Exam;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(JUnit4ClassRunner.class)  //此处调用Spring单元测试类
@WebAppConfiguration()//声明为集成测试加载的ApplicationContext应该是WebApplicationContext类型
//下面的注解告诉测试运行器如何加载和配置WebApplicationContext
@ContextConfiguration(locations = {"/spring/test_springContext.xml","/spring/test_spring-shiro.xml",
		"/test_springMVC.xml","/spring/test_spring-activemq.xml"})
public class ExamControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setUp(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	
	@Test
	public void examManager() throws Exception {
	}
	
	@Test
	public void createExam() throws Exception {
	}
	
	@Test
	public void insertExam() throws Exception {
	}
	
	@Test
	public void examInfo() throws Exception {
		mockMvc.perform(get("/te/exam/info?id=1"))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	@Test
	public void answerOfExam() throws Exception {
		mockMvc.perform(get("/te/exam/answer?id=1"))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	@Test
	public void setAnswerScore() throws Exception {
	}
	
}