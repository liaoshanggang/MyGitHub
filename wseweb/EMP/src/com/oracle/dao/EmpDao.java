package com.oracle.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracle.entity.Emp;
import com.oracle.util.DBUtil;

public class EmpDao {
	Connection conn = null;
	PreparedStatement psts = null;
	ResultSet rs = null;

	/**
	 * 获得所有emp记录条数
	 */
	public int getEmpNums() {
		DBUtil dbUtil = DBUtil.getInstance();

		conn = dbUtil.getConnection();
		String sql = "SELECT COUNT(*) FROM copy_emp";

		int nums = -1;
		try {
			psts = conn.prepareStatement(sql);
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
	public List<Emp> getEmpInfos(int records, int pageIndex) {

		DBUtil dbUtil = DBUtil.getInstance();

		conn = dbUtil.getConnection();
		String sql = "SELECT * FROM (SELECT ROWNUM rn,emp.* FROM (SELECT * FROM copy_emp ORDER BY hiredate DESC) emp WHERE ROWNUM <= ?) WHERE rn > ?";

		List<Emp> emps = new ArrayList<Emp>();
		try {
			psts = conn.prepareStatement(sql);
			psts.setInt(1, records * pageIndex);
			psts.setInt(2, records * (pageIndex - 1));
			rs = psts.executeQuery();
			while (rs.next()) {

				int empNo = rs.getInt(2);
				String ename = rs.getString(3);
				String job = rs.getString(4);
				int mgr = rs.getInt(5);
				Date hireDate = rs.getDate(6);
				int sal = rs.getInt(7);
				int comm = rs.getInt(8);
				int deptno = rs.getInt(9);
				Emp emp = new Emp(empNo, ename, job, mgr, hireDate, sal, comm,
						deptno);
				emps.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(conn, psts, rs);
		}

		return emps;
	}

	/**
	 * 根据指定信息查询用户信息
	 * 
	 * @return
	 */
	public Emp queryEmpInfo(Emp emp) {
		DBUtil dbUtil = DBUtil.getInstance();
		conn = dbUtil.getConnection();
		Emp emp1 = null;
		//java.sql.SQLException: 结果集已耗尽
		String sql = "SELECT * FROM copy_emp WHERE copy_emp.empno = ?";
		try {
			psts = conn.prepareStatement(sql);
			psts.setInt(1, emp.getEmpNo());
			rs = psts.executeQuery();
			rs.next();
			int empNo = rs.getInt(1);
			String ename = rs.getString(2);
			String job = rs.getString(3);
			int mgr = rs.getInt(4);
			Date hireDate = rs.getDate(5);
			//Date hireDate = null;
			int sal = rs.getInt(6);
			int comm = rs.getInt(7);
			int deptno = rs.getInt(8);
			emp1 = new Emp(empNo, ename, job, mgr, hireDate, sal, comm, deptno);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(conn, psts, rs);
		}

		return emp1;
	}

	/**
	 * 添加用户信息
	 * 
	 * @return
	 */
	public int addEmpInfo(Emp emp) {
		DBUtil dbUtil = DBUtil.getInstance();
		conn = dbUtil.getConnection();
		// INSERT INTO copy_emp
		// VALUES(emp_seq.nextval,'lisi','1213',7777,sysdate,5000,300,10)
		String sql = "INSERT INTO copy_emp VALUES(emp_seq.nextval,?,?,?,?,?,?,?)";
		int flag = -1;
		try {
			psts = conn.prepareStatement(sql);
			// psts.setInt(1,emp.getEmpNo() );
			psts.setString(1, emp.getEname());
			psts.setString(2, emp.getJob());
			psts.setInt(3, emp.getMgr());
			psts.setDate(4, emp.getHireDate());
			psts.setInt(5, emp.getSal());
			psts.setInt(6, emp.getComm());
			psts.setInt(7, emp.getDeptno());
			flag = psts.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(conn, psts, rs);
		}
		return flag;
	}

	/**
	 * 删除用户信息
	 * 
	 * @return
	 */
	public int deleteEmpInfo(Emp emp) {
		//DELETE FROM copy_emp WHERE empno =
		DBUtil dbUtil = DBUtil.getInstance();
		conn = dbUtil.getConnection();
		// INSERT INTO copy_emp
		// VALUES(emp_seq.nextval,'lisi','1213',7777,sysdate,5000,300,10)
		String sql = "DELETE FROM copy_emp WHERE empno = ?";
		int flag = -1;
		try {
			psts = conn.prepareStatement(sql);
			psts.setInt(1, emp.getEmpNo());
			flag = psts.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(conn, psts, rs);
		}
		return flag;
	}

	/**
	 * 更新用户信息
	 * 
	 * @return
	 */
	public Emp updateEmpInfo(Emp e) {
		return null;
	}

	public List<Emp> queryEmpInfos(Emp emp) {
		return null;
	}

	public List<Emp> getEmpInfosByDeptno(int indeptno, int records,
			int pageIndex) {

		DBUtil dbUtil = DBUtil.getInstance();

		conn = dbUtil.getConnection();
		String sql = "SELECT * FROM (SELECT ROWNUM rn,emp.* FROM (SELECT * FROM copy_emp WHERE deptno = ? ORDER BY hiredate) emp WHERE ROWNUM <= ?) WHERE rn > ?";

		List<Emp> emps = new ArrayList<Emp>();
		try {
			psts = conn.prepareStatement(sql);
			psts.setInt(1, indeptno);
			psts.setInt(2, records * pageIndex);
			psts.setInt(3, records * (pageIndex - 1));
			rs = psts.executeQuery();
			while (rs.next()) {

				int empNo = rs.getInt(2);
				String ename = rs.getString(3);
				String job = rs.getString(4);
				int mgr = rs.getInt(5);
				Date hireDate = rs.getDate(6);
				int sal = rs.getInt(7);
				int comm = rs.getInt(8);
				int deptno = rs.getInt(9);
				Emp emp = new Emp(empNo, ename, job, mgr, hireDate, sal, comm,
						deptno);
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
