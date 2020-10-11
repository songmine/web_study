package com.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/memberList")
public class MemberList extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//회원정보들을 JSON형태로 변환하여 사용자에게 전달하는 기능
		Gson gson = new Gson();
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
	
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		list.add(new MemberDTO("박포니1", 51, "010-1231-1111", "광주 서구"));
		list.add(new MemberDTO("박포니2", 28, "010-1432-1111", "광주 남구"));
		list.add(new MemberDTO("박포니3", 39, "010-9843-1111", "광주 동구"));
		list.add(new MemberDTO("박포니4", 45, "010-1029-1111", "광주 북구"));
		list.add(new MemberDTO("박포니5", 17, "010-1238-1111", "광주 광산구"));
		
		//Java객체 --> JSON 문자열로 변환 : toJson()
		String jsonObj = gson.toJson(list);
//		System.out.println(jsonObj);
		
		out.print(jsonObj);
	}

}
