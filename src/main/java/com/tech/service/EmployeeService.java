package com.tech.service;

import java.util.List;

import javax.validation.Valid;

import com.tech.entity.Department;
import com.tech.entity.Employee;
import com.tech.entity.Item;

public interface EmployeeService {

	public List<Employee> getEmployeeList();

	public void saveEmployee(@Valid Employee theEmp);

	public Employee getEmployee(int theID);

	public List<Department> getDepts();

	public void deleteEmployee(int theID);

	public List<Item> getItemsAvailable();

	public void saveAsset(int theEmpID, int theItemID);

	public void removeAsset(int theEmpID, int theItemID);

	public List<?> getEmployeeAssets(int theID);
	
}
