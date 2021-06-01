package com.hcl.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.employee.beans.Employee;
import com.hcl.employee.exception.EmployeeException;
import com.hcl.employee.services.IEmployeeServices;



@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
    IEmployeeServices service;
	
	@GetMapping("/displayEmployee")
	public ResponseEntity<List<Employee>> displayEmployee(){
		return new ResponseEntity<List<Employee>>(service.displayEmployee(),HttpStatus.OK);
	}
	
	
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) throws EmployeeException {
		return new ResponseEntity<Employee>(service.addEmployee(emp),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<Boolean> deleteEmployee(@PathVariable int id) throws EmployeeException {
		return new ResponseEntity<Boolean>(service.deleteEmployee(id),HttpStatus.OK);
	}
	
	@PutMapping("/updateEmployee/{id}")
     public ResponseEntity<Employee> updateEmployee(@PathVariable int id,@RequestBody Employee emp) throws EmployeeException {
		return new ResponseEntity<Employee>(service.updateEmployee(emp,id),HttpStatus.OK);
	} 
	
	@GetMapping("/searchEmployee/{id}")
	public ResponseEntity<Employee> searchEmployee(@PathVariable int id) throws EmployeeException{
		return new ResponseEntity<Employee>(service.searchEmployee(id),HttpStatus.OK);
	}
	
	

}
