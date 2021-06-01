package com.hcl.employee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.employee.beans.Employee;
import com.hcl.employee.dao.EmployeeDAO;
import com.hcl.employee.exception.EmployeeException;

@Service
public class EmployeeServicesImpl implements IEmployeeServices {
	
	@Autowired
	EmployeeDAO empDAO;

	@Override
	public Employee addEmployee(Employee emp) throws EmployeeException {
		if(!empDAO.findById(emp.getId()).isPresent())
			return empDAO.saveAndFlush(emp);
		else
			throw new EmployeeException("Id already exits");
	}

	@Override
	public Employee updateEmployee(Employee emp, int id) throws EmployeeException {
		emp.setId(id);
		if(empDAO.findById(id).isPresent())
			return empDAO.saveAndFlush(emp);
		else
			throw new EmployeeException("Id doesnt exits");
	}

	@Override
	public boolean deleteEmployee(int id) throws EmployeeException {
		if(empDAO.findById(id).isPresent()) {
		   empDAO.deleteById(id);;
		   return true;
		}else
			throw new EmployeeException("Id doesnt exits");
	}

	@Override
	public Employee searchEmployee(int id) throws EmployeeException {
		if(empDAO.findById(id).isPresent())
			return empDAO.getById(id);
		else
			throw new EmployeeException("Id doesnt exits");
	}

	@Override
	public List<Employee> displayEmployee() {
		return empDAO.findAll();
	}

}
