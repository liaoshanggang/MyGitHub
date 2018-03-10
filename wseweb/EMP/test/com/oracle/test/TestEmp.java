package com.oracle.test;

import java.sql.Date;

import org.junit.Test;

import com.oracle.entity.Emp;
import com.oracle.server.EmpServer;
import com.oracle.util.ConvertDate;

public class TestEmp {
	EmpServer es = new EmpServer();
	ConvertDate cd;

	@Test
	public void testAdd() {
		int empNo = 7369;
		String ename = "SMITH";
		String job = "SALESMAN";
		int mgr = 7902;
		// Date hireDate = cd.setTime();
		Date hireDate = null;
		int sal = 5250;
		int comm = 300;
		int deptno = 30;
		Emp emp = new Emp(empNo, ename, job, mgr, hireDate, sal, comm, deptno);

		es.addUser(emp);
	}

}
