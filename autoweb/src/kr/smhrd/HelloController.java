package kr.smhrd;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 응답하는 방법 : MIME-Type (서버가 클라이언트에게 응답하는 데이터의 유형)   *마인타입설정 무조건 해줘야함*
		response.setContentType("text/html;charset=utf-8");  //text데이터야~html형태로 되어있는거!
		// html tag
		// 응답 스트림을 얻기
		Date date = new Date();
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print(date.toString());
		out.print("</body>");
		out.print("</html>");
		
	
	}

}
