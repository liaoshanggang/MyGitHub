package com.forward.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import com.forward.po.trade.BankCard;
import com.forward.service.ATMServer;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m = request.getParameter("m");
		String returnPage = "/index.jsp"; 
		System.out.println("hello");
		if("login".equals(m)){
			returnPage = loginCtrl(request, response);
			System.out.println("login");
		}else if("register".equals(m)){
			returnPage = registerCtrl(request, response);
			System.out.println("register");
		}else if("query".equals(m)){
			returnPage = queryALlCardInfoCtrl(request, response);
			System.out.println("query");
		}else if("query1".equals(m)){
			returnPage = queryAjaxQuery(request, response);
			System.out.println("query1");
		}else if("delete".equals(m)){
			returnPage = deleteUser(request, response);
			System.out.println("delete");
		}else if("add".equals(m)){
			returnPage = addUser(request, response);
			System.out.println("add");
		}
		request.getRequestDispatcher(returnPage).forward(request, response);
	}

	private String queryAjaxQuery(HttpServletRequest request,
			HttpServletResponse response) {
		String account = request.getParameter("account");  
        String cardNo = request.getParameter("cardNo");  
        System.out.println(account);  
        System.out.println(cardNo);  
        boolean IsOK = false;  
        
        ATMServer server = new ATMServer();
        List<BankCard> users = server.queryALlCardInfo();
        if(users.size()!=0){  
            IsOK = true;  
        }else{  
            IsOK = false;  
        }  
        try {  
            JSONObject json = new JSONObject();  
            json.put("IsOK", IsOK);  
            PrintWriter out = response.getWriter();  
            out.println(json.toString());  
            System.out.println(json.toString());
            out.close();  
        } catch (JSONException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } 
		return null;
	}
	private String addUser(HttpServletRequest request,
			HttpServletResponse response) {
		return "/addUser.jsp";
	}
	private String deleteUser(HttpServletRequest request,
			HttpServletResponse response) {
		return "/admin.jsp";
	}
	private String queryALlCardInfoCtrl(HttpServletRequest request,
			HttpServletResponse response) {
		ATMServer server = new ATMServer();
		List<BankCard> users = server.queryALlCardInfo();
		request.setAttribute("users", users);
		return "/userInfo.jsp";
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
