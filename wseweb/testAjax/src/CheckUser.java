

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CheckUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("username").trim();
		System.out.println(name);
		PrintWriter out = response.getWriter();
		if(name.equals("admin")){
			out.print("yes");
		}else{
			out.print("no");
		}
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
