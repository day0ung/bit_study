package singleton;

import controller.BbsController;
import controller.MemberController;
//model1에서는 dao가 singleton, 
public class Singleton {
	
	private static Singleton s = null;
	
	public MemberController memCtrl = null; //컨트롤러는 무조건 접근할 수 있음
	//로그인한아이디값을 저장하려고 만들어논 변수 singleton에 잇어야함
	//setter/getter있어야함
	
	public BbsController bbsCtrl = null;
	private String loginID = null;
	

	private Singleton() {
		memCtrl = new MemberController();
		bbsCtrl = new BbsController();
	}
	
	public static Singleton getInstance() {
		if(s ==null) {
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
