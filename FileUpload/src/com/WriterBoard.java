package com;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/WriterBoard")
public class WriterBoard extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("EUC_KR");
		
		// �̹����� ������ ���� ����
		String saveDir = request.getServletContext().getRealPath("img");
		// �̹����� �ִ�ũ�� ����
		int maxSize = 5 * 1024 * 1024;
		// �̹��� ���ϸ� ���ڵ� ����
		String encoding = "EUC-KR";
		
		// ���ϸ�� ���� ������ ���� �� �ִ� MultipartRequest ��ü ���� -> ������ ���� ������ ��ο� ������ �ȴ�.
		// �Ű�����5�� -> request, �̹��� ������ ���, �ִ�ũ��, ���ڵ�, �ߺ�����
		MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding, 
														new DefaultFileRenamePolicy());
		
		//client�κ��� ��û�� �����ʹ� multi�� ���� ���� �� �ִ�(����, �ۼ���, ���ϸ�, ����)
		String title = multi.getParameter("title");
		String writer = multi.getParameter("writer");
		String fileName = multi.getFilesystemName("fileName");
		if (fileName!=null) { //���Ͼ��ε��Ϸ��� �ø���쿡�� ó���϶�� ��
			fileName = URLEncoder.encode(multi.getFilesystemName("fileName"), "EUC-KR");
		}
		String content = multi.getParameter("content");
		
		
		BoardDTO dto = new BoardDTO(title, writer, fileName, content);
		BoardDAO dao = new BoardDAO();
		int cnt = dao.upload(dto);
		
		if(cnt > 0) {
			System.out.println("���ε� ����");
		} else {
			System.out.println("���ε� ����");
		}
		
		response.sendRedirect("boardMain.jsp");
		
		
	}

}
