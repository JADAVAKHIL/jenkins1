package com.hcl.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.employee.beans.Employee;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee,Integer>{

}
