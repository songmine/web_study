package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Table")
public class Table extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setCharacterEncoding("EUC-KR");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<body>");

		out.print("<table border = '1px solid black'>");
        out.print("<tr>");
        
        for (int i = 1; i <= 10; i++) {
        	out.print("<td>" + i + "</td>");
		}
		
		out.print("<tr>");
		out.print("<table>");
		
		out.print("<body>");
		out.print("<html>");
		
	
	
	
	}

}
