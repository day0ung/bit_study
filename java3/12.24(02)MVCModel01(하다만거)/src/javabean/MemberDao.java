package javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBClose;
import db.DBConnection;
import dto.MemberDto;

//DAO의 역할 DB와 connection하는 역할
//DB <->java

public class MemberDao {
	
	
	private static MemberDao mem = null;
	
	public MemberDao() {
		// TODO Auto-generated constructor stub
	}
	
	public static MemberDao getInstance() {
		if(mem == null) {
			mem = new MemberDao();
		}
		return mem;
	}
	
	//accountView의 id확인 메소드
	
	public boolean getId(String id) {
		//Query문 작성
		String sql = " SELECT ID "
				+ " FROM MEMBER "
				+ " WHERE ID = ?";
		
		//db위해서 필요한 부분
		Connection conn = null;   //DBConnection
		PreparedStatement psmt = null; //SQL 쿼리문
		ResultSet rs = null;	//쿼리문을통해서 데이터를 가져오기 위함
		
		boolean findid = false; //못찾았다고 가정
		
		//확인용
		System.out.println("sql: " +sql);
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) { //rs.next()>> rs(=data)가 있으면
				findid = true; //true로 바꿔
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, rs);
		}
		
		return findid;
	}
	
	
	public boolean addMember(MemberDto dto) {
		//DB에 추가하는 작업을 해야함
		String sql = "INSERT INTO USERDTO(ID, PWD, NAME, EMAIL, AUTH) " // 문자열안쪽에서 엔터치면 +됨
				+ " VALUES( ?, ?, ?, ?, 3)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPwd());
			psmt.setString(3, dto.getName());
			psmt.setString(4, dto.getEmail());
			
			count = psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {		
			DBClose.close(psmt, conn, null);			
		}		
		
		return  count>0?true:false;
	}
}
