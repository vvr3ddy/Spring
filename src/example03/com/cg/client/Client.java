package example03.com.cg.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import example03.com.cg.config.AppConfig;
import example03.com.cg.entity.Employee;

public class Client {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		Employee e = (Employee) ctx.getBean("e1");

		e.setName("John Doe");
		e.setId(1001);
		e.displayEmp();

		e = (Employee) ctx.getBean("e2");
		e.displayEmp();
	}
}
