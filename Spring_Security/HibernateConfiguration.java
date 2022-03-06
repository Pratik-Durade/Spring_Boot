package com.pratik;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
@Configuration
@PropertySource(value = {"classpath:application.properties"})
public class HibernateConfiguration {
	
	@Value("${spring.datasource.driver-class-name}")
	private String driverClass;
	
	@Value("${spring.datasource.url}")
	private String url;
	
	@Value("${spring.datasource.data-username}")
	private String username;
	
	
	@Value("${spring.datasource.data-password}")
	private String password;
		
	@Value("${spring.jpa.properties.hibernate.dialect}")
	private String dialect;
	
	@Bean
	public DataSource dataSource()
	{
		DriverManagerDataSource ds=new DriverManagerDataSource(url, username, password);
		ds.setDriverClassName(driverClass);
		return ds;
	}
	
	private Properties setProperties()
	{
		Properties prop=new Properties();
		prop.put("hibernate.dialect", dialect);
		prop.put("hibernate.hbm2ddl.auto", "create");
		prop.put("hibernate.show-sql", "true");
		return prop;
	}
	
	@Bean
	public LocalSessionFactoryBean factoryBean()
	{
		LocalSessionFactoryBean bean=new LocalSessionFactoryBean();
		bean.setDataSource(dataSource());
		bean.setHibernateProperties(setProperties());
		bean.setPackagesToScan(new String[] {"com.pratik"});
		return bean;
	}
	
	@Bean
	public HibernateTemplate getHibernateTemplate()
	{
		HibernateTemplate ht=new HibernateTemplate();
		ht.setSessionFactory(factoryBean().getObject());
		ht.setCheckWriteOperations(false);		
		return ht;
	}

}
