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
		// 1.Ŭ���̾�Ʈ���� �� ���� ���� �Ķ���͸� �޾Ƽ� [�� �� ������ �� ��]�� ���Ͽ� ����Ͻÿ�
		int su1 = Integer.parseInt(request.getParameter("su1"));
		int su2 = Integer.parseInt(request.getParameter("su2"));
		
		// 2.����Ͻ����� ó�� -> Model  (Servlet���� ���� �߿��Ѱ�== ����Ͻ������� ���������̼Ƿ����� �и��ϴ� ��)
			//��ü���� (���ϰ� ��������� MyUtil�� static ���̰� ���� ��)
		MyUtil my= new MyUtil(); //import���ϸ� kr.model.Mytil�� ���� class fullname���� �������
		int v = my.hap(su1, su2);
		response.setContentType("text/html; charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.print(v);
	}

}
