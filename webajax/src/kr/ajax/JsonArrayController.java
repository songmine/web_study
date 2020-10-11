package kr.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.model.MemberDAO;
import kr.model.MemberVO;

@WebServlet("/json")
public class JsonArrayController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> list = dao.memberAllList();
		// ->JSON-Array º¯°æ
		Gson g= new Gson();
		String json = g.toJson(list);
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.print(json);
	
	
	}

}
