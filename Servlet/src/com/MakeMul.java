package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

@WebServlet("/MakeMul")
public class MakeMul extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String color = request.getParameter("color");
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<table border = '1px solid black', bgcolor =" +color+ ">");

		int ch_num1 = Integer.parseInt(num1);
		int ch_num2 = Integer.parseInt(num2);
		
	        for (int start = ch_num1; start <= ch_num2; start++) {
	        	out.print("<tr>");
	        	for (int dan = 1; dan <= 9; dan++) {
	        		out.print("<td>" + start + "*" + dan + "=" + (start*dan) + "</td>");
				}
	        	out.print("</tr>");
			}
			
		out.print("</table>");
		
		out.print("</body>");
		out.print("</html>");
	
	
	
	}

	
	
	
}
