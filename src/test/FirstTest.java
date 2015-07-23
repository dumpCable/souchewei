package test;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import souchewei.owner.service.ParkingPlaceOwnerService;

public class FirstTest {
	private ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
	
	@Test
	public void test(){
		TestService testService=(TestService) ac.getBean("testService");
		ParkingPlaceOwnerService service= (ParkingPlaceOwnerService) ac.getBean("parkingPlaceOwnerService");
		System.out.println(service);
		//testService.test();
	}

}
