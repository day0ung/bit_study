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
	
	
	//글들을 다가져오기 위한 함수
	public List<BbsDto> getBbsList(){
		
		String sql = " SELECT SEQ, ID, TITLE, CONTENT, "
				+ " WDATE, DEL, READCOUNT "
				+ " FROM BBS "
				+ " ORDER BY WDATE DESC "; //최신글들 순으로 정렬
		
		Connection conn = null;			// DB Connection
		PreparedStatement psmt = null;	// SQL
		ResultSet rs = null;			// result
		
		List<BbsDto> list = new ArrayList<BbsDto>();
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				//생성과동시에 데이터 집어넣으면서 생성함
				BbsDto dto = new BbsDto(rs.getInt(1),//seq,
										rs.getString(2),//id, 
										rs.getString(3),//title, 
										rs.getString(4),//content, 
										rs.getString(5),//wdate, 
										rs.getInt(6),//del, 
										rs.getInt(7)//readcount
										);
				//리스트에 담기
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			//conn.rollback();
		}finally {
			DBClose.close(psmt, conn, rs);
		}
		return list;
	}
	
	
	
	
}
