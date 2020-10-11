package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/First") 		 //프로그램 파일에 주소를 달아주는 부분 
public class First extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("EUC-KR");   //문자 인코딩
		//html문서에 글을 쓰는 PrintWriter
		PrintWriter out = response.getWriter();
		// client IP 출력
		String ip = request.getRemoteAddr();
		out.print("<html>");
		out.print("<body>");
		
		out.print("접속한 client 주소 : " + ip);
		out.print("<hr>");
		out.print("<img src='img1.jpg'>");  //같은 위치~~~(sublet은 어디에 있던 실행시, WebContent바로 아래에 존재함)
		
		out.print("<hr>");
		// ip에 따른 각각의 페이지 만들어냄(3페이지 만들어냄) ==> 동적인 페이지 
		if (ip.equals("210.105.224.98")) {
			out.print("선생님 환영합니다.");
		} else if (ip.equals("183.105.48.16")) {
			out.print("예슬씨 환영해요!");
		} else {
			out.print("손님 환영합니다.");
		}
		
		
		out.print("<body>");
		out.print("<html>");
	}

}
