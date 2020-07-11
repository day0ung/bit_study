package javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBClose;
import db.DBConnection;
import dto.MemberDto;
//DAO의 역할 DB와 connection하는 역할
// DB <-> Java
public class MemberDao {
	//어디서나 접근하기 편리하게 만들어야함 ==singleton
	private static MemberDao mem = null;
	
	//memberdao에 로그인한 아이디값(저장) //login,accountview만들고나서
	private String loginID;  //>>멤버변수
	
	private MemberDao() {
	}
	
	public static MemberDao getInstance() {
		if(mem == null) {
			mem = new MemberDao();
		}
		return mem;
	}
	//accountView의 id확인 메소드
	public boolean getId(String id) {
		String sql = " SELECT ID "
				   + " FROM MEMBER "
			       + " WHERE ID = ? ";
		
		Connection conn = null;			// DB Connection
		PreparedStatement psmt = null;	// SQL 쿼리문
		ResultSet rs = null;			// result 쿼리문들에서 데이터를 가져오기 위함
		
		boolean findid = false; //못찾았다고 가정
		
		//확인용
		System.out.println("sql:" + sql);
		
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) { //rs.next()>> rs(=data)가 있으면
				findid = true;	// 데이터가 있을 때,true로 바꿔
			}		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);			
		}
		
		return findid;
	}
	
	
	public boolean addMember(MemberDto dto) {
		//DB에 추가하는 작업을 해야함
		String sql = " INSERT INTO MEMBER(ID, PWD, NAME, EMAIL, AUTH) "
				+ " VALUES(?, ?, ?, ?, 3) ";
	
		Connection conn = null;
		PreparedStatement psmt = null;
		
		System.out.println("sql:" + sql);
		
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
		
		return count>0?true:false;
	}
	
	public MemberDto login(String id, String pwd) {
		
		String sql = " SELECT ID, NAME, EMAIL, AUTH "
					+ " FROM MEMBER "
					+ " WHERE ID=? AND PWD=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		MemberDto mem = null;
		
		try {
			conn = DBConnection.getConnection();
		
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id.trim());
			psmt.setString(2, pwd.trim());
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				String _id = rs.getString(1);	// id
				String _name = rs.getString(2);	// name
				String _email = rs.getString(3);// email
				int auth = rs.getInt(4);	// auth
				
				mem = new MemberDto(_id, null, _name, _email, auth);
			}		
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);			
		}
		return mem;
	}

	
	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	
	

}





