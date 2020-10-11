package webbasic;
//Servlet의 기본골격 -> import 3ea, 상속받고, service 메소드
//Controller의 역할을 하는 Servlet
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class HelloServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
			
			//비지니스 로직(=처리로직) ...M으로 빠져나감
			int sum=0;
			for (int i = 1; i <= 10; i++) {
				sum+=i;
			}
			
			//프리젠테이션 로직(=응답) ...V으로 빠져나감
			PrintWriter out = res.getWriter();
			out.println("<html>");
			out.println("<body>");
			
			out.println("sum="+sum);
			
			out.println("</body>");			
			out.println("</html>");
			
	}
		
}
