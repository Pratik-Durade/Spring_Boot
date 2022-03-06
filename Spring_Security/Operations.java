package com.pratik;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public class Operations {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public boolean established()
	{
		Session ss=hibernateTemplate.getSessionFactory().openSession();
		if(ss!=null)
			return true;
		
		else
			return false;
	}
	
	public void insert(Employee emp,int id)
	{
		Session ss=hibernateTemplate.getSessionFactory().openSession();
		Transaction tx=ss.beginTransaction();
		
		Employer er=ss.load(Employer.class, id);
		emp.setPassword(passwordEncoder.encode(emp.getPassword()));
		emp.setEmployer(er);
		ss.save(emp);
		tx.commit();
	}
	
	public Employee view(int id)
	{
		return hibernateTemplate.get(Employee.class, id);
	}
	
	public Employer viewemployer(int id)
	{
		return hibernateTemplate.get(Employer.class, id);
	}
	
	public void erinsert(Employer er)
	{
		Session ss=hibernateTemplate.getSessionFactory().openSession();
		Transaction tx=ss.beginTransaction();
		
		ss.save(er);
		tx.commit();
	}
}
