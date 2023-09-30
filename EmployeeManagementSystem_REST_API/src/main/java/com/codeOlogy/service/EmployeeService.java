package com.codeOlogy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.codeOlogy.model.Employee;

/**
 * @author Aditya Ranjan
 * Youtube : @Code_O_logy
 * Website : blogsnax.com
 */

public interface EmployeeService {

	public Employee addEmployee (Employee emp);
	
	public String removeEmployee (int id);
	
	public Optional<Employee> findEmpById (int id);
	
	public List<Employee> getAllEmployee ();
	
	public ResponseEntity<Employee> updateEmployee (int id, Employee employeeDetails) throws Exception;
}
