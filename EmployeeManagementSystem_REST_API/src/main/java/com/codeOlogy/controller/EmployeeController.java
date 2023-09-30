package com.codeOlogy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codeOlogy.model.Employee;
import com.codeOlogy.service.EmployeeServiceImpl;

/**
 * @author Aditya Ranjan
 * Youtube : @Code_O_logy
 * Website : blogsnax.com
 */

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl empServImpl;
	
	@GetMapping("/")
	public String Home() {
		return "Hello";
	}
	
	/* Create an Employee in the database */
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addEmployee (@RequestBody Employee emp){
		
		Employee emp1 = empServImpl.addEmployee(emp);
		return new ResponseEntity<Employee>(emp1, HttpStatus.CREATED);
	}
	

	/* Delete Employee by id from the database */
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<String> deleteEmployee (@PathVariable int id) {
		
		Optional<Employee> empById = empServImpl.findEmpById(id);
		
		if(empById.isPresent()) {
			empServImpl.removeEmployee(id);
			return  new ResponseEntity<String>("Employee with id "+id+ " removed successfully", HttpStatus.ACCEPTED);
		}
		else {
			return  new ResponseEntity<String>("Employee with id "+id+ " not found", HttpStatus.NOT_FOUND);
		}
	}
	
	/* Fetch Employee by id from the database */
	@GetMapping("/findEmployeebyId/{id}")
	public ResponseEntity<Optional<Employee>> findEmployeebyId (@PathVariable int id) {
		
		Optional<Employee> empL = empServImpl.findEmpById(id);
		return  new ResponseEntity<Optional<Employee>>(empL, HttpStatus.ACCEPTED);
	}
	
	/* Fetch All Employee details from the database */
	@GetMapping("/getAllEmployee")
	public ResponseEntity<List<Employee>> getAllEmployeeController () {
		
		List<Employee> empL = empServImpl.getAllEmployee();
		return  new ResponseEntity<List<Employee>>(empL, HttpStatus.ACCEPTED);
	}
	

	/* Update the Employee detail in the database */
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployeeCon(@PathVariable int id, @RequestBody Employee emplUp) throws Exception {
		
		Optional<Employee> empId = empServImpl.findEmpById(id);
		
		if(empId.isPresent())
			return this.empServImpl.updateEmployee(id, emplUp);
		else
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}
}
