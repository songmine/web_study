package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/First") 		 //���α׷� ���Ͽ� �ּҸ� �޾��ִ� �κ� 
public class First extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("EUC-KR");   //���� ���ڵ�
		//html������ ���� ���� PrintWriter
		PrintWriter out = response.getWriter();
		// client IP ���
		String ip = request.getRemoteAddr();
		out.print("<html>");
		out.print("<body>");
		
		out.print("������ client �ּ� : " + ip);
		out.print("<hr>");
		out.print("<img src='img1.jpg'>");  //���� ��ġ~~~(sublet�� ��� �ִ� �����, WebContent�ٷ� �Ʒ��� ������)
		
		out.print("<hr>");
		// ip�� ���� ������ ������ ����(3������ ����) ==> ������ ������ 
		if (ip.equals("210.105.224.98")) {
			out.print("������ ȯ���մϴ�.");
		} else if (ip.equals("183.105.48.16")) {
			out.print("������ ȯ���ؿ�!");
		} else {
			out.print("�մ� ȯ���մϴ�.");
		}
		
		
		out.print("<body>");
		out.print("<html>");
	}

}
