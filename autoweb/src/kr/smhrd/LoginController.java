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
		//������ �Ѿ�� formParameter������ ��� �۾�
		request.setCharacterEncoding("euc-kr");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String[] subject = request.getParameterValues("subject");
	
		//�����ڵ� �ۼ��ϱ�
		response.setContentType("text/html; charset=euc-kr");
		PrintWriter out = response.getWriter();
		String html = "<html>";
		html+="<body>";
		html+="���̵�"+user_id;
		html+="<br/>";
		html+="�н�����:"+user_pw;
		html+="<br/>";
//		for(String str : subject) {
//			  html+="������ ����:"+str;
//			  html+="<br/>";
//			}
		for (int i = 0; i < subject.length; i++) {
			html+="������ ����:"+subject[i];
			html+="<br/>";
		}
		html+="</html>";
		out.print(html);
		
		
	}

}
