package main;

import db.DBConnection;
import singleton.Singleton;

//controller먼저만들기
public class mainClass {

	public static void main(String[] args) {
		DBConnection.initConnection();
		
		Singleton s = Singleton.getInstance();
		s.memCtrl.login();

	}

}
