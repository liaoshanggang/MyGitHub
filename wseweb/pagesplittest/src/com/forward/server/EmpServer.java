package com.forward.server;

import java.util.List;

import com.forward.dao.EmpDao;
import com.forward.entity.Emp;

public class EmpServer {
	EmpDao empDao = new EmpDao();
	public int getEmpNums(){
		return empDao.getEmpNums();
	}
	public List<Emp> getEmpInfos(int records,int pageIndex){
		return empDao.getEmpInfos(records, pageIndex);
	}
}
