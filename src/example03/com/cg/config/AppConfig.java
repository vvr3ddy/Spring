package example03.com.cg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import example03.com.cg.entity.Employee;

@Configuration
public class AppConfig {
	@Bean(name = "e1")
	public Employee getEmployee1() {
		return new Employee();
	}

	@Bean(name = "e2")
	public Employee getEmployee2() {
		Employee e = new Employee();
		e.setId(1002);
		e.setName("Jean Smith");
		return e;
	}

}
