package com.pratik;

import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public class EmployeeDAO extends JdbcDaoSupport{
	@Autowired
	DataSource ds;  // Application.properties automatically read by DataSource obj
	
	@PostConstruct
	private void initialize()
	{
		setDataSource(ds);
	}
	
	public void insert(Employee e)
	{
		String sql="insert into employee values("+e.getEid()+",'"+e.getEname()+"',"+e.getEsalary()+")";
		// String sql1="insert into employee values(110,'Prasad',25000)";
		getJdbcTemplate().execute(sql);                      
	}
	
	public void select()
	{
		List li=getJdbcTemplate().queryForList("select * from employee");
		
		Iterator i=li.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
	}
	
	
}
