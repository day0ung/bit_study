package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static void initConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버가 있는지 확인해주는 작업

			System.out.println("Driver Loading Success!");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	public static Connection getConnection() {

		Connection conn = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.22:1521:xe", "hr", "hr"); // 실제 db랑연결
			System.out.println("DB connection Success!"); // db랑 완전히 연결된 부분
		} catch (SQLException e) { // db안켜놓으면 exception걸려서나옴
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}
}
