package com.tech.dao;

import java.util.List;

import javax.validation.Valid;

import com.tech.entity.Department;
import com.tech.entity.Employee;
import com.tech.entity.Item;

public interface EmployeeDAO {

	List<Employee> getEmployeeList();

	void saveEmployee(@Valid Employee theEmp);

	Employee getEmployee(int theID);

	List<Department> getDepts();

	void deleteEmployee(int theID);
	
	List<Item> getItemsAvailable();

	void saveAsset(int theEmpID, int theItemID);

	void removeAsset(int theEmpID, int theItemID);

}
