package com.tech.dao;

import java.util.List;

import javax.validation.Valid;

import com.tech.entity.Employee;

public interface EmployeeDAO {

	List<Employee> getEmployeeList();

	void saveEmployee(@Valid Employee theEmp);

	Employee getEmployee(int theID);

}
