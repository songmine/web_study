package webbasic;
//Servlet�� �⺻��� -> import 3ea, ��ӹް�, service �޼ҵ�
//Controller�� ������ �ϴ� Servlet
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class HelloServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
			
			//�����Ͻ� ����(=ó������) ...M���� ��������
			int sum=0;
			for (int i = 1; i <= 10; i++) {
				sum+=i;
			}
			
			//���������̼� ����(=����) ...V���� ��������
			PrintWriter out = res.getWriter();
			out.println("<html>");
			out.println("<body>");
			
			out.println("sum="+sum);
			
			out.println("</body>");			
			out.println("</html>");
			
	}
		
}
