package com.pratik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootJdbc {
	public static void main(String[] args) {
		
		ConfigurableApplicationContext ac=SpringApplication.run(SpringBootJdbc.class, args);
		
		EmployeeDAO ed=ac.getBean(EmployeeDAO.class,args);
		
		Employee e1=new Employee();
		e1.setEid(110);
		e1.setEname("Pratik Durade");
		e1.setEsalary(30000);
		
		
		//ed.insert(e1);
		
		
		System.out.println("\n\n\t VALUES ARE INSERTED...");
		ed.select();
	}
}
