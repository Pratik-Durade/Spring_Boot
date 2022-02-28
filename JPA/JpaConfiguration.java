package com.pratik;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JpaConfiguration {

	@Autowired
	private EntityManagerFactory emf;
	
//	@Bean
//	public SessionFactory getSessionFactory()
//	{
////		Session s=(Session) emf.unwrap(SessionFactory.class);
////		
////		return s.getSessionFactory();
//		
//		return emf.unwrap(SessionFactory.class);
//		 
//	}	
	
	@Bean
	public Session getSession()
	{
	
		SessionFactory sf=emf.unwrap(SessionFactory.class);
		Session se=sf.openSession();
		return se;
	}
}