package kr.smhrd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.model.MyUtil;

@WebServlet("/calc")
public class CalcController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.클라이언트에서 두 개의 정수 파라메터를 받아서 [두 수 사이의 총 합]을 구하여 출력하시오
		int su1 = Integer.parseInt(request.getParameter("su1"));
		int su2 = Integer.parseInt(request.getParameter("su2"));
		
		// 2.비즈니스로직 처리 -> Model  (Servlet에서 가장 중요한것== 비즈니스로직과 프레젠테이션로직을 분리하는 것)
			//객체생성 (안하고 쓰고싶으면 MyUtil에 static 붙이고 쓰면 됨)
		MyUtil my= new MyUtil(); //import안하면 kr.model.Mytil와 같이 class fullname으로 적어야함
		int v = my.hap(su1, su2);
		response.setContentType("text/html; charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.print(v);
	}

}
