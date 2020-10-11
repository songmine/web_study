package kr.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.model.MapDAO;

@WebServlet("/ajaxmap")
public class AjaxMapController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String addr = request.getParameter("addr");

		//servlet���� ������ �浵 �޾ƿ��ִ� �Լ����� -> MapDAO��
		MapDAO dao = new MapDAO();
		String json = dao.getMaps(addr);
	    response.setContentType("text/json;charset=euc-kr"); //text���Ŀ� json����
		PrintWriter out = response.getWriter();
		out.print(json);
	
	
	
	}

}
