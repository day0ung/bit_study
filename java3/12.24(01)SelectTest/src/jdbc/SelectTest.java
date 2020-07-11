package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.UserDto;

public class SelectTest {
	// excuteUpdate >> insert,delete,update에 쓰임(data가 변경되는것
	// excuteQuery >>select
	
	
	// 1개의 데이터(row)만을 취득
	public UserDto search(String id) { // id로 검색
		String sql = " SELECT ID, NAME, AGE, JOINDATE " 
				   + " FROM USERDTO " 
				   + " WHERE ID = '" + id + "'";

		Connection conn = DBConnection.getConnection();
		PreparedStatement psmt = null; 
		ResultSet rs = null;
		UserDto dto = null; // userdto를 리턴값으로 넘겨주기 위해서

		// 확인
		System.out.println("sql: " + sql);

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(); // executeQuery 리턴값을 갖고 있음 result set(결과를 보여줌)

			if (rs.next()) { // 쿼리문(sql)을 집어넣었을때 rs에 데이터가 있는 경우

				// db에서 받아오는 부분
				String _id = rs.getString("id"); // id >> sql에 있는 컬럼명, sql에 있는 것과 매치가 되어야함
				String _name = rs.getString("name");
				int _age = rs.getInt("age");
				String _joindate = rs.getString("joindate");

				// dto에 데이터가 넘어옴
				dto = new UserDto(_id, _name, _age, _joindate);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}

		return dto;
	}
	
	//1개의 데이터(row)만을 취득 다른방법
	public UserDto select(String id) {
		String sql = " SELECT ID, NAME, AGE, JOINDATE "
				+ " FROM USERDTO "
				+ " WHERE ID = ? ";
		
		//conn을 통해서 psmt를 생성하고 psmt를 통해서 rs를 얻어옴
		Connection conn = DBConnection.getConnection(); //데이터 연결해주는 instance ==conn
		PreparedStatement psmt = null;
		ResultSet rs = null; 
		
		UserDto dto = null;
		
		try {
			psmt = conn.prepareStatement(sql);
			
			//이부분이 다름
			
			//집어넣어야 할 값이 String임
			
			//psmt.setString(parameterIndex, x); //parameterIndex db는 0부터 시작하지 않음 ,  x >>매개변수를 통해서 들어온 id값
			psmt.setString(1, id); //위 쿼리문의 WHERE ID = ? <<물음표 에 대입된다 
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new UserDto();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setJoindate(rs.getString("joindate"));
				
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, rs);
		}
		return dto;
	}
	


	// 데이터 전부를 취득(데이터 다수의 데이터 취득 List형태가 되어야함
	public List<UserDto> getUserList() {
		
		//query문
		String sql = " SELECT ID, NAME, AGE, JOINDATE "
				+ " FROM USERDTO ";
		
		//값을 가져오기위해서 위해서는 connection - preparedStatement - resultSet 연결해서 데이터를 가져옴.
		
		//가독성이 좋지않아서 선언만해놓음
		Connection conn =null; 
		PreparedStatement psmt = null;
		ResultSet rs = null; 
		
		//list넘겨주기 위해 list생성
		List<UserDto> list = new ArrayList<UserDto>();
		
		//확인용
		System.out.println("sql: " + sql);
		
		//선언해놓은것을 셋팅함
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			//데이터가 2개 이상이면 while써야함
			while(rs.next()) { // rs.next = 데이터가 있을때데이터가 있을때 까지 loop돌림
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String joindate = rs.getString("joindate");
				
				//데이터를 list에 넣는 작엄
				list.add(new UserDto(id, name, age, joindate));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, rs);
		}
		return list;
	}
}
