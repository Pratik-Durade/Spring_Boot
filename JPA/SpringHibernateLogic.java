package com.pratik;

import org.aspectj.apache.bcel.util.ClassPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

@SpringBootApplication
// @EnableAutoConfiguration
public class SpringHibernateLogic implements CommandLineRunner{
	
	@Autowired
	private EmployeeDao dao;	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateLogic.class, args);
		
		System.out.println("\n\n\n\n\t\t now Its Running.....\n\n\n");
		
	}

	public void run(String... args) throws Exception {
		Employee e=new Employee();
		//e.setId(101);
		e.setName("Aradhya");
		e.setSalary(45000);
		
		//  dao.insert(e);
		 		
		System.out.println("\n\t Employee Data \n");
		dao.select();
	
		dao.delete(6);
			
		dao.select();
		
	}
	
	
	
}	
