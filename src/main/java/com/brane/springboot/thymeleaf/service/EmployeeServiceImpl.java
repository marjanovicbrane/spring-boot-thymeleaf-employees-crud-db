package com.brane.springboot.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brane.springboot.thymeleaf.dao.EmployeeRepository;
import com.brane.springboot.thymeleaf.entity.Employee;

//THIS IS SERVICE LAYER
@Service
public class EmployeeServiceImpl implements EmployeeService {


		
//creating field employeeRepository, because we are using SPRING DATA JPA.Now we can do contructor injection.
private EmployeeRepository employeeRepository;
			
					
		//constructor injection
		@Autowired
		public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
			}
			

		@Override
		public List<Employee> findAll() {
			
			//WE CALLING HERE OUR NEW METHOD FROM JPA REPOSITORY USING SPRING DATA JPA
			return employeeRepository.findAllByOrderByLastNameAsc();
		}



		@Override
		public Employee findById(int theId) {
			
			//*********************************OPTIONAL************************************
			//Its findById method retrieves an entity by its id. The return value is Optional<T> . 
			//Optional<T> is a container object which may or may not contain a non-null value. 
			//If a value is present, isPresent returns true and get returns the value.
			//When returning an Optional instance, it's a useful hint that there's a possibility 
			//that the value might not exist.
			
			//Optional Class is a container for an object that may contains null.With this Optional class, 
			//we can semantically told clients that a function they will use may return a null value
			//that lead into NullPointerException.
			//******************************************************************************
			

			Optional<Employee> result = employeeRepository.findById(theId);
			
			Employee employee=null;
			
			if(result.isPresent()) {

				employee=result.get();
			}
			else {

				throw new RuntimeException("There is no employee with the ID - "+theId);
			}
			return employee;
		}


		@Override
		public void save(Employee theEmployee) {
			
			employeeRepository.save(theEmployee);

		}

		
		@Override
		public void deleteById(int theId) {
			
			employeeRepository.deleteById(theId);

		}

}
