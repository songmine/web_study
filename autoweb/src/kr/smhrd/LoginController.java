package kr.smhrd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class LoginController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//폼에서 넘어온 formParameter정보를 얻는 작업
		request.setCharacterEncoding("euc-kr");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String[] subject = request.getParameterValues("subject");
	
		//응답코드 작성하기
		response.setContentType("text/html; charset=euc-kr");
		PrintWriter out = response.getWriter();
		String html = "<html>";
		html+="<body>";
		html+="아이디"+user_id;
		html+="<br/>";
		html+="패스워드:"+user_pw;
		html+="<br/>";
//		for(String str : subject) {
//			  html+="선택한 과목:"+str;
//			  html+="<br/>";
//			}
		for (int i = 0; i < subject.length; i++) {
			html+="선택한 과목:"+subject[i];
			html+="<br/>";
		}
		html+="</html>";
		out.print(html);
		
		
	}

}
