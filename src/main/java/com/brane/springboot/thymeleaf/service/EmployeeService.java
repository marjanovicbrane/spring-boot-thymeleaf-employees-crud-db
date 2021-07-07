package com.brane.springboot.thymeleaf.service;

import java.util.List;

import com.brane.springboot.thymeleaf.entity.Employee;

//this interface with CRUD methods is for Service layer
public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);

	public void deleteById(int theId);
}
