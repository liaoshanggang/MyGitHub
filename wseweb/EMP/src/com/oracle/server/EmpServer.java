package com.oracle.server;

import java.util.List;

import com.oracle.dao.EmpDao;
import com.oracle.entity.Emp;
import com.oracle.util.VerifyEmpInfo;

public class EmpServer {
	VerifyEmpInfo v;
	EmpDao empDao = new EmpDao();

	public int getEmpNums() {
		return empDao.getEmpNums();
	}

	public List<Emp> getEmpInfos(int records, int pageIndex) {
		return empDao.getEmpInfos(records, pageIndex);
	}

	public Emp queryEmpInfo(Emp emp) {
		return empDao.queryEmpInfo(emp);
	}

	public int addUser(Emp emp) {
		return empDao.addEmpInfo(emp);
	}
	public int deleteUser(Emp emp){
		return empDao.deleteEmpInfo(emp);
	}
	public List<Emp> getEmpInfosByDeptno(int deptno, int records, int pageIndex) {
		return empDao.getEmpInfosByDeptno(deptno, records, pageIndex);
	}
}
