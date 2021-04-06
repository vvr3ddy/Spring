package di.ci.example02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CIObjectExample {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
		Employee e = (Employee)context.getBean("empl");
		e.show();
	}
}
