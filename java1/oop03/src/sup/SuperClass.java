package sup;

//부모클래스
public class SuperClass { //부모클래스는   extends Object이 숨겨져있음
	//멤버변수
	private String pri_name; //접근금지 (자식접근안됨)//getter,setter만들면 외부에서도가능 자식클래스도가능
	public String pub_name;  //누구나 접근 가능
	protected String pro_name;//자식클래스에서만 접근허용
	
	public SuperClass() { //생성자
		
	}
	
	
	
	public String getPri_name() {
		return pri_name;
	}



	public void setPri_name(String pri_name) {
		this.pri_name = pri_name;
	}



	public void Super_method() {
		System.out.println("SuperClass Super_method()");
	}

}
