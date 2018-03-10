package com.hr.buz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.hr.bean.Employee;

public class EmploeeBiz {
	private Connection conn = null;
	private PreparedStatement st = null;
	private ResultSet rs = null;

	// 获取数据库连接
	public void getConnection() {

		try {
			Context ct = new InitialContext();
			DataSource ds = (DataSource) ct.lookup("java:comp/env/jdbc/mysql");
			conn = ds.getConnection();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}

	}

	// 释放资源
	private boolean closeResource() {

		try {
			if (rs != null) {
				rs.close();
			}
			if (null != st) {
				st.close();
			}
			if (null != conn) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// 获取所有雇员信息
	public List<Employee> getAllEmployees() {
		getConnection();
		List<Employee> list = new ArrayList<Employee>();
		try {
			String sql = "select * from hr";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				Employee ee = new Employee();
				ee.setId(rs.getString(1));
				ee.setName(rs.getString(2));
				ee.setMinWage(rs.getDouble(3));
				ee.setMaxWage(rs.getDouble(4));
				list.add(ee);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResource();
		}
		return list;
	}

	// 获取指定编号的单个雇员信息
	public Employee getEmployeeById(String id) {
		Employee ee = null;
		getConnection();
		try {
			String sql = "select * from hr where id=" + id;
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			if(rs.next()){
			ee = new Employee();
			ee.setId(rs.getString("id"));
			ee.setName(rs.getString("name"));
			ee.setMinWage(rs.getDouble("minWage"));
			ee.setMaxWage(rs.getDouble("maxWage"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResource();
		}
		return ee;
	}

	// 获取指定部门的所有雇员信息
}
