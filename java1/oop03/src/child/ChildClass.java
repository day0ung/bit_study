package child;

import sup.SuperClass;

//java 다중상속 불가
public class ChildClass extends SuperClass { //상속하려면 extends쓰고 클래스명기입
	public ChildClass() {
	
	}
	
	public void Child_func() { //메소드
		System.out.println("ChildClass Child_func()");
		
	//	pri_name =""; //에러남, 완전한 부모클래스의것 자식도접근금지
		pub_name ="";
		pro_name ="";
	}
	
	//재기입, Over Ride: 상속받은 함수를 재기입
	//override했을때 사양을 똑같이해야함, ()변수값도똑같이
	public void super_method() {
		//부모클래스를가르키는 예약어 super, 부모클래스에 접근하고싶을때 super쓰면됨
		super.Super_method();//부모클래스 의 메소드가 호출됨
		System.out.println("ChildClass Super_method()");
	}

}
