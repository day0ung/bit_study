 package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import db.DBClose;
import db.DBConnection;

public class UpdateTest {
	//id를 찾아서 나이를 고치는 것
	public boolean Update(String id, int age) {
		String sql = " UPDATE USERDTO "
					+ " SET AGE = " + age + " "
					+ "WHERE ID = '" + id + "'";
		
		Connection conn = DBConnection.getConnection(); //DBconnection class에서 만든것 호출
		
		PreparedStatement stmt = null;
		int count = 0;
		
		System.out.println("sql: " +sql);
		
		try {
			stmt = conn.prepareStatement(sql);
			
			count = stmt.executeUpdate(sql);
			
			
		} catch (SQLException e) {
		
		}finally {
			
			DBClose.close(stmt, conn, null);	 //DBClose에서 만든것		
		}
		return count > 0 ? true :false; //0보다 컷을때 true, 아닐때 false
		
	}
}
