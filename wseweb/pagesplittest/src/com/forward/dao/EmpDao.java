package com.forward.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.forward.conn.DBUtil;
import com.forward.entity.Emp;

public class EmpDao {
	/**
	 * 获得所有emp记录条数
	 */
	public int getEmpNums(){
		DBUtil dbUtil = DBUtil.getInstance();
		Connection conn = null;
		PreparedStatement psts = null;
		ResultSet rs = null;
		
		conn = dbUtil.getConnection();
		String sql = "SELECT COUNT(*) FROM employees";

		int nums = -1;
		try {
			psts = conn.prepareStatement(sql );
			rs = psts.executeQuery();
			rs.next();//
			nums = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(conn, psts, rs);
		}
		return nums;
	}
	
	/**
	 * 根据最大和最小参数获得一段用户信息
	 */
	public List<Emp> getEmpInfos(int records,int pageIndex){

		DBUtil dbUtil = DBUtil.getInstance();
		Connection conn = null;
		PreparedStatement psts = null;
		ResultSet rs = null;
		
		conn = dbUtil.getConnection();
		String sql = "SELECT * FROM (SELECT ROWNUM rn,emp.* FROM (SELECT * FROM employees ORDER BY hire_date) emp WHERE ROWNUM <= ?) WHERE rn > ?";

		List<Emp> emps = new ArrayList<Emp>();
		try {
			psts = conn.prepareStatement(sql );
			psts.setInt(1, records*pageIndex);
			psts.setInt(2, records*(pageIndex-1));
			rs = psts.executeQuery();
			while(rs.next()){
				Emp emp = new Emp();
				int id = rs.getInt(2);
				String firstName = rs.getString(3);
				String lastName = rs.getString(4);
				String email = rs.getString(5);
				String phoneNum = rs.getString(6);
				emp.setEmpId(id);
				emp.setFirstName(firstName);
				emp.setLastName(lastName);
				emp.setEmail(email);
				emp.setPhoneNum(phoneNum);
				emps.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(conn, psts, rs);
		}
		
		return emps;
	}
}
