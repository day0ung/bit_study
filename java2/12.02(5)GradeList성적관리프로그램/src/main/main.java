package main;

import dao.StudentDAO;

public class main {
	public static void main(String[] args) {
		StudentDAO dao = new StudentDAO();
		
		//dao.insert();
		//dao.delete();
		//dao.allStudents();
		dao.saveData();
		
	}
}
