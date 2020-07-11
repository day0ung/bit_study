package singleton;

import controller.MemberController;

public class Singleton {
	private static Singleton s = null;
	
	public MemberController memCtrl = null;
	
	private String loginID = null;
	
	private Singleton() {
		memCtrl = new MemberController();
	}
	
	public static Singleton getInstance() {
		if(s == null) {
			s = new Singleton();
		}
		return s;
	}

	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	
}
