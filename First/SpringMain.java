package com.pratik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringMain {

	public static void main(String[] args) {
		ApplicationContext ac=SpringApplication.run(SpringMain.class, args);
 
		Student s=ac.getBean(Student.class);
		s.setSid(1010);
		s.setSname("Pratik Durade");
		s.setMarks(456);
		
		System.out.println(s);
	}

}
