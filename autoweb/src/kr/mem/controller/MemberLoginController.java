package kr.mem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/memlogin")
public class MemberLoginController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Ŭ���̾�Ʈ�� ������ ��û�ϸ� -> Ŭ���̾�Ʈ�� ������ ������ �Ѿ�´�. (��Ŷ=���(ip����ID)+�ٵ�)
			//request.getParameter�ߴ��� �ٵ� ����ִ� ��
			// ������� Ŭ���̾�Ʈ�� �������ּ�, ����ID(32�ڸ�.������)...�� �������
		Enumeration<String> em = request.getHeaderNames(); //������ ���� �� ���� �ڷ��� Enumeration
		PrintWriter out =response.getWriter();
		while(em.hasMoreElements()) {				//����̸����ִ��� ������?
			String name = em.nextElement();			//����̸� �����Ͷ�(������ �� Ŀ���� �� �������� �̵���)
			String value = request.getHeader(name); //�ش������ ���� �̾ƿͶ�
			//out.println(name+" : "+value);
			System.out.println(name+" : "+value);
		}
		//String ip = request.getRemoteAddr();
//		String ip = request.getRemoteHost();		//Ŭ���̾�Ʈ�� �������ּ� �����Ͷ�
//		out.println("client ip : " + ip);
		request.setCharacterEncoding("euc-kr");
		// id=admin, pw=admin �϶� ȸ�����������ϰ� �غ���
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		if (id.equals("admin") && pw.equals("admin")) {
			//ȸ�������� ���� -> [������ ������ ��]�� ���񽺵Ǵ� �������� �̵�(Servlet�ϼ��� JSP�ϼ���)
			// [main.jsp, banking.jsp]
			HttpSession session = request.getSession();
			System.out.println(session.getMaxInactiveInterval());
			System.out.println(session.getId());  //����ID�� ���
			System.out.println(session.getCreationTime()); //������ ������� �ð�
			System.out.println(session.getLastAccessedTime()); //������ ���������� ������ �ð�
//			request.setAttribute("aaa", "aaa");�� ȸ������������ �ȵȴ�
			session.setAttribute("id", id); //��ü���ε�(session)	///�ٸ����������� �α����ߴ������ߴ��� Ȯ�����ؼ�
			response.sendRedirect("main.jsp");
		} else {
			//���� --> 
			response.sendRedirect("login.html");
		}
	
		//session ID (����? Ŭ���̾�Ʈ�� ������ ������ 1:1 �������)--�̰� �����ϴ°� ����ID ==>�̰ɷ� ȸ�������� �ϴ� ����
		HttpSession session = request.getSession();   //HttpSessionŸ��
		//getSession()�� �ϴ� ��
		//1. ���ǰ�(JSESSIONID=32��)�� �����´�
		//2. ����ID�� �����Ѵ�. (eg.,JSESSIONID=100��¼����¼��) //������ ����� �����
		//3. ������� ����ID���� Ŭ���̾�Ʈ�� ������
	}

}
