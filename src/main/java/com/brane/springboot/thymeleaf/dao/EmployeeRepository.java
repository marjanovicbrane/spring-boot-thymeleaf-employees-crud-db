package com.brane.springboot.thymeleaf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brane.springboot.thymeleaf.entity.Employee;

//THIS IS DAO LAYER
//we using spring data JPA to extends JpaRepository interface and then we don't need to make all CRUD(DAO) methods.
//This interface provides all CRUD method automatically.We just need to set Entity type(Employee) and primary key(Integer).
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//we are adding custom method to JPA Repository, so we can sort our data by last name
	//SPRING DATA JPA will parse the method name, looks for specific format and pattern and then creates appropriate query behind the scenes.
	//SPRING DATA JPA do this query automatically:"from Employee order by lastName asc"
	public List<Employee> findAllByOrderByLastNameAsc();
}
