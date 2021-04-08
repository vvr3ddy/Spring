package com.cg;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.dao.IDao;
import com.cg.entity.Product;

@SpringBootApplication
public class SpringBootJpaDemoApplication implements CommandLineRunner {

	@Autowired
	IDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World ");

		Product product = new Product(1, "Product 1", "cat 1", 1000);
		Product product2 = new Product(2, "Product 2", "cat 1", 2000);
		Product product3 = new Product(3, "Product 3", "cat 2", 600);
		dao.save(product);
		dao.save(product2);
		dao.save(product3);
		System.out.println("Saved product");
		// Find by ID
		Optional<Product> p = dao.findById(1);
		if (!p.isEmpty()) {
			System.out.println("Found record");
			System.out.println(p.get().toString());
		}
		
		// Find all

		List<Product> prod = dao.findAll();
		prod.forEach(System.out::println);

		System.out.println("Find by name");
		List<Product> plist = dao.findByName("Product 1");
		plist.forEach(System.out::println);

		System.out.println("Find by category");
		List<Product> plist2 = dao.findByCategory("cat 1");
		plist2.forEach(System.out::println);
		
		List<Product> plist3 = dao.findByCategoryStartingWith("C");
		plist3.forEach(System.out::println);
	}

}
