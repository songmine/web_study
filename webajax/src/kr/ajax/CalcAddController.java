package kr.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class CalcAddController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int op1 = Integer.parseInt(request.getParameter("op1"));
		int op2 = Integer.parseInt(request.getParameter("op2"));
		int sum = op1+op2;
	
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.print(sum);
	
	}

}
