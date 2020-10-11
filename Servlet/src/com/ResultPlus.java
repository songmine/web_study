package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

@WebServlet("/ResultPlus")
public class ResultPlus extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		
		int ch_num1 = Integer.parseInt(num1);
		int ch_num2 = Integer.parseInt(num2);
		int sum = ch_num1 + ch_num2;
		out.print(ch_num1 + "+" + ch_num2 + "=" + sum);
		
//		int sum = Integer.parseInt(num1) + Integer.parseInt(num2);
//		out.print(num1 + "+" + num2 + "=" + sum);
		
		out.print("<body>");
		out.print("<html>");
	
	
	
	}
	
	
	


}
