package com.codeOlogy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeOlogy.model.Employee;

/**
 * @author Aditya Ranjan
 * Youtube : @Code_O_logy
 * Website : blogsnax.com
 */

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
