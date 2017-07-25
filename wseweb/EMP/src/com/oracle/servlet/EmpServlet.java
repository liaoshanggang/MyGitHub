package com.oracle.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.oracle.entity.Emp;
import com.oracle.server.EmpServer;

public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmpServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String m = request.getParameter("m");
		String returnPage = "/index.jsp";
		//System.out.println("hello");
		if ("login".equals(m)) {
			returnPage = loginCtrl(request, response);
			System.out.println("login");
		} else if ("register".equals(m)) {
			returnPage = registerCtrl(request, response);
			System.out.println("register");
		}else if ("add".equals(m)) {
			returnPage = addEmp(request, response);
			System.out.println("add");
		} else if ("delete".equals(m)) {
			returnPage = deleteEmp(request, response);
			System.out.println("delete");
			return ;
		} else if ("update".equals(m)) {
			returnPage = updateEmp(request, response);
			System.out.println("update");
		} else if ("queryAll".equals(m)) {
			returnPage = queryALlEmpInfos(request, response);
			System.out.println("query");
			return;
		} else if ("show".equals(m)) {
			returnPage = show(request, response);
			 
		}
		request.getRequestDispatcher(returnPage).forward(request, response);
	}

	private String show(HttpServletRequest request, HttpServletResponse response) {
		//当前页数
		int pageIndex = Integer.valueOf(request.getParameter("pageIndex"));
		//每次取6条记录
		int records = 6;//一页要显示多少条记录
		
		EmpServer empServer = new EmpServer();
		List<Emp> emps = empServer.getEmpInfos(records, pageIndex);
		
		//2、记录总共要显示多少个页面，从数据库取出总记录数/records,如果，否则..		
		//数据库里总记录数
		int nums = empServer.getEmpNums();//获得所有emp记录条数
		//总页数
		int pageNums = nums%records==0? nums/records : nums/records+1;
		
		return null;
	}

	private String updateEmp(HttpServletRequest request,
			HttpServletResponse response) {
		return null;
	}

	private String deleteEmp(HttpServletRequest request,
			HttpServletResponse response) {
		String empNo = request.getParameter("empNo");
		String ename = request.getParameter("ename");
		String job = request.getParameter("job");
		Emp emp = new Emp();
		int iempNo = stringToInt(empNo);
		emp.setEmpNo(iempNo);
		emp.setEname(ename);
		emp.setJob(job);
		System.out.println(emp);
		EmpServer empServer = new EmpServer();
		int flag = empServer.deleteUser(emp);
		System.out.println(flag);
		return "/index.jsp";
	}

	private String addEmp(HttpServletRequest request,
			HttpServletResponse response) {
		// int empNo = Integer.parseInt(request.getParameter("empNo"));
		String ename = request.getParameter("ename");
		String job = request.getParameter("job");
		int mgr = Integer.parseInt(request.getParameter("mgr"));
		Date hireDate = null;
		int sal = Integer.parseInt(request.getParameter("sal"));
		int comm = Integer.parseInt(request.getParameter("comm"));
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		Emp emp = new Emp(ename, job, mgr, hireDate, sal, comm, deptno);
		System.out.println(emp);
		EmpServer empServer = new EmpServer();
		int flag = empServer.addUser(emp);
		System.out.println(flag);
		return "/index.jsp";
	}

	private int stringToInt(String str) {

		int result = -1;
		try {
			result = Integer.valueOf(str);
		} catch (NumberFormatException e) {
			// Logger.error(str+": 转型异常"+ e.getMessage());
			System.out.println(e.getMessage());
		}

		return result;
	}

	private String queryALlEmpInfos(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// int empNo = Integer.parseInt(request.getParameter("empNo"));
		// String ename = request.getParameter("ename");
		// int deptno = Integer.parseInt(request.getParameter("deptno"));
		// System.out.println(empNo + "" + ename + "" + deptno);

		String empNo = request.getParameter("empNo");
		String deptno = request.getParameter("deptno");

		EmpServer es = new EmpServer();
		List<Emp> emps = new ArrayList<Emp>();
		Emp emp = new Emp();
		if (!StringUtils.isEmpty(empNo)) {// 1、只填了empNO和同时填了empNO和deptNo的情况
			int iempNo = stringToInt(empNo);
			emp.setEmpNo(iempNo);
			emps.add(es.queryEmpInfo(emp));
		} else if (StringUtils.isEmpty(empNo) && !StringUtils.isEmpty(deptno)) {// 2、只填了deptNO的情况
			int ideptno = stringToInt(deptno);
			emp.setDeptno(ideptno);
			emps = es.getEmpInfosByDeptno(emp.getDeptno(), 20, 1);
		}

		for (Emp emp2 : emps) {
			System.out.println(emp2);
		}
		JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
		String empStr = JSON.toJSONString(emps,
				SerializerFeature.WriteDateUseDateFormat);
		PrintWriter out = response.getWriter();
		out.println(empStr);

		// Emp emps = es.queryEmpInfo(emp);
		// System.out.println(emps);
		// Emp emp2 = new Emp();
		// emp2.setEmpNo(7369);
		// emp2.setEname("SMITH");
		// emp2.setDeptno(20);
		// try {
		// JSONObject json = new JSONObject();
		// json.put("emps", emps);
		// PrintWriter out = response.getWriter();
		// out.println(json.toString());
		// // System.out.println(json.toString());
		// out.close();
		// } catch (JSONException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		return "/index.jsp";
	}

	private String registerCtrl(HttpServletRequest request,
			HttpServletResponse response) {
		return null;
	}

	private String loginCtrl(HttpServletRequest request,
			HttpServletResponse response) {
		return null;
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
