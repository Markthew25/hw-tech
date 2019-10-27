package com.tech.service;

import java.util.List;

import javax.validation.Valid;

import com.tech.entity.Employee;

public interface EmployeeService {

	public List<Employee> getEmployeeList();

	public void saveEmployee(@Valid Employee theEmp);

	public Employee getEmployee(int theID);
	
	
}
