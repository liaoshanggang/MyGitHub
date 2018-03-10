package com.hr.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hr.bean.Employee;
import com.hr.dao.EmployeeDao;

public class EmployeeDaoImpl extends BaseDaoImpl implements EmployeeDao{
	Connection conn = null;
	PreparedStatement pt = null;
	ResultSet rs = null;
	
	@Override
	public Employee getEmployeeById(String id) {
		Employee ee = new Employee();
		try {
			conn = getConnection();
			String sql = "select * from hr where id ="+id;
			pt = conn.prepareStatement(sql);
			rs = pt.executeQuery();
			if(rs.next()){
				ee.setId(rs.getString("id"));
				ee.setName(rs.getString("name"));
				ee.setMinWage(rs.getDouble("minWage"));
				ee.setMaxWage(rs.getDouble("maxWage"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ee;
	}

	/*@Override
	public List<Employee> findEmployeesById(String id) {
		List<Employee> list = new ArrayList<>();
		try {
			conn = getConnection();
			String sql = "select * from hr where id ="+id;
			pt = conn.prepareStatement(sql);
			rs = pt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}*/

	@Override
	public List<Employee> findAllEmployees() {
		List<Employee> list = new ArrayList<>();
		try {
			conn = getConnection();
			String sql = "select * from hr";
			pt = conn.prepareStatement(sql);
			rs = pt.executeQuery();
			while(rs.next()){
				Employee ee = new Employee();
				ee.setId(rs.getString("id"));
				ee.setName(rs.getString("name"));
				ee.setMinWage(rs.getDouble("minwage"));
				ee.setMaxWage(rs.getDouble("maxwage"));
				list.add(ee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
