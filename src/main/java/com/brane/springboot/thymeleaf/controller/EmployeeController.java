package com.brane.springboot.thymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.brane.springboot.thymeleaf.entity.Employee;
import com.brane.springboot.thymeleaf.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	//creating field employeeService.Now we can do contructor injection.
	private EmployeeService employeeService;
	
	//constructor injection
	@Autowired
	public EmployeeController (EmployeeService theEmployeeService) {
		employeeService=theEmployeeService;
	}
	
	
	//making request mapping /list and then we will store list of objects into attribute model called employees
	//this model we will use in our tgymeleaf template to show all data in table with for each loop
	@GetMapping("/list")
	public String listEmployees(Model model) {
		
		//delegate calls from controller to service layer
		//get employees from db
		List<Employee> employee=employeeService.findAll();
		
		model.addAttribute("employees", employee);
		
		//we'll return list-employees.html thymeleaf template
		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Employee theEmployee=new Employee();
		
		//create model attribute to bind form data
		model.addAttribute("employee",theEmployee);
		
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	//data binding using model attribute employee from FORM
	public String saveEmployee(@ModelAttribute("employee") Employee employee){
		
		//save the employee object-delegate calls to the service layer
		employeeService.save(employee);
		
		//use redirect to prevent duplicate submissions.
		//we are using here POST-REDIRECT-GET PATTERN(PRG)
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int id, Model model) {
		
		//get the employee from the service layer
		Employee theEmployee=employeeService.findById(id);
		
		//set employee as a model attribute to pre-populate the form
		model.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";
		
	}
}
