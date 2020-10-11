package kr.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.model.MemberDAO;
import kr.model.MemberVO;

@WebServlet("/ajaxinsert")
public class AjaxInsertController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");
		double lat = Double.parseDouble(request.getParameter("lat"));
		double lng = Double.parseDouble(request.getParameter("lng"));
		// Model과 연동(DAO와 연동!_Data Access Object)
		MemberVO vo = new MemberVO(name, phone, addr);
		vo.setLat(lat);
		vo.setLng(lng);
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberInsert(vo);
		
	}

}
