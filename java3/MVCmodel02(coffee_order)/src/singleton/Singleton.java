package singleton;


import controller.MemberController;
import controller.OrderController;
import dto.MenuDTO;
//model1에서는 dao가 singleton, 
public class Singleton {
	
	private static Singleton s = null;
	
	public MemberController memCtrl = null; //컨트롤러는 무조건 접근할 수 있음
	//로그인한아이디값을 저장하려고 만들어논 변수 singleton에 잇어야함
	//setter/getter있어야함
	public OrderController orderCtrl = null;
	private MenuDTO dto = null;
	private String loginID = null;
	


	private Singleton() {
		memCtrl = new MemberController();
		orderCtrl = new OrderController();
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
	
	public MenuDTO getDto() {
		return dto;
	}
	
	public void setDto(MenuDTO dto) {
		this.dto = dto;
	}
}
