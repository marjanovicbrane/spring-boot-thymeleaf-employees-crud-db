package com.brane.springboot.thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brane.springboot.thymeleaf.entity.Employee;

//THIS IS DAO LAYER
//we using spring data JPA to extends JpaRepository interface and then we don't need to make all CRUD(DAO) methods.
//This interface provides all CRUD method automatically.We just need to set Entity type(Employee) and primary key(Integer).
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
