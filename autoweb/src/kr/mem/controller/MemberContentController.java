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
		// eg./content?num=10 이런 값이 넘어오겠지
		int num = Integer.parseInt(request.getParameter("num"));
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.memberContent(num);
		
		// JSP(View)
		request.setAttribute("vo", vo); //객체바인딩
		RequestDispatcher rd = request.getRequestDispatcher("memberContent.jsp");
		rd.forward(request, response);
	}

}

//		
//		response.setContentType("text/html; charset=euc-kr");
//		PrintWriter out = response.getWriter();
//		if(vo!=null) { //정보가 있다면
//			out.print("<html>");
//			out.print("<body>");
//			
//			out.print("<form action='/autoweb/update' method='post'>");
//			out.print("<input type='hidden'/ name='num' value='"+vo.getNum()+"'>");
//			out.print("<table>");
//			out.print("<tr>");
//				out.print("<td>번호</td>");
//				out.print("<td>"+vo.getNum()+"</td>");
//			out.print("</tr>");
//			out.print("<tr>");
//				out.print("<td>이름</td>");
//				out.print("<td>"+vo.getName()+"</td>");
//			out.print("</tr>");
//			out.print("<tr>");
//				out.print("<td>전화번호</td>");
//				out.print("<td><input type='text' name='phone' value='"+vo.getPhone()+"'></td>");
//			out.print("</tr>");
//			out.print("<tr>");
//				out.print("<td>주소</td>");
//				out.print("<td><input type='text' name='addr' value='"+vo.getAddr()+"' size='50'></td>");
//			out.print("</tr>");
//		
//			out.print("<tr>");
//				out.print("<td colspan='2' align='center'>");
//				out.print("<input type='submit' value='수정하기'/>");
//				out.print("<input type='reset' value='취소'/>");
//				out.print("[<a href='/autoweb/list'>리스트</a>]");
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
//			out.print("일치하는 회원이 없습니다.");
//		}