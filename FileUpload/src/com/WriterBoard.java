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
		
		// 이미지를 저장할 폴더 지정
		String saveDir = request.getServletContext().getRealPath("img");
		// 이미지의 최대크기 설정
		int maxSize = 5 * 1024 * 1024;
		// 이미지 파일명 인코딩 설정
		String encoding = "EUC-KR";
		
		// 파일명과 보낸 값들을 꺼낼 수 있는 MultipartRequest 객체 생성 -> 파일이 내가 지정된 경로에 저장이 된다.
		// 매개변수5개 -> request, 이미지 저장할 경로, 최대크기, 인코딩, 중복설정
		MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding, 
														new DefaultFileRenamePolicy());
		
		//client로부터 요청한 데이터는 multi를 통해 꺼낼 수 있다(제목, 작성자, 파일명, 내용)
		String title = multi.getParameter("title");
		String writer = multi.getParameter("writer");
		String fileName = multi.getFilesystemName("fileName");
		if (fileName!=null) { //파일업로드하려고 올린경우에만 처리하라는 것
			fileName = URLEncoder.encode(multi.getFilesystemName("fileName"), "EUC-KR");
		}
		String content = multi.getParameter("content");
		
		
		BoardDTO dto = new BoardDTO(title, writer, fileName, content);
		BoardDAO dao = new BoardDAO();
		int cnt = dao.upload(dto);
		
		if(cnt > 0) {
			System.out.println("업로드 성공");
		} else {
			System.out.println("업로드 실패");
		}
		
		response.sendRedirect("boardMain.jsp");
		
		
	}

}
