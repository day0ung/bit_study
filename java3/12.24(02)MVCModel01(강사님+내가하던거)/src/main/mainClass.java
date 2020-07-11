package main;

import db.DBConnection;
import dto.BbsDto;
import javabean.BbsDao;
import view.loginView;

public class mainClass {

	public static void main(String[] args) {
		DBConnection.initConnection();		
		
		new loginView();
		
	
	}

}
