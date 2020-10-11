package com.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/idCheck")
public class idCheck extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userid = request.getParameter("userid");
		
		//1.응답데이터를 전달하기 위한 out객체 생성
		//2.out객체를 활용해서 1또는 0이 전달될 수 있도록 작성
		PrintWriter out = response.getWriter();
		
		if(userid.equals("smart")) {
			//중복된아이디 : 1 반환
			out.print(1);	//작성된 데이터는 문자열로 변환되어 전달 된다.
		} else {
			//중복되지 않은 아이디 : 0 반환
			out.print(0);
		}
	
	}

}
