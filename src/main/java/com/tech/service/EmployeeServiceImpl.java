package com.tech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tech.dao.EmployeeDAO;
import com.tech.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO empDAO;
	
	@Override
	@Transactional
	public List<Employee> getEmployeeList() {
		return empDAO.getEmployeeList();
	}

	
	
}
