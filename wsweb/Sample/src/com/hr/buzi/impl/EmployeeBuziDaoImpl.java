package com.hr.buzi.impl;

import java.util.List;

import com.hr.bean.Employee;
import com.hr.buzi.EmployeeBuziDao;
import com.hr.dao.EmployeeDao;
import com.hr.dao.impl.EmployeeDaoImpl;

public class EmployeeBuziDaoImpl implements EmployeeBuziDao {
	EmployeeDao ed = null;
	
	public EmployeeBuziDaoImpl() {
		ed = new EmployeeDaoImpl();
	}
	@Override
	public Employee getEmployeeById(String id) {

		return ed.getEmployeeById(id);
	}

	@Override
	public List<Employee> findAllEmployees() {
		return ed.findAllEmployees();
	}

}
