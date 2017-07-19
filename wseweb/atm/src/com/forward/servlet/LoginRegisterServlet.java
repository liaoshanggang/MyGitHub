package com.forward.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forward.po.trade.BankCard;
import com.forward.service.ATMServer;

public class LoginRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginRegisterServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m = request.getParameter("m");
		String returnPage = "/index.jsp"; 
		System.out.println("hello");
		if("login".equals(m)){
			System.out.println("login");
			returnPage = loginCtrl(request, response);
		}else if("register".equals(m)){
			System.out.println("register");
			returnPage = registerCtrl(request, response);
		}

		request.getRequestDispatcher(returnPage).forward(request, response);
	}

	private String registerCtrl(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String accountNo = request.getParameter("accountNo");// 账号//18位
		int password = Integer.parseInt(request.getParameter("password"));// 密码//6位
		//String cardType = request.getParameter("cardType");// 卡类型
		String cardType = request.getParameter("cardType");
		double balance = Double.parseDouble(request.getParameter("balance")) ;// 卡金额
		
		ATMServer server = new ATMServer();
		BankCard realCardInfo = server.register(accountNo, password, cardType, balance);
		BankCard excCardInfo = new BankCard(accountNo, password, cardType, balance);
		
		System.out.println("register数据库里面的："+realCardInfo+"<br>");
		System.out.println("register用户输入的："+cardType+""+excCardInfo);
		
		if(excCardInfo.equals(realCardInfo)){
			return "/index.jsp";
		}else{
			return "/fail.jsp";
		}
	}
	private String loginCtrl(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String cardNo = request.getParameter("cardNo");
		int pwd = Integer.parseInt(request.getParameter("pwd"));
		
		ATMServer server = new ATMServer();
		BankCard actCardInfo = server.login(cardNo, pwd);
		BankCard excCardInfo = new BankCard(cardNo, pwd);
		
		System.out.println("login数据库里面的："+actCardInfo+"<br>");
		System.out.println("login用户输入的："+excCardInfo+"<br>");
		
		if(excCardInfo.equals(actCardInfo)){
			request.getSession().setAttribute("actCardInfo",actCardInfo);
			return "/index.jsp";
		}else{
			return "/fail.jsp";
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
