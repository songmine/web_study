package kr.mem.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.model.MemberDAO;
import kr.model.MemberVO;

@WebServlet("/content")
public class MemberContentController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// eg./content?num=10 �̷� ���� �Ѿ������
		int num = Integer.parseInt(request.getParameter("num"));
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.memberContent(num);
		
		// JSP(View)
		request.setAttribute("vo", vo); //��ü���ε�
		RequestDispatcher rd = request.getRequestDispatcher("memberContent.jsp");
		rd.forward(request, response);
	}

}

//		
//		response.setContentType("text/html; charset=euc-kr");
//		PrintWriter out = response.getWriter();
//		if(vo!=null) { //������ �ִٸ�
//			out.print("<html>");
//			out.print("<body>");
//			
//			out.print("<form action='/autoweb/update' method='post'>");
//			out.print("<input type='hidden'/ name='num' value='"+vo.getNum()+"'>");
//			out.print("<table>");
//			out.print("<tr>");
//				out.print("<td>��ȣ</td>");
//				out.print("<td>"+vo.getNum()+"</td>");
//			out.print("</tr>");
//			out.print("<tr>");
//				out.print("<td>�̸�</td>");
//				out.print("<td>"+vo.getName()+"</td>");
//			out.print("</tr>");
//			out.print("<tr>");
//				out.print("<td>��ȭ��ȣ</td>");
//				out.print("<td><input type='text' name='phone' value='"+vo.getPhone()+"'></td>");
//			out.print("</tr>");
//			out.print("<tr>");
//				out.print("<td>�ּ�</td>");
//				out.print("<td><input type='text' name='addr' value='"+vo.getAddr()+"' size='50'></td>");
//			out.print("</tr>");
//		
//			out.print("<tr>");
//				out.print("<td colspan='2' align='center'>");
//				out.print("<input type='submit' value='�����ϱ�'/>");
//				out.print("<input type='reset' value='���'/>");
//				out.print("[<a href='/autoweb/list'>����Ʈ</a>]");
//				out.print("</td>");
//			out.print("</tr>");
//			
//			out.print("</table>");
//			out.print("</form>");
//			out.print("</body>");
//			out.print("</html>");
//	
//			
//		} else {
//			out.print("��ġ�ϴ� ȸ���� �����ϴ�.");
//		}