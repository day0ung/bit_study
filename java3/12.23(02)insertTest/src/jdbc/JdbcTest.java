package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {
	public JdbcTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버가 있는지 확인해주는 작업

			System.out.println("Driver Loading Success!");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection() {

		Connection conn = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.22:1521:xe", "hr", "hr"); // 실제 db랑연결 /db랑
																										// 완전히 연결된 부분
			System.out.println("DB connection Success!");
		} catch (SQLException e) { // db안켜놓으면 exception걸려서나옴
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	public int Insert(String id, String name, int age) {
		// createStatement, PreparedStatement >>두가지 함수 가 있음
		// eclips 는 자동 commit

		// query문 완성하기
		String sql = "INSERT INTO USERDTO(ID,NAME, AGE, JOINDATE) " // 문자열안쪽에서 엔터치면 +됨
				+ " VALUES('" + id + "', '" + name + "', " + age + ", SYSDATE)";

		// DB관련
		// Connection conn연결한 부분의 인스턴스(데이터를갖고있는것)
		Connection conn = this.getConnection(); // this빼도됨
		Statement stmt = null;

		int count = 0; // 데이터가 몇개 변경(update) 되었는지확인하는 변수

		System.out.println("sql: " + sql);
		try {
			stmt = conn.createStatement(); // 연결부분에대해서 상태 자체를 생성해주는것

			count = stmt.executeUpdate(sql); // statement생성해주면 실행하는것

			System.out.println("성공적으로 추가되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // finally 무조건 실행됨 //DB서버는 실시간으로 하면버티지 못하기때문에 close해줌
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;

	}
}
