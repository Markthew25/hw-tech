package com.tech.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.tech.entity.Employee;

@Repository
public class EmployeeDAOImpl extends BaseDAO implements EmployeeDAO {

	@Override
	public List<Employee> getEmployeeList() {
		
		//get the current hibernate session
//			Session currentSession = sessionFactory.getCurrentSession(); // commented out, to try BaseDAO getCurrentSession
		
		//create a query.. and sort by itemName
		Query <Employee> theQuery =
				getCurrentSession().createQuery("from Employee order by empLName", Employee.class);
		
		//execute query and get result list
		List<Employee> employees = theQuery.getResultList(); 
		
		//return the results
		return employees;
	}

}
