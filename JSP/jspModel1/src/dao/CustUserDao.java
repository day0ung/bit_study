package dao;
//싱글턴으로 만들어놓음

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.CustUserDto;



public class CustUserDao {
	private static CustUserDao dao = null;
	
	private CustUserDao() {
		//oracle 추가하기
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static CustUserDao getInstance() {
		if(dao == null) {
			dao = new CustUserDao();
		}
		return dao;
	}
	
	
	//고객정보를 뿌려주기위한 함수 list로 사용
	public List<CustUserDto> getCustUserList() {
		String sql = " SELECT ID, NAME, ADDRESS "
				+ "		FROM CUSTUSER	"
				+ "		ORDER BY ID DESC ";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		//넘겨줄 list준비
		List<CustUserDto> list = new ArrayList<CustUserDto>();
		
		try {
			conn = getConnection(); //getConnectiondms exception이 걸려있음
			psmt = conn.prepareStatement(sql); //sql문을 상태에 넣음
			rs = psmt.executeQuery();
			
			//데이터 다얻어올려면 while 하나면 if
			while(rs.next()) {
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				String address = rs.getString("ADDRESS");
				
				//list에 넣기
				list.add(new CustUserDto(id, name, address));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn,psmt,rs);
		}
		return list;
	}
	
	
	//테이블에 고객정보추가되게하는 함수
	public boolean addCustUser(String id, String name, String address) {
		String sql = " INSERT INTO CUSTUSER(ID, NAME, ADDRESS) "
					+ " VALUES(?, ?, ?) ";
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, name);
			psmt.setString(3, address);
			
			count = psmt.executeUpdate();
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		}finally {
			close(conn, psmt, null);
		}
		return count>0?true:false;
		
	}
	
	
	//detail고객정보하나 출력하기 위한 함수
	public CustUserDto getCust(String id) {
		String sql = " SELECT ID, NAME, ADDRESS "
					+ "FROM CUSTUSER "
					+ " WHERE ID=? ";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		CustUserDto dto = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
			if( rs.next() ) {
				dto = new CustUserDto();
				dto.setId(rs.getString("ID"));
				dto.setName( rs.getString("NAME") );
				dto.setAddress( rs.getString("ADDRESS"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, psmt, rs);
		}
		return dto;
	
	}
	
	//회원정보 삭제하는 함수
	public boolean deleteCust(String id) {
		String sql = " DELETE FROM CUSTUSER "
				+ " WHERE ID=? ";
		Connection conn = null;
		PreparedStatement psmt = null;
		
		int count = 0;
		
		try {
			conn = getConnection();
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id.trim());
			
			count = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(conn, psmt, null);
		}
		return count>0?true:false;
	}
	
	//회원정보 주소 수정하는 함수
	public int CustUpdate(String id, String name, String address) {
		String sql = " UPDATE CUSTUSER "
					+ " SET NAME=?, ADDRESS=? "
					+ " WHERE ID=? ";
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		
		try {
			conn = getConnection();
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name.trim());
			psmt.setString(2, address.trim());
			psmt.setString(3, id.trim());
			
			count = psmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(conn, psmt, null);
		}
		return count;
    }
	
	

	
	
	//multdel 전체삭제하는 함수 //여러개한꺼번에지우기위해 아이디를 배열로받음
	public boolean deleteCustUsers( String ids[]) {
		String sql = " DELETE FROM CUSTUSER "
					+ " WHERE ID=? ";
		//update는 2개만필요함
		Connection conn = null;
		PreparedStatement psmt = null;
		
		int count[] = new int[ids.length];
		try {
			conn = getConnection();
			conn.setAutoCommit(false); //적용되는것을 꺼줌,
			
			psmt = conn.prepareStatement(sql);
			//데이터모으기
			for (int i = 0; i < ids.length; i++) {
				psmt.setString(1, ids[i]); //하나씩집어넣는데 데이터는 여러개
				//데이터를 계속넣으면서 축척시키는 것 같은쿼리문을반복해서 여러번사용해야할때 사용하는 코드
				psmt.addBatch();
			}
			//똑같은처리를 여러번하는것 - executeBatch
			count = psmt.executeBatch(); //return값은 배열 넣다가 문제가발생하면 익셉션발생시킴
			conn.commit(); //db에 완전히 집어넣기
		} catch (SQLException e) {		
			e.printStackTrace();
			try {
				//데이터넣다가 잘못됬을대 rollback하라는것
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			close(conn, psmt, null);
		}
		boolean isS = true;
		for (int i = 0; i < count.length; i++) {
			//결과값이 나온것은 count임 count의 length만큼 하는게 맞음
			if(count[i] != -2) { //-2는 정상종료되었다는 뜻
				 isS = false; //-2가 안나왔으면 문제가발생한거임
				 break;
			}
		}
		return isS;
	}
	
	
	//DB와 연결하기 위한 함수
	public Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";
		//db정보얻는것
		Connection conn = DriverManager.getConnection(url, user, password);
		
		return conn;
	}
	
	//close하기 위한 함수
	public void close(Connection conn, PreparedStatement psmt, ResultSet rs) {
		
			try {
				if(conn != null) {
					conn.close();
					
				}
				if(psmt !=null) {
					psmt.close();
				}
				if(rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
}
