package main;

import java.util.List;

import db.DBConnection;
import dto.UserDto;
import jdbc.SelectTest;

public class mainClass {
	public static void main(String[] args) {
		DBConnection.initConnection(); //실행안하면 exception나옴
		
		SelectTest st = new SelectTest();
		//statement사용
		String id = "ccc";
		UserDto dto = st.search(id);
		if(dto != null) {
			System.out.println(dto.toString());
		}else {
			System.out.println("데이터를 찾을 수 없습니다.");
		}
		
		//2번째 만든 select실행시키기 preparedstatement사용
		id = "aaa";
		dto = st.select(id);
		if(dto != null) {
			System.out.println(dto.toString());
		}else {
			System.out.println("데이터를 찾을 수 업습니다.");
		}
		
		//list얻어오려면 받아줄 리스트 필요
		List<UserDto> list = st.getUserList();
		
		//데이터 뿌려주기
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
	}
}
