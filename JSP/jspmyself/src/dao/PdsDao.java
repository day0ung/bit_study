package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.PdsDto;
//file이 날라갈때는 byte형식으로 날라감,  id,title, content는 string으로됨, 융합되서 날라가는것,  -> mutibyte전송방식으로써야함필요한것은 (cos.jar)
//file업로드시 파일이름이 중복되지않게해야해서 올린시간으로 rename해야함, myfile,txt -> rename 
//데이터 날려줬을때 무조건 POST <Get방식 절대안됨!>
public class PdsDao {
	private static PdsDao dao = new PdsDao();
	
	private PdsDao() {
	
	}
	
	public static PdsDao getInstance() {
		return dao;
	}
	
	//데이터 있는거 다뿌려주기
	public List<PdsDto> getPdsList() {
		
		String sql = " SELECT SEQ, ID, TITLE, CONTENT, FILENAME, "
					+ " READCOUNT, DOWNCOUNT, REGDATE "
					+ " FROM PDS "
					+ " ORDER BY SEQ DESC "; //최신자료가 맨위로 올라오게 
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<PdsDto> list = new ArrayList<PdsDto>();
		
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("getPdsList 1/6 success");
			
			psmt = conn.prepareStatement(sql);
			System.out.println("getPdsList 2/6 success");
			
			rs = psmt.executeQuery();
			System.out.println("getPdsList 3/6 success");
			
			while(rs.next()) {
				int i = 1;
//				PdsDto dto = new PdsDto(seq, id, title, content, filename, readcount, downcount, regdate)
				PdsDto  dto= new PdsDto(rs.getInt(i++), 
									rs.getString(i++),
									rs.getString(i++),
									rs.getString(i++),
									rs.getString(i++),
									rs.getInt(i++),
									rs.getInt(i++),
									rs.getString(i++));
				list.add(dto);
			}
			System.out.println("getPdsList 4/6 success");
		} catch (Exception e) {
			System.out.println("getPdsList fail");
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, rs);
		}
		
		return list;
	}
	
	//file 추가하기
	public boolean writePds(PdsDto pds) {
		String sql = " INSERT INTO PDS(SEQ, ID, TITLE, CONTENT, FILENAME, "
					+ " READCOUNT, DOWNCOUNT, REGDATE) "
					+ " VALUES(SEQ_PDS.NEXTVAL, ?, ?, ?, ?, "
					+ " 0, 0, SYSDATE) ";
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("wirtePds 1/6success");
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, pds.getId());
			psmt.setString(2, pds.getTitle());
			psmt.setString(3, pds.getContent());
			psmt.setString(4, pds.getFilename());
			System.out.println("wirtePds 2/6success");
			
			count = psmt.executeUpdate();
			System.out.println("wirtePds 3/6success");
		} catch (SQLException e) {
			System.out.println("wirtePds fail");
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, null);
		}
		return count >0 ? true: false;
	}
	
	//조회수 
	public void readcount(int seq) {
		String sql = " UPDATE PDS "
				+ " SET READCOUNT=READCOUNT+1 "
				+ " WHERE SEQ=? ";
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 readcount success");
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			System.out.println("2/6 readcount success");
			
			psmt.executeUpdate();
			System.out.println("3/6 readcount success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, null);
		}
	}
	/*
	SEQ NUMBER(8) PRIMARY KEY,
	ID VARCHAR2(50) NOT NULL,
	TITLE VARCHAR2(200) NOT NULL,
	CONTENT VARCHAR2(4000) NOT NULL,
	FILENAME VARCHAR2(50) NOT NULL,
	READCOUNT NUMBER(8) NOT NULL,
	DOWNCOUNT NUMBER(8) NOT NULL,
	REGDATE DATE NOT NULL
	*/
	
	//detail
	public PdsDto getPds(int seq) {
		String sql = " SELECT SEQ, ID, TITLE, CONTENT, FILENAME, "
				+ " READCOUNT, DOWNCOUNT, REGDATE "
				+ " FROM PDS "
				+ " WHERE SEQ=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		PdsDto dto = null;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getPds success");
			
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 getPds success");
			psmt.setInt(1, seq);
			
			rs = psmt.executeQuery();
			System.out.println("3/6 getPds success");
			
			if(rs.next()) {
				int i = 1;
				dto = new PdsDto(rs.getInt(i++),//seq,
								 rs.getString(i++),//id, 
								 rs.getString(i++),//title, 
								 rs.getString(i++),//content, 
								 rs.getString(i++),//filename, 
								 rs.getInt(i++),//readcount, 
								 rs.getInt(i++),//downcount, 
								 rs.getString(i++));//regdate)
			}
			System.out.println("4/6 getPds success");
		} catch (SQLException e) {
			System.out.println(" getPds fail");
			e.printStackTrace();
		}
		
		return dto;
	}
	
	//file 삭제 하기
	public boolean deletePds( int seq) {
		String sql = " DELETE "
					+ "FROM PDS "
					+ " WHERE SEQ=?";
		
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
	
	
}
