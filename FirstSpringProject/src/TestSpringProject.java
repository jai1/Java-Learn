

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.learn.spring.Restaurant;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringProject {

	Restaurant res;

	public TestSpringProject() {
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
		
		res = (Restaurant) context.getBean("restaurantBean");
		
	}

	@Test
	public void test() {
		//assertEquals(res.greetCustomer(),"Welcome to Jai's Restaurant !!!");
		res.prepareHotDrink();
	}

}
