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

@WebServlet("/update")
public class MemberUpdateController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// num, phone, addr
		request.setCharacterEncoding("EUC-KR");
		int num = Integer.parseInt(request.getParameter("num"));
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");
		MemberVO vo = new MemberVO();
		vo.setNum(num);		//¼¼°³ ¹­¾îÁÜ
		vo.setPhone(phone);
		vo.setAddr(addr);
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberUpdate(vo);

		response.setContentType("text/html;charset=euc-kr");
	    PrintWriter out = response.getWriter();
	    
	    if(cnt>0) {
	    	response.sendRedirect("/autoweb/list");
	    } else {
	    	out.print("¼öÁ¤½ÇÆĞ");
	    }
	    
	   
	      
	}

}
