package kr.mem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.model.AddDAO;

@WebServlet("/add.do")
public class AddController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청파라메터를 얻는 작업
		String op1 = request.getParameter("op1");
		String op2 = request.getParameter("op2");
		int num1 = Integer.parseInt(op1);
		int num2 = Integer.parseInt(op2);
		
		//2. Model의 biz() 호출
		AddDAO dao = new AddDAO();
		int result = dao.add(num1, num2);  //request의 계산 결과값 담긴 result
		
		//★★★ 3. 결과를 응답하자. (JSP) - addresult.jsp가 24line의 결과가지고 응답하도록!
		//★★★ 요청의뢰(forward) //비서역할. 요청을 의뢰함
		request.setAttribute("result", result); //특정객체에 값을 연결해 놓는 '객체바인딩' ★★★★★★
		RequestDispatcher rd = request.getRequestDispatcher("addresult.jsp"); //get..~ 요청한 객체 얻어옴
		rd.forward(request, response);
	
	}

}
