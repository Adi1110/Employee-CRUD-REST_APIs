package com.codeOlogy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codeOlogy.model.Employee;
import com.codeOlogy.repository.EmployeeRepo;

/**
 * @author Aditya Ranjan
 * Youtube : @Code_O_logy
 * Website : blogsnax.com
 */

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepo empRepo;
	
	List<Employee> empList;
	Employee updateEmployee;
	
	@Override
	public Employee addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		Employee empSave = empRepo.save(emp);
		return empSave;
	}

	@Override
	public String removeEmployee(int id) {
		// TODO Auto-generated method stub
		empRepo.deleteById(id);
		return "Delete the data successfully!";
	}

	@Override
	public Optional<Employee> findEmpById(int id) {
		// TODO Auto-generated method stub
		
		Optional<Employee> emp = empRepo.findById(id);
		if(emp.isPresent())
			return emp;
		else
			return Optional.empty();
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		List<Employee> empList= empRepo.findAll();
		return empList;
	}

	@Override
	public ResponseEntity<Employee> updateEmployee(int id, Employee employeeDetails) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			updateEmployee = empRepo.findById(id)
			        .orElseThrow(() -> new Exception("Employee not exist with id: " + id));
			
			updateEmployee.setEmpId(employeeDetails.getEmpId());
	        updateEmployee.setFirstName(employeeDetails.getFirstName());
	        updateEmployee.setLastName(employeeDetails.getLastName());
	        updateEmployee.setEmail(employeeDetails.getEmail());
	        updateEmployee.setPassword(employeeDetails.getPassword());
	        updateEmployee.setLocation(employeeDetails.getLocation());
	        updateEmployee.setGender(employeeDetails.getGender());
	        
	        empRepo.save(updateEmployee);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Employee with id " +id+ " is not present.");
		}

		return ResponseEntity.ok(updateEmployee);

	}

}
