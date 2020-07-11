package javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.BbsDto;

public class BbsDao {

	private static BbsDao dao = new BbsDao();
	
	private BbsDao() {
	}
	
	public static BbsDao getInstance() {		
		return dao;
	}
	
	public List<BbsDto> getBbsList() {
		
		String sql = " SELECT SEQ, ID, TITLE, CONTENT, "
				+ " WDATE, DEL, READCOUNT "
				+ " FROM BBS "
				+ " ORDER BY WDATE DESC ";
		
		Connection conn = null;			// DB Connection
		PreparedStatement psmt = null;	// SQL
		ResultSet rs = null;			// result
		
		List<BbsDto> list = new ArrayList<BbsDto>();
				
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				BbsDto dto = new BbsDto(rs.getInt(1), //seq, 
										rs.getString(2), //id, 
										rs.getString(3), //title, 
										rs.getString(4), //content, 
										rs.getString(5), //wdate, 
										rs.getInt(6), //del, 
										rs.getInt(7) //readcount
						);
				list.add(dto);				
			}			
			
		} catch (SQLException e) {			
			e.printStackTrace();			
		} finally {
			DBClose.close(psmt, conn, rs);			
		}		
		
		return list;		
	}
	
	public boolean writeBBS(BbsDto dto){
		int count = 0;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = "INSERT INTO BBS(SEQ, ID, TITLE, CONTENT, WDATE, DEL, READCOUNT) "
			     	+ " VALUES(SEQ_BBS.NEXTVAL, ?, ?, ?, SYSDATE, 0, 0) ";
		
		try {
			conn = DBConnection.getConnection();			
			psmt = conn.prepareStatement(sql);			
			
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContent());
			
			count = psmt.executeUpdate();			
			
		} catch (SQLException e) {		
			e.printStackTrace();
		} finally{
			DBClose.close(psmt, conn, rs);			
		}
		
		return count>0?true:false;		
	}
		
	public BbsDto getBBS(int seq) {	
		String sql = " SELECT ID, TITLE, WDATE, CONTENT, READCOUNT "
				+ " FROM BBS "
				+ " WHERE SEQ=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		BbsDto dto = null;
		
		try {			
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);	
			
			psmt.setInt(1, seq);			
			rs = psmt.executeQuery();
			
			while(rs.next()){				
				String id = rs.getString(1); //row 1번째
				String title = rs.getString(2);
				String wdate = rs.getString(3);
				String content = rs.getString(4);				
				int readcount = rs.getInt(5);
				
				dto = new BbsDto(0, id, title, content, wdate, 0, readcount);	
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally{
			DBClose.close(psmt, conn, rs);		
		}
		return dto;
	}
	
	public void readCount(int seq) {		
		String sql=" UPDATE BBS   "
					+" SET READCOUNT=READCOUNT+1 "
					+ " WHERE SEQ=? ";
		
		Connection conn=null;
		PreparedStatement psmt=null;		
		
		try {
			conn = DBConnection.getConnection();	
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			
			psmt.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBClose.close(psmt, conn, null);	
		}
	}
	
	public boolean updateBbs(int seq, String title, String content) {
		String sql = " UPDATE BBS SET "
				+ " TITLE=?, CONTENT=? "
				+ " WHERE SEQ=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();				
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			psmt.setString(2, content);
			psmt.setInt(3, seq);			
			
			count = psmt.executeUpdate();			
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally{
			DBClose.close(psmt, conn, null);				
		}		
		
		return count>0?true:false;
	}
	
	public boolean deleteBbs(int seq) {
		String sql = " UPDATE BBS "
				+ " SET DEL=1 " //읽지못하게함 0은 위에다가 선언해놓음 0으로들어가면 읽어, 0은 읽을 수있음 , 1은 지워진상태임아니지사실은 업데이트임
				+ " WHERE SEQ=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();				
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);							
			
			count = psmt.executeUpdate();			
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally{
			DBClose.close(psmt, conn, null);				
		}		
		
		return count>0?true:false;		
	}
	
	public List<BbsDto> getSelectList(String title, String word) {
									  //	 항목                    검색어
		
		String sql = " SELECT SEQ, ID, TITLE "
					+ "	FROM BBS "
					+ " WHERE 1=1 "; //맞는조건 뒤조건은 무조건 참
		
		if(title.equals("제목")) {
			sql = sql + " AND TITLE LIKE ? ";
		}else if(title.equals("내용")) {
			sql = sql + " AND CONTENT LIKE ? ";
		}else if(title.equals("작성자")) {
			sql = sql + " AND ID = ? ";	
		} 
		
		sql = sql + " ORDER BY WDATE DESC ";
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		
		List<BbsDto> list = new ArrayList<BbsDto>();
				
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			
			if(title.equals("작성자")) {
				psmt.setString(1, word);
			}else if(title.equals("제목")||title.equals("내용")) {
				psmt.setString(1, "%" + word + "%");
			}
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				BbsDto dto = new BbsDto(rs.getInt(1), 
										rs.getString(2), 
										rs.getString(3), 
										null, 
										null, 
										0, 
										0);
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);			
		}
		return list;
	}
	
	
	
	
}









