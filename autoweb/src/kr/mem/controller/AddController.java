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
		//1. ��û�Ķ���͸� ��� �۾�
		String op1 = request.getParameter("op1");
		String op2 = request.getParameter("op2");
		int num1 = Integer.parseInt(op1);
		int num2 = Integer.parseInt(op2);
		
		//2. Model�� biz() ȣ��
		AddDAO dao = new AddDAO();
		int result = dao.add(num1, num2);  //request�� ��� ����� ��� result
		
		//�ڡڡ� 3. ����� ��������. (JSP) - addresult.jsp�� 24line�� ��������� �����ϵ���!
		//�ڡڡ� ��û�Ƿ�(forward) //�񼭿���. ��û�� �Ƿ���
		request.setAttribute("result", result); //Ư����ü�� ���� ������ ���� '��ü���ε�' �ڡڡڡڡڡ�
		RequestDispatcher rd = request.getRequestDispatcher("addresult.jsp"); //get..~ ��û�� ��ü ����
		rd.forward(request, response);
	
	}

}
