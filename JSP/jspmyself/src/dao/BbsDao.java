package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.BbsDto;
import oracle.jdbc.proxy.annotation.Pre;

public class BbsDao {
	private static BbsDao dao = new BbsDao();
	
	private BbsDao() {
		//initconection안해도됨
	}
	
	public static BbsDao getInstance() {
		return dao;
	}
	
	//글쓰기 위한 함수
	public boolean writeBbs(BbsDto bbs) {
		String sql = " INSERT INTO BBS "
					+ " (SEQ, ID, "
					+ " REF, STEP, DEPTH, "
					+ " TITLE, CONTENT, WDATE, "
					+ " DEL, READCOUNT) "
					+ " VALUES(SEQ_BBS.NEXTVAL, ?, "
					+ "    (SELECT NVL(MAX(REF),0) + 1 FROM BBS), " //REF = NULL ->1, REF = 1 -> 2
					//BBS테이블에서 REF중에서 제일큰값이 있을때, REF대입 그것이아니었을때=NULL일때 0
					//맨처음에 NULL이 나옴, 그래서 0이나오고 거기다가 +1을함 > 1이나옴
					//그다음 REF에 1이 제일높은값임, NULL이 아니기때문에 MAX값이 1이됨 거기에 +1 을함 > 2가 나옴
					+ " 0, 0, " //SETP,DEPTH
					+ " ?, ?, SYSDATE, "//TITLE, CONTENT, WDATE
					+ " 0, 0)";
		  
		Connection conn = null;
		PreparedStatement psmt = null;
		int count =0;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 writeBbs success");
			
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 writeBbs success");
			
			psmt.setString(1, bbs.getId());
			psmt.setString(2, bbs.getTitle());
			psmt.setString(3, bbs.getContent());
			
			count = psmt.executeUpdate();
			System.out.println("3/6 writeBbs success");
			
		} catch (SQLException e) {
			System.out.println("writeBbs fail");
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, null);
		}
		return count>0?true:false;
	}
	
	
	//게시판에 작성글 뿌려주기위한 함수
	public List<BbsDto> getBbsList(){
		String sql = " SELECT SEQ, ID, REF, STEP, DEPTH, "
								+ " TITLE, CONTENT, WDATE, "
								+ " DEL, READCOUNT "
						+ " FROM BBS "
						+ " ORDER BY REF DESC, STEP ASC "; //REF역순
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<BbsDto> list = new ArrayList<BbsDto>();
		
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getBbsList success");
			
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 getBbsList success");
			
			rs = psmt.executeQuery();
			System.out.println("3/6 getBbsList success");
			
			while(rs.next()) {
				int i = 1;
				BbsDto dto = new BbsDto(rs.getInt(i++),//seq, 
										rs.getString(i++),//id, 
										rs.getInt(i++),//ref, 
										rs.getInt(i++),//step, 
										rs.getInt(i++),//depth, 
										rs.getString(i++),//title, 
										rs.getString(i++),//content, 
										rs.getString(i++),//wdate, 
										rs.getInt(i++),//del, 
										rs.getInt(i++));//readcount)
				list.add(dto);
				System.out.println("4/6 getBbsList success");
			}
		} catch (SQLException e) {
			System.out.println("getBbsList fail");
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, rs);
		}
		return list;
	}
	
	//detail
	public BbsDto getBbs(int seq) {
		String sql = " SELECT SEQ, ID, REF, STEP, DEPTH, "
					+ " TITLE, CONTENT, WDATE, "
					+ " DEL, READCOUNT "
					+ " FROM BBS "
					+ " WHERE SEQ=? ";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		BbsDto dto = null;
		
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getBbs success");
			
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 getBbs success");
			
			psmt.setInt(1, seq);
			
			rs = psmt.executeQuery();
			System.out.println("3/6 getBbs success");
			
			if(rs.next()) {
				int i = 1;
				dto = new BbsDto(rs.getInt(i++),//seq, 
					 			rs.getString(i++),//id, 
								rs.getInt(i++),//ref, 
								rs.getInt(i++),//step, 
								rs.getInt(i++),//depth, 
								rs.getString(i++),//title, 
								rs.getString(i++),//content, 
								rs.getString(i++),//wdate, 
								rs.getInt(i++),//del, 
								rs.getInt(i++));//readcount)
			}
			System.out.println("4/6 getBbs success");
		} catch (SQLException e) {
			System.out.println("getBbs fail");
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, rs);
		}
		return dto;
	}
	
	//조회수
	public void readcount(int seq) {
		String sql = " UPDATE BBS "
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
	
	//답글함수					부모글에관한 seq 답글의 object
	public boolean answer(int seq, BbsDto bbs ) {
		//기존댓글이 있는 글에 새로운댓글을 달면 ref는 동일함, step은 +1
		
		//updqte
		String sql1 = " UPDATE BBS "
					+ " SET STEP=STEP+1 "
					//STEP+한 부분의 조건, 제목2의 댓글1, 댓글 1-1, 댓글 2는 그룹번호REF가 같음
					+ " WHERE REF=(SELECT REF FROM BBS WHERE SEQ=?) " //REF넘버 댓글1과 같은놈
					//지금들어온 SEQ넘버  (SELECT REF FROM BBX WHERE SEQ=?) " ->댓글 1에 대한 번호 보다 큰놈
					+ "  AND STEP > (SELECT STEP FROM BBS WHERE SEQ=?)"; 
		//insert
		String sql2 = " INSERT INTO BBS "
					+ " (SEQ, ID, REF, STEP, DEPTH, "
					+ " TITLE, CONTENT, WDATE, DEL, READCOUNT)	 "
					+ "	VALUES(SEQ_BBS.NEXTVAL, ?, "
					+ " (SELECT REF FROM BBS WHERE SEQ=?), " //REF그룹번호, 같은것의 조건은 SQL1에 있음 
					+ " (SELECT STEP FROM BBS WHERE SEQ=?) + 1, "//STEP 댓글1에 대한 댓글	
					+ " (SELECT DEPTH FROM BBS WHERE SEQ=?) + 1, "//DEPTH
					+ " ?, ?, SYSDATE, 0, 0) "; //TITLE,CONTETN,WDATE,DEL,READCOUNT
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			//connection을 얻어온이후에 auto commit을 꺼주어야함
			conn.setAutoCommit(false);
			System.out.println("1/6 answer success");
			
			//update
			psmt = conn.prepareStatement(sql1);			
			psmt.setInt(1, seq);
			psmt.setInt(2, seq);
			System.out.println("2/6 answer success");
			
			count = psmt.executeUpdate();
			System.out.println("3/6 answer success");
			
			//psmt 초기화
			psmt.clearParameters(); //한꺼번에 두개이상의 쿼리문을 실행하고 싶을때 
			
			
			//insert
			psmt = conn.prepareStatement(sql2);
			//id, seq,seq,seq, title, content순서로 들어감
			psmt.setString(1, bbs.getId());
			psmt.setInt(2, seq); //ref
			psmt.setInt(3, seq); //step
			psmt.setInt(4, seq); //depth
			psmt.setString(5, bbs.getTitle());
			psmt.setString(6, bbs.getContent());
			System.out.println("4/6 answer success");
			
			count = psmt.executeUpdate();
			System.out.println("5/6 answer success");
			conn.commit(); //db에 넣어라
			
		} catch (SQLException e) {
			System.out.println("answer fail");
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBClose.close(psmt, conn, null);
			System.out.println("6/6 answer success");
		}
		return count>0?true:false;
	}	
	
	//수정
	public boolean updateBbs(int seq, String title, String content) {
		String sql = " UPDATE BBS "
				+ " SET TITLE=?, CONTENT=? "
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
	
	//삭제
	public boolean deleteBbs(int seq) {
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
	
	//검색							제목,작성자,내용				검색어
	public List<BbsDto> getBbsList(String choice, String searchWord){
		String sql = " SELECT SEQ, ID, REF, STEP, DEPTH, "
				+ " TITLE, CONTENT, WDATE, "
				+ " DEL, READCOUNT "
				+ " FROM BBS ";
				
		String sqlWord = "";
		if(choice.equals("title")) {
			sqlWord = " WHERE TITLE LIKE '%" + searchWord.trim() +"%' ";
		}else if(choice.equals("writer")) { //id랑 비교해야해서, like가 안됌
			sqlWord = " WHERE ID='" + searchWord.trim() +"'";
		}else if(choice.equals("content")) {
			sqlWord = " WHERE CONTENT LIKE '%" + searchWord.trim() +"%' ";
		}
		
		sql += sqlWord;
		
		sql += " ORDER BY REF DESC, STEP ASC ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<BbsDto> list = new ArrayList<BbsDto>();
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getBbsList success");
			
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 getBbsList success");
			
			rs = psmt.executeQuery();
			System.out.println("3/6 getBbsList success");
			
			while(rs.next()) {
				int i = 1;
				BbsDto dto = new BbsDto(rs.getInt(i++),//seq, 
										rs.getString(i++),//id, 
										rs.getInt(i++),//ref, 
										rs.getInt(i++),//step, 
										rs.getInt(i++),//depth, 
										rs.getString(i++),//title, 
										rs.getString(i++),//content, 
										rs.getString(i++),//wdate, 
										rs.getInt(i++),//del, 
										rs.getInt(i++));//readcount)
				list.add(dto);
				System.out.println("4/6 getBbsList success");
			}
		} catch (SQLException e) {
			System.out.println("getBbsList fail");
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, rs);
		}
		return list;
	}
	
	
	//총글의 갯수 <페이지에 필요한 함수>
	//왜필요하냐면, 글이 13개가 올라왔을때 -> 2페이지가 있다는 것  public int getAllBb() 초반함수,
	//-- 총 글의 갯수 (왜필요? 만약 글이 13개가 올라오면 2페이지가됌 )검색후 함수
	   public int getAllBbs(String choice, String searchWord) {
	      //-- 글의 총 수 가져오기 위한 query문
	      String sql = " SELECT COUNT(*) FROM BBS ";
	      
	      String sqlWord = ""; //-- 빈문자열로. 검색어가 아무것도 입력되지 않았을때 무효처리.
	      if(choice.equals("title")) {
	         sqlWord = " WHERE TITLE LIKE '%" + searchWord.trim() + "%'";
	         
	      }else if(choice.equals("writer")) { 
	         //-- id랑 비교하기 때문에 LIKE를 쓰면 안된다.
	         sqlWord = " WHERE ID='" + searchWord.trim() + "'";
	         
	      }else if(choice.equals("content")) {
	         sqlWord = " WHERE TITLE LIKE '%" + searchWord.trim() + "%'";
	      }
	      
	      sql += sqlWord;
	      
	      Connection conn = null;
	      PreparedStatement psmt = null;
	      ResultSet rs = null;
	      
	      //-- 길이값 리턴해줄 변수
	      int len = 0;
	      
	      try {
	         conn = DBConnection.getConnection();
	         psmt = conn.prepareStatement(sql);
	         rs = psmt.executeQuery();
	         
	         if(rs.next()) {
	            len = rs.getInt(1);
	         }
	         
	      } catch (SQLException e) {
	         System.out.println("getAllBbs fail");
	         e.printStackTrace();
	         
	      } finally {
	            DBClose.close(psmt, conn, rs);
	      }
	      return len;
	   }
	
	//페이지
	 public List<BbsDto> getBbsPagingList(String choice, String searchWord, int page) {
	      /*
	          1. row 번호를 만들어줘야 함
	          2. 검색이 같이 들어가야함
	          3. 정렬
	          4. 범위설정 1 ~ 10
	          
	          
	       */
	      
	      String sql = " SELECT SEQ, ID, REF, STEP, DEPTH, "
	            + " TITLE, CONTENT, WDATE, "
	            + " DEL, READCOUNT "
	            + " FROM ";
	           sql += "(SELECT ROW_NUMBER()OVER(ORDER BY REF DESC, STEP ASC) AS RNUM, "
	                 + " SEQ, ID, REF, STEP, DEPTH, "
	                 + " TITLE, CONTENT, WDATE, "
	                 + " DEL, READCOUNT "
	                 + " FROM BBS"; 
	      
	   
	      String sqlWord = "";
	      if(choice.equals("title")) {
	         sqlWord = " WHERE TITLE LIKE '%" + searchWord.trim() + "%' ";
	      }else if(choice.equals("writer")) {
	         sqlWord = " WHERE ID='" + searchWord.trim() + "'";
	      }else if(choice.equals("content")) {
	         sqlWord = " WHERE CONTENT LIKE '%" + searchWord.trim() + "%' ";
	      }
	      sql += sqlWord;
	      
	      sql += " ORDER BY REF DESC, STEP ASC) ";
	      sql += " WHERE RNUM >= ? AND RNUM <= ? ";
	      // 여기 물음표가 start , end
	      Connection conn = null;
	      PreparedStatement psmt = null;
	      ResultSet rs = null;
	      
	      List<BbsDto> list = new ArrayList<BbsDto>();
	      int start, end;
	      // 리스트의 글의 개수 
	      start = 1 + 10 * page; // 0 이 들어오면 1(첫번째페이지가 나옴), 1 이 들어오면 11
	      end = 10 + 10 * page; // 0 이 들어오면 10 , 1이 들어오면 20
	      
	      try {
	         conn = DBConnection.getConnection();
	         System.out.println("1/6 getBbsList success");
	         
	         psmt = conn.prepareStatement(sql);
	         // 외부에서 조작하는 만큼 돌아오는게 달라짐
	         psmt.setInt(1, start);
	         psmt.setInt(2, end);
	         System.out.println("2/6 getBbsList success");
	         
	         rs = psmt.executeQuery();
	         System.out.println("3/6 getBbsList success");
	         
	         while(rs.next()) {
	            int i = 1;
	            BbsDto dto = new BbsDto(rs.getInt(i++), 
	                              rs.getString(i++), 
	                              rs.getInt(i++), 
	                              rs.getInt(i++), 
	                              rs.getInt(i++), 
	                              rs.getString(i++), 
	                              rs.getString(i++), 
	                              rs.getString(i++), 
	                              rs.getInt(i++), 
	                              rs.getInt(i++));
	            list.add(dto);
	         }
	         System.out.println("4/6 getBbsList success");
	         
	      } catch (SQLException e) {
	         System.out.println("getBbsList fail");
	         e.printStackTrace();
	      } finally {
	         DBClose.close(psmt, conn, rs);         
	      }
	      
	      return list;

	}
	
}
