package com.forward.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PlayVideoSvt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PlayVideoSvt() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置上下文类型
		response.setContentType("video/mp4");
		
		//1、获得输入流
		InputStream is = this.getServletContext().getResourceAsStream("video/getTime.jar");
		//2、获得输出流
		ServletOutputStream sos = response.getOutputStream();
		int b= 0;
		byte[] bytes = new byte[1024];
		while((b=is.read(bytes))!=-1){
			sos.write(bytes, 0, b);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
