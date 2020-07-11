package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BbsDao;
import db.DBClose;
import db.DBConnection;
import dto.BbsDto;

public class BbsDaoImpl implements BbsDao {

	@Override
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
	
	@Override
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
			
			if(rs.next()){				
				 String id = rs.getString(1);
				String title = rs.getString(2);
				String wdate = rs.getString(3);
				String content = rs.getString(4);				
				int readcount = rs.getInt(5);
				
				dto = new BbsDto(seq, id, title, content, wdate, 0, readcount);	
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally{
			DBClose.close(psmt, conn, rs);		
		}
		return dto;
	}



	@Override
	public List<BbsDto> getFindList(String fStr, String fword) {
		
		String sql =  " SELECT SEQ, ID, TITLE "
					+ " FROM BBS "
					+ " WHERE 1=1 ";
		
		if(fword.equals("제목")) {
			sql = sql + " AND TITLE LIKE ? ";  
		}else if(fword.equals("내용")){
			sql = sql + " AND CONTENT LIKE ? ";
		}else if(fword.equals("작성자")){
			sql = sql + " AND ID = ? ";
		}
		
		sql = sql + " ORDER BY WDATE DESC ";
		
		List<BbsDto> list = new ArrayList<BbsDto>();
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		
		try {
			conn = DBConnection.getConnection();		
			psmt = conn.prepareStatement(sql);
			
			if(fword.equals("작성자")) {
				psmt.setString(1, fStr);				
			}else if(fword.equals("제목") || fword.equals("내용")){
				psmt.setString(1, "%" + fStr + "%");
			}
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				int i = 1;
				
				BbsDto dto = new BbsDto(rs.getInt(i++), 
										rs.getString(i++), 
										rs.getString(i++), 
										null, 
										null, 
										0, 
										0);
				list.add(dto);				
			}		
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);			
		}
		return list;
	}



	@Override
	public boolean writeBbs(BbsDto dto) {
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



	@Override
	public boolean bbsDelete(int seq) {
		String sql = " UPDATE BBS "
				+ " SET DEL=1 "
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



	@Override
	public boolean bbsUpdate(int seq, String title, String content) {
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

}
