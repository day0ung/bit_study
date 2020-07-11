package main;

import db.DBConnection;
import jdbc.UpdateTest;

public class mainClass {

	public static void main(String[] args) {
		DBConnection.initConnection();
		
		UpdateTest ut = new UpdateTest();
		String id = "bbb";
		int age = 23;
		
		boolean b = ut.Update(id, age);
		if(b) {
			System.out.println("성공적으로 수정되었습니다.");
		}

	}

}
