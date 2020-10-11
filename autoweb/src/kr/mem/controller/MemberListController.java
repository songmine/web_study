package kr.mem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.model.MemberDAO;
import kr.model.MemberVO;

@WebServlet("/list")
public class MemberListController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ü ����Ʈ�� ���(���ִ� ����)
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> list = dao.memberAllList();
		
		// JSP(View)
		request.setAttribute("list", list); //��ü���ε�
		RequestDispatcher rd = request.getRequestDispatcher("memberList.jsp");
		rd.forward(request, response);
	
	}

}

//		response.setContentType("text/html; charset=euc-kr");
//		PrintWriter out = response.getWriter();
//		out.print("<html>");
//		out.print("<body>");
//		out.print("<table border='1'>");
//		out.print("<tr>");
//			out.print("<td>��ȣ</td>");
//			out.print("<td>�̸�</td>");
//			out.print("<td>��ȭ��ȣ</td>");
//			out.print("<td>�ּ�</td>");
//			out.print("<td>����</td>");
//			out.print("<td>�浵</td>");
//			out.print("<td>����</td>");
//		out.print("</tr>");
//		for (MemberVO vo : list) {
//			out.print("<tr>");
//			out.print("<td>"+vo.getNum()+"</td>");
//			out.print("<td><a href='/autoweb/content?num="+vo.getNum()+"'>"+vo.getName()+"</a></td>");
//			out.print("<td>"+vo.getPhone()+"</td>");
//			out.print("<td>"+vo.getAddr()+"</td>");
//			out.print("<td>"+vo.getLat()+"</td>");
//			out.print("<td>"+vo.getLng()+"</td>");
//			out.print("<td><a href='/autoweb/delete?num="+vo.getNum()+"'>����</a></td>");
//			out.print("</tr>");
//		}
//		out.print("<tr>");
//		out.print("<td colspan='7' align='right'>");
//		out.print("<a href='member/member.html'>ȸ������</a>");
//		out.print("</td>");
//		out.print("</tr>");
//		out.print("</table>");
//		out.print("</body>");
//		out.print("</html>");
