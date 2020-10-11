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

		
		// Model과 연동(DAO와 연동!_Data Access Object)
		MemberVO vo = new MemberVO(name, phone, addr);
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberInsert(vo);
		
		response.setContentType("text/html; charset=euc-kr");
		PrintWriter out = response.getWriter();
		if (cnt>0) {
			//성공
			//out.print("회원가입 성공");
			
			//리스트페이지로 다시 보내기(응답을 리스트페이지를 다시 보내기: /list)
			//sendRedirect() 	()의페이지로 url을 바꿔줌
			response.sendRedirect("/autoweb/list"); 	// 	/쓰고싶으면 /autoweb/list 혹은 그냥 list만 써야함
			
		} else {
			//실패
			out.print("회원가입 실패");
		}
	
	}

}
