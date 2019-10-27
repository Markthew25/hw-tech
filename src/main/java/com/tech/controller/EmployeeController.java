package com.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tech.entity.Employee;
import com.tech.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	//inject the employee service
	@Autowired
	private EmployeeService empService;
	
	//TODO add ini binder
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		//get employee from service
		List<Employee> theEmps = empService.getEmployeeList();
		
		theModel.addAttribute("employees", theEmps);
		
		return "list-employees";
		
	}
	
	
	
}
