package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBClose;
import db.DBConnection;
import dto.MemberDto;

public class MemberDao {
	private static MemberDao dao = new MemberDao();
	
	private MemberDao() {
		DBConnection.initConnection();
	}
	
	public static MemberDao getInstance() {
		return dao;
	}
	
	//회원가입
	public boolean addMember(MemberDto dto){
		String sql = " INSERT INTO MEMBER "
					+ " (ID, PWD, NAME, EMAIL, AUTH) "
					+ " VALUES(?, ?, ?, ?, 3) ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 addMember success");
			
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 addMember success");
			
			//데이터 넣기
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPwd());
			psmt.setString(3, dto.getName());
			psmt.setString(4, dto.getEmail());
			
			count = psmt.executeUpdate();
			System.out.println("3/6 addMember success");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("addMember fail");
		}finally {
			DBClose.close(psmt, conn, null);
		}
		
		return count>0?true:false;
		
	}
	
	//회원 가입 페이지 아이디확인ajax 비동기통신
	public boolean getId(String id){
		String sql = " SELECT ID FROM MEMBER "
				+ " WHERE ID=? ";
		/*
		String sql = " SELECT COUNT(*) FROM MEMBER "
					+ " WHERE ID=? "; //count를세서 1이면 있고, 0이면없다는것*/
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		boolean findid = false;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getId success");
			
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 getId success");
			
			psmt.setString(1, id.trim());
			
			rs = psmt.executeQuery();
			System.out.println("3/6 getId success");
			
			if(rs.next()) {
				//찾았다
				findid = true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("4/6 getId success");
		}finally {
			DBClose.close(psmt, conn, rs);
		}
		return findid;
		
	}
	
	//로그인하기
	public MemberDto login(MemberDto dto) {
		String sql = " SELECT ID, NAME, EMAIL, AUTH " //PWD뺀이유SESSION에 저장하기ㅜ이해
					+ " FROM MEMBER "
					+ " WHERE ID=? AND PWD=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		MemberDto mem = null;
		
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 login success");
			
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 login success");
			
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPwd());
			
			rs = psmt.executeQuery();
			System.out.println("3/6 login success");
			
			if(rs.next()) {
				int i = 1;
				String id = rs.getString(i++);
				String name = rs.getString(i++);
				String email = rs.getString(i++);
				int auth  = rs.getInt(i++);
				
				mem = new MemberDto(id, null, name, email, auth);
			}
			System.out.println("4/6 login success");
			
		} catch (SQLException e) {
	
			System.out.println("login fail");
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, rs);
		}
		return mem;
		
		
	}
}
