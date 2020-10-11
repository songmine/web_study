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

		// �����ϴ� ��� : MIME-Type (������ Ŭ���̾�Ʈ���� �����ϴ� �������� ����)   *����Ÿ�Լ��� ������ �������*
		response.setContentType("text/html;charset=utf-8");  //text�����;�~html���·� �Ǿ��ִ°�!
		// html tag
		// ���� ��Ʈ���� ���
		Date date = new Date();
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print(date.toString());
		out.print("</body>");
		out.print("</html>");
		
	
	}

}
