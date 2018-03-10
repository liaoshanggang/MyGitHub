package com.oracle.entity;

import java.sql.Date;

public class Emp {
	int empNo;
	String ename;
	String job;
	int mgr;
	Date hireDate;
	int sal;
	int comm;
	int deptno;

	public Emp() {
		super();
	}

	public Emp(int empNo, String ename, String job, int mgr, Date hireDate,
			int sal, int comm, int deptno) {
		super();
		this.empNo = empNo;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hireDate = hireDate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}

	public Emp(String ename, String job, int mgr, Date hireDate, int sal,
			int comm, int deptno) {
		super();
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hireDate = hireDate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "Emp [empNo=" + empNo + ", ename=" + ename + ", job=" + job
				+ ", mgr=" + mgr + ", hireDate=" + hireDate + ", sal=" + sal
				+ ", comm=" + comm + ", deptno=" + deptno + "]";
	}

}
