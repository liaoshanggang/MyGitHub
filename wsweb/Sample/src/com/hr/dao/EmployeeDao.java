package com.hr.dao;

import java.util.List;

import com.hr.bean.Employee;

public interface EmployeeDao {

	public Employee getEmployeeById(String id);
	
	//public List<Employee> findEmployeesById(String id);
	
	public List<Employee> findAllEmployees();
}
