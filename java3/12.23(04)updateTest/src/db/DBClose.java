package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBClose {
	//이코드들을 계속집어넣어줘야하기 때문에 static
	public static void close(PreparedStatement psmt, Connection conn, ResultSet rs) {
		
		try {
			if (psmt != null) {
				psmt.close();
			}
			if(conn != null) {
				conn.close();
			}
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
