package singleton;

import controller.LoginController;

public class Singleton {
	private static Singleton dao = new Singleton();
	public LoginController loginController =  new LoginController();
	
	public Singleton() {
		
	}
	
	public static Singleton getInstance() {
		return dao;
	}
}
