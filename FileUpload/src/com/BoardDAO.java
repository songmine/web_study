package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {

	private Connection conn;//java.sql��
	private PreparedStatement psmt;
	private ResultSet rs;
	
	
	private void getConnection() {	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //��Ÿ? oJDBC6.jar����? 
			
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
		
		String sql = "insert into board values(num.nextval,?,?,?,?,sysdate)"; //����,����,�ۼ���,���ϸ�?,����,�ð�
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getWriter());
			psmt.setString(3, dto.getFileName());
			psmt.setString(4, dto.getContent());
			cnt = psmt.executeUpdate(); //��ȯ���� ������ ��� ����ƴ°��� ���� ����(���н�:0)
			
		} catch (SQLException e) { //sql���� �߸����� ���� ���� ����ó��
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { //�߰��� �������� ������ �Ѿ�� ��(����� ��) �ִ� finally 
			close();
		}
		return cnt;
	}


	public ArrayList<BoardDTO> viewAll() {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		//jdbc�� ����
		// �Խñ� ��� ������ DTO�� ���� (��ȣ,����,�ۼ���,���ϸ�,����,�ð�) list�� �����ÿ�
		// �Խñ� ��� ������ DTO�� ����(��ȣ,����,�ۼ���,���ϸ�,����,�ð�) list�� �����ÿ�
		getConnection();
		
		try {
			String sql = "select * from board order by day desc";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(); //ǥ���·� ������ �����ִ� resultSet (cursor���� ������ �ִµ� ó���� ���̸��� ����Ű�� ����)
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
				dto = new BoardDTO(num, title, writer, fileName, content, day); //DTO�� return�ϱ⿡ �ϳ��� ������� �ϴ°�!
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













