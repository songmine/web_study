package com.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ajax")
public class AjaxTest extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String num = request.getParameter("num");
		String alpha = request.getParameter("alpha");
		String hangul = request.getParameter("hangul");
		
		System.out.println(num);
		System.out.println(alpha);
		System.out.println(hangul);
		
		System.out.println("ajax_basic2.html로부터 요청이 들어옴..");
	}

}
