package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {

	private Connection conn;//java.sql로
	private PreparedStatement psmt;
	private ResultSet rs;
	
	
	private void getConnection() {	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //오타? oJDBC6.jar없어? 
			
			String db_url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
			String db_id = "hr";
			String db_pw = "hr";
			
			conn = DriverManager.getConnection(db_url, db_id, db_pw);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void close() {
		try {
			if(rs!=null) {
				rs.close();				
			}
			if(psmt!=null) {
				psmt.close();				
			}
			if(conn!=null) {
				conn.close();				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public int upload(BoardDTO dto) {
		int cnt = 0;
		
		getConnection();
		
		String sql = "insert into board values(num.nextval,?,?,?,?,sysdate)"; //숫자,제목,작성자,파일명?,내용,시간
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getWriter());
			psmt.setString(3, dto.getFileName());
			psmt.setString(4, dto.getContent());
			cnt = psmt.executeUpdate(); //반환값은 문장이 몇번 실행됐는가에 대한 값임(실패시:0)
			
		} catch (SQLException e) { //sql문이 잘못됐을 때에 대한 예외처리
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { //중간에 오류나도 무조건 넘어올 수(실행될 수) 있는 finally 
			close();
		}
		return cnt;
	}


	public ArrayList<BoardDTO> viewAll() {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		//jdbc를 통해
		// 게시글 모든 정보를 DTO로 묶어 (번호,제목,작성자,파일명,내용,시간) list에 담으시오
		// 게시글 모든 정보를 DTO로 묶어(번호,제목,작성자,파일명,내용,시간) list에 담으시오
		getConnection();
		
		try {
			String sql = "select * from board order by day desc";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(); //표형태로 정보를 갖고있는 resultSet (cursor개념 가지고 있는데 처음엔 열이름을 가르키고 있음)
			while(rs.next()) {
				int num = rs.getInt(1);
				String title = rs.getString(2);
				String writer = rs.getString(3);
				String fileName = rs.getString(4);
				String content = rs.getString(5);
				String day = rs.getString(6);
				BoardDTO dto = new BoardDTO(num, title, writer, fileName, content, day);
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}


	public BoardDTO viewOne(int viewNum) {
		BoardDTO dto = null;

		getConnection();
		
		try {
			String sql = "select * from board where num=?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, viewNum);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				int num = rs.getInt(1);
				String title = rs.getString(2);
				String writer = rs.getString(3);
				String fileName = rs.getString(4);
				String content = rs.getString(5);
				String day = rs.getString(6);
				dto = new BoardDTO(num, title, writer, fileName, content, day); //DTO로 return하기에 하나로 묶어줘야 하는것!
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}

}













