package kr.mem.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mem.model.MemberDAO;
import kr.mem.model.MemberVO;
import kr.mem.pojo.Controller;
import kr.mem.pojo.MemberDeleteController;
import kr.mem.pojo.MemberInsertController;
import kr.mem.pojo.MemberInsertFormController;
import kr.mem.pojo.MemberListController;
public class MemberFrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		// 1. � ��û���� �ľ��ϴ� �۾� ==> *.do (delete.do���� insert.do���� ���� �Ǵ��ϴ� �۾�)
		String reqUrl = request.getRequestURI();
//		System.out.println(reqUrl);							//--> /mvc1/insert.do
		String ctxPath = request.getContextPath();			
//		System.out.println(ctxPath);						//--> /mvc1
		//Ŭ���̾�Ʈ�� ��û�� ���
		String command = reqUrl.substring(ctxPath.length());
		System.out.println(command);
		
		//�� ��û�� ���� ó�� �ϱ�(='�б� �۾�')
		Controller controller = null;
//		MemberDAO dao = new MemberDAO();
		String nextView = null;
		HandlerMapping mappings = new HandlerMapping();
		controller = mappings.getController(command);
		nextView=controller.requestHandle(request, response);
		//�ڵ鷯 (Handler Mapping)
		// /list.do �̷���û---->MemberListController    ������ ����
		// /insert.do	   --->MemberInsertController 
		// /insertForm.do  --->MemberInsertFormController
		// /delete.do 	   --->MemberDeleteController
		/*
		if(command.equals("/list.do")) {
			 controller = new MemberListController();
			 nextView = controller.requestHandle(request, response);
		} else if(command.equals("/insert.do")) {
			controller = new MemberInsertController();
			nextView = controller.requestHandle(request, response);
		} else if(command.equals("/insertForm.do")) {
			controller=new MemberInsertFormController();
			nextView = controller.requestHandle(request, response);
		} else if(command.equals("/delete.do")) {
			controller = new MemberDeleteController();
			nextView = controller.requestHandle(request, response);
		}
		*/
		//------------------------------------------- �ǹ����� �ȳ�����?????????????? ȥ�� ������ ���ϰ� �Ͻðڴ�?
		// ^_^ 
		//View �������� �����ϴ� �κ�
		if(nextView!=null) {
			if(nextView.indexOf("redirect:")!=-1) {	//nextView�� ""�� ���ڿ� ã�Ƽ� ������ -1. ������ ���ڳ���
				String[] sp = nextView.split(":");  //sp[0]:sp[1]
				response.sendRedirect(sp[1]);		//:O
			} else { 	//������ forwarding
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/"+nextView);
				rd.forward(request, response);
			}
		}
		
	}

}



//if(command.equals("/list.do")) {
//	 controller = new MemberListController();
//	 nextView = controller.requestHandle(request, response);
//	 RequestDispatcher rd = request.getRequestDispatcher(nextView); //forwarding
//	 rd.forward(request,response);
////	ArrayList<MemberVO> list = dao.memberAllList();
////	// member/memberList.jsp
////	request.setAttribute("list", list);
////   RequestDispatcher rd = request.getRequestDispatcher("member/memberList.jsp");
////   rd.forward(request, response);
//} else if(command.equals("/insert.do")) {
//	controller = new MemberInsertController();
//	nextView = controller.requestHandle(request, response);
//	response.sendRedirect(nextView);
////	String name = request.getParameter("name");
////	String phone = request.getParameter("phone");
////	String addr = request.getParameter("addr");
////	
////	MemberVO vo = new MemberVO();
////    vo.setName(name);
////    vo.setPhone(phone);
////    vo.setAddr(addr);
////   
////    int cnt = dao.memberInsert(vo);
////    if (cnt>0) {
////   	 response.sendRedirect("/mvc1/list.do");
////    } else {
////   	 throw new ServletException("error");
////    }
//} else if(command.equals("/insertForm.do")) {
//	controller=new MemberInsertFormController();
//	nextView = controller.requestHandle(request, response);
//	RequestDispatcher rd = request.getRequestDispatcher(nextView); //forwarding
//	rd.forward(request,response);
//////	response.sendRedirect("member/member.html");
////	RequestDispatcher rd = request.getRequestDispatcher("member/member.html");
////	rd.forward(request, response);
//} else if(command.equals("/delete.do")) {
//	controller = new MemberDeleteController();
//	nextView = controller.requestHandle(request, response);
//	response.sendRedirect(nextView);
////	int num = Integer.parseInt(request.getParameter("num"));
////   int cnt = dao.memberDelete(num);
////   if(cnt>0) {
////   	response.sendRedirect("/mvc1/list.do");
////   } else {
////       throw new ServletException("error");
////   }
//}
