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
		//클라이언트가 서버로 요청하면 -> 클라이언트의 정보가 서버로 넘어온다. (패킷=헤더(ip세션ID)+바디)
			//request.getParameter했던게 바디에 들어있는 것
			// 헤더에는 클라이언트의 아이피주소, 세션ID(32자리.고유값)...가 들어있음
		Enumeration<String> em = request.getHeaderNames(); //여러개 받을 때 쓰는 자료형 Enumeration
		PrintWriter out =response.getWriter();
		while(em.hasMoreElements()) {				//헤더이름이있는지 없는지?
			String name = em.nextElement();			//헤더이름 가져와라(가져온 후 커서는 그 다음으로 이동됨)
			String value = request.getHeader(name); //해당헤더의 값을 뽑아와라
			//out.println(name+" : "+value);
			System.out.println(name+" : "+value);
		}
		//String ip = request.getRemoteAddr();
//		String ip = request.getRemoteHost();		//클라이언트의 아이피주소 가져와라
//		out.println("client ip : " + ip);
		request.setCharacterEncoding("euc-kr");
		// id=admin, pw=admin 일때 회원인증성공하게 해보자
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		if (id.equals("admin") && pw.equals("admin")) {
			//회원인증에 성공 -> [인증에 성공한 후]에 서비스되는 페이지로 이동(Servlet일수도 JSP일수도)
			// [main.jsp, banking.jsp]
			HttpSession session = request.getSession();
			System.out.println(session.getMaxInactiveInterval());
			System.out.println(session.getId());  //세션ID값 출력
			System.out.println(session.getCreationTime()); //세션이 만들어진 시간
			System.out.println(session.getLastAccessedTime()); //세션이 마지막으로 접속한 시간
//			request.setAttribute("aaa", "aaa");는 회원인증에서는 안된다
			session.setAttribute("id", id); //객체바인딩(session)	///다른페이지에서 로그인했는지안했는지 확인위해서
			response.sendRedirect("main.jsp");
		} else {
			//실패 --> 
			response.sendRedirect("login.html");
		}
	
		//session ID (세션? 클라이언트와 서버간 고유한 1:1 연결라인)--이걸 유지하는게 세션ID ==>이걸로 회원인증을 하는 것임
		HttpSession session = request.getSession();   //HttpSession타입
		//getSession()이 하는 일
		//1. 세션값(JSESSIONID=32자)을 가져온다
		//2. 세션ID를 생성한다. (eg.,JSESSIONID=100어쩌고저쩌고) //브라우저 변경시 변경됨
		//3. 만들어진 세션ID값을 클라이언트로 보낸다
	}

}
