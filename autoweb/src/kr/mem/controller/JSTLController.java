package kr.mem.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.model.MemberDAO;
import kr.model.MemberVO;

@WebServlet("/test")
public class JSTLController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//kr.model의 MemberDAO를 이용하여 회원목록을 가져오기
		
		//JSTL09.jsp에 포워딩하기
		MemberDAO dao = new MemberDAO();
		//ArrayList<MemberVO> list = dao.memberAllList();
		
		//request.setAttribute("list", list);
		request.setAttribute("list", dao.memberAllList());
		RequestDispatcher rd = request.getRequestDispatcher("JSTL09_.jsp");
		rd.forward(request, response); //JSTL09로 forwarding해주는 것
	
	
	}

}
