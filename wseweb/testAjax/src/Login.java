

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public final static String To_login_Page = "0";  
	    public final static String login = "1";  
	    public final static String index = "2";  
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method =  request.getParameter("method"); 
		System.out.println(method);
        switch(method){  
        case To_login_Page:  
            To_login_Page(request,response);  
            break;  
        case login:  
            login(request,response);  
            break;  
        case index:  
            index(request,response);  
            break;  
        } 
	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("index");
		request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request,response);  
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login");
		 String username = request.getParameter("username");  
	        String password = request.getParameter("password");  
	        System.out.println(username);  
	        System.out.println(password);  
	        boolean IsOK = false;  
	        if(username.equals("admin")&&password.equals("123456")){  
	            IsOK = true;  
	        }else{  
	            IsOK = false;  
	        }  
	        try {  
	            JSONObject json = new JSONObject();  
	            json.put("IsOK", IsOK);  
	            PrintWriter out = response.getWriter();  
	            out.println(json.toString());  
	            out.close();  
	        } catch (JSONException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	}

	private void To_login_Page(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("To_login_Page");
		request.getRequestDispatcher("WEB-INF/view/login.jsp").forward(request,response);  
	}

}
