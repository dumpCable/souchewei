package test;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstTest {
	private ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
	
	@Test
	public void test(){
		TestService testService=(TestService) ac.getBean("testService");
		testService.test();
	}

}
