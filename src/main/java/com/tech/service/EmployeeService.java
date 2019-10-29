package com.tech.service;

import java.util.List;

import javax.validation.Valid;

import com.tech.entity.Department;
import com.tech.entity.Employee;

public interface EmployeeService {

	public List<Employee> getEmployeeList();

	public void saveEmployee(@Valid Employee theEmp);

	public Employee getEmployee(int theID);

	public List<Department> getDepts();

	public void deleteEmployee(int theID);
	
	
}
