package com.hr.buzi;

import java.util.List;

import com.hr.bean.Employee;

public interface EmployeeBuziDao {
	public Employee getEmployeeById(String id);
	
	public List<Employee> findAllEmployees();
}
