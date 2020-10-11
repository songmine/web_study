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
		
		request.setCharacterEncoding("utf-8"); //일반적 utf-8 (어제는 serialize로 인코딩된 상태에서 euc-kr로 한번더 인코딩해서 안떴던 것)_다시 utf-8로 돌려줬던거임
		int num = Integer.parseInt(request.getParameter("num")); 
		String phone = request.getParameter("phone"); 
		String addr = request.getParameter("addr"); 
		
		//vo로 내가 원하는 3가지만 묶어줬음(DB쪽은 이미 업데이트 되어있)
		MemberVO vo = new MemberVO();
		vo.setNum(num);
		vo.setPhone(phone);
		vo.setAddr(addr);
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberUpdate(vo);
		
		
		
	
	}

}
