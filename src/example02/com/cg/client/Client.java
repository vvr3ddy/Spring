package example02.com.cg.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import example02.com.cg.entity.Employee;

public class Client {
	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/example02/applicationcontext.xml");
		Employee e = (Employee)ctx.getBean("emp1");
		e.displayEmployee();
	}
}
