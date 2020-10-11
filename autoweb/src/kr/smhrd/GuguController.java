package kr.smhrd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gugu")
public class GuguController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	request.setCharacterEncoding("euc-kr");
	//String dan = request.getParameter("dan"); "6"->6
	int dan = Integer.parseInt(request.getParameter("dan"));
	response.setContentType("text/html; charset=euc-kr");
	PrintWriter out = response.getWriter();

//	out.print("<html>");
//	out.print("<body>");
	out.println("<table border='1' width='800' align='center'>");
		out.println("<tr align='center' bgcolor='#FFFF66'>");
	    	out.println("<td colspan='2'>" +dan+ " ´Ü Ãâ·Â </td>");
	    out.println("</tr>");
	   
	    for(int i=1;i<10;i++) {
	       out.println("<tr align='center'>");
	       out.println("<td width='400'>");
	       out.println(dan+"* "+i);
	       out.println("</td>");
	       out.println("<td width='400'>");
	       out.println(i*dan);
	       out.println("</td>");
	       out.println("</tr>");
	    }
	    
    out.print("</table>");
//	out.print("</body>");
//	out.print("</html>");
	
	}

}
