package com.brane.springboot.thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brane.springboot.thymeleaf.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	
	private List<Employee> employee;
	
	//when spring boot create spring bean, then it will be called automatically this metod loadData()
	@PostConstruct
	private void loadData() {

		Employee employee1=new Employee(1,"Brane","Marjanovic","marjanovicbrane@bmcompany.com");
		Employee employee2=new Employee(2,"Elon","Musk","elonmusk@spacex.com");
		Employee employee3=new Employee(3,"Jeff","Bezos","jeffbezos@amazon.com");
		Employee employee4=new Employee(4,"Mark","Zuckerberg","markzuckerberg@facebook.com");
		

		employee=new ArrayList<>();
		
		//populate this array list with objects
		employee.add(employee1);
		employee.add(employee2);
		employee.add(employee3);
		employee.add(employee4);
		
	}
	
	//making request mapping /list and then we will store list of objects into attribute model called employees
	//this model we will use in our tgymeleaf template to show all data in table with for each loop
	@GetMapping("/list")
	public String listEmployees(Model model) {
		
		model.addAttribute("employees", employee);
		
		//we'll return list-employees.html thymeleaf template
		return "list-employees";
	}
	
}
