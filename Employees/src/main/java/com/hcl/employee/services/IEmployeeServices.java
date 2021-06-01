package com.hcl.employee.services;

import java.util.List;

import com.hcl.employee.beans.Employee;
import com.hcl.employee.exception.EmployeeException;



public interface IEmployeeServices {
	
public Employee addEmployee(Employee emp) throws EmployeeException;
	
	public Employee updateEmployee(Employee emp,int id) throws EmployeeException;

	public boolean deleteEmployee(int id) throws EmployeeException;

	public Employee searchEmployee(int id) throws EmployeeException;
	
	public List<Employee> displayEmployee();

}
