package com.tech.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tech.entity.Department;
import com.tech.entity.Employee;
import com.tech.entity.Item;
import com.tech.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	//inject the employee service
	@Autowired
	private EmployeeService empService;
	
	//TODO add init binder
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		//white space trimmer, apply to all String class
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		
	}
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		//get employee from service
		List<Employee> theEmps = empService.getEmployeeList();
		
		theModel.addAttribute("employees", theEmps);
		
		return "list-employees";
		
	}
	
	@GetMapping("/add-employee")
	public String addEmployee(Model theModel) {
		
		//create model attribute
		Employee theEmp = new Employee();
		
		List<Department> theDepts = empService.getDepts();
		
		theModel.addAttribute("employee", theEmp);
		theModel.addAttribute("departments", theDepts);
		
		return "employee-form";
	}
	
	@PostMapping("/save-employee")
	public String saveEmployee(@Valid @ModelAttribute("employee") Employee theEmp,
			BindingResult theBindingResult,
			Model theModel) {
		
		// get list of department for combobox
		List<Department> theDepts = empService.getDepts();
		theModel.addAttribute("departments", theDepts);
		
		
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
		
		// get department list for combobox
		List<Department> theDepts = empService.getDepts();
		theModel.addAttribute("departments", theDepts);
		
		//set employee ad model attribute to prepopulate the form
		theModel.addAttribute("employee", theEmployee);
		
		return "employee-form";
		
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("empID") int theID) {
		
		empService.deleteEmployee(theID);
		
		return "redirect:/employee/list";
		
	}
	
	@GetMapping("/assets")
	public String employeeAssets(@RequestParam("empID") int theID, Model theModel) {
		
		//get the employee from service
		Employee theEmployee = empService.getEmployee(theID);
		
		
		//get assets
		List<Item> empAssets = empService.getEmpAssets(theID);
		
		//set employee ad model attribute to prepopulate the form
		theModel.addAttribute("employee", theEmployee);
		
		//set the model for employee's assets
		theModel.addAttribute("empAssets", empAssets);
		
		return "employee-assets";
		
	}
	
	@GetMapping("/add-asset")
	public String addAsset(@RequestParam("empID") int theID, Model theModel) {
		
		//get the employee from service
		Employee theEmployee = empService.getEmployee(theID);
		
		//get all items available
		List<Item> itemsAvail = empService.getItemsAvailable();
		
		//set employee ad model attribute to prepopulate the form
		theModel.addAttribute("employee", theEmployee);
		theModel.addAttribute("itemsAvail", itemsAvail);
		
		return "add-asset";
		
	}
	
	@GetMapping("/save-asset")
	public String saveAsset(
			@RequestParam("empID") int theEmpID,
			@RequestParam("itemID") int theItemID,
			Model theModel) {	
		
		
		//added binding validation
		
		empService.saveAsset(theEmpID, theItemID);
	
		return "redirect:/employee/list";
		
	}
	
}
