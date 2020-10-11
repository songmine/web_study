package kr.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.model.MemberDAO;
import kr.model.MemberVO;

@WebServlet("/ajaxupdate")
public class AjaxUpdateController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8"); //�Ϲ��� utf-8 (������ serialize�� ���ڵ��� ���¿��� euc-kr�� �ѹ��� ���ڵ��ؼ� �ȶ��� ��)_�ٽ� utf-8�� �����������
		int num = Integer.parseInt(request.getParameter("num")); 
		String phone = request.getParameter("phone"); 
		String addr = request.getParameter("addr"); 
		
		//vo�� ���� ���ϴ� 3������ ��������(DB���� �̹� ������Ʈ �Ǿ���)
		MemberVO vo = new MemberVO();
		vo.setNum(num);
		vo.setPhone(phone);
		vo.setAddr(addr);
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberUpdate(vo);
		
		
		
	
	}

}
