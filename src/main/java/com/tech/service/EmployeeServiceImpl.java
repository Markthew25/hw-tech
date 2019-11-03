package com.tech.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tech.dao.EmployeeDAO;
import com.tech.entity.Department;
import com.tech.entity.Employee;
import com.tech.entity.Item;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO empDAO;
	
	@Override
	@Transactional
	public List<Employee> getEmployeeList() {
		return empDAO.getEmployeeList();
	}

	@Override
	@Transactional
	public void saveEmployee(@Valid Employee theEmp) {
		empDAO.saveEmployee(theEmp);
	}

	@Override
	@Transactional
	public Employee getEmployee(int theID) {
		return empDAO.getEmployee(theID);
	}

	@Override
	@Transactional
	public List<Department> getDepts() {
		return empDAO.getDepts();
	}

	@Override
	@Transactional
	public void deleteEmployee(int theID) {
		empDAO.deleteEmployee(theID);
	}

	@Override
	@Transactional
	public List<Item> getItemsAvailable() {
		return empDAO.getItemsAvailable();
	}

	@Override
	@Transactional
	public void saveAsset(int theEmpID, int theItemID) {
		empDAO.saveAsset(theEmpID, theItemID);
	}

	@Override
	@Transactional
	public void removeAsset(int theEmpID, int theItemID) {
		empDAO.removeAsset(theEmpID, theItemID);
	}

	
}
