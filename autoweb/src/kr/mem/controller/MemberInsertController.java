package kr.mem.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.model.MemberDAO;
import kr.model.MemberVO;

@WebServlet("/insert")
public class MemberInsertController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("euc-kr");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");

		
		// Model�� ����(DAO�� ����!_Data Access Object)
		MemberVO vo = new MemberVO(name, phone, addr);
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberInsert(vo);
		
		response.setContentType("text/html; charset=euc-kr");
		PrintWriter out = response.getWriter();
		if (cnt>0) {
			//����
			//out.print("ȸ������ ����");
			
			//����Ʈ�������� �ٽ� ������(������ ����Ʈ�������� �ٽ� ������: /list)
			//sendRedirect() 	()���������� url�� �ٲ���
			response.sendRedirect("/autoweb/list"); 	// 	/��������� /autoweb/list Ȥ�� �׳� list�� �����
			
		} else {
			//����
			out.print("ȸ������ ����");
		}
	
	}

}
