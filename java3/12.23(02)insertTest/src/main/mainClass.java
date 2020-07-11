package main;

import jdbc.JdbcTest;

public class mainClass {

	public static void main(String[] args) {
		JdbcTest jt = new JdbcTest(); //출력결과: Driver Loading Success!
		
		int count = jt.Insert("bbb", "일지매", 21); //제대로 추가됬는지 확인하기 위해 count로 return
		if(count > 0 ) {
			System.out.println("정상적으로 추가되었습니다.");
		}
		
		
		
		
	}

}
