package example01.com.cg.client;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import example01.com.cg.entity.Restaurant;

public class Client {
	public static void main(String[] args) {
		Resource resource = new FileSystemResource("src/example01/applicationcontext.xml");
		BeanFactory beanfactory = new XmlBeanFactory(resource);

		// Setter Injection based Bean
		Restaurant resto = (Restaurant) beanfactory.getBean("res1");
		resto.displayResto();

		// Constructor Injection based Bean
		Restaurant resto2 = (Restaurant) beanfactory.getBean("res2");
		resto2.displayResto();
	}
}
