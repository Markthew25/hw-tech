package com.tech.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@PostMapping("/save-employee")
	public String saveEmployee(@Valid @ModelAttribute("employee") Employee theEmp,
			BindingResult theBindingResult,
			Model theModel) {
		
		//TODO get list of department for combobox
		
		//added binding validation
		
		if(theBindingResult.hasErrors()) {
			return "employee-form";
		}else {
			empService.saveEmployee(theEmp);
		}
		
		return "redirect:/employee/list";
		
	}
	
	@GetMapping("/update-employee")
	public String updateEmployee(@RequestParam("empID") int theID, Model theModel) {
		
		//get the employee from service
		Employee theEmployee = empService.getEmployee(theID);
		
		//TODO get department list for combobox
		
		//set employee ad model attribute to prepopulate the form
		theModel.addAttribute("employee", theEmployee);
		
		return "employee-form";
		
	}
	
	
}
