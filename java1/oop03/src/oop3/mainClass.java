package oop3;

import child.ChildClass;
import sup.SuperClass;

//상속성
public class mainClass {
	public static void main(String[] args) {
		//생성
		ChildClass cc = new ChildClass();
		
		cc.Super_method(); //슈퍼클래스에서 상속받았단이야기(오버라이드됨, child Class)
		cc.Child_func();
		cc.pub_name ="aaa";
	//	cc.pro_name = "bbb"; //같은패키지안에서는가능, 자식클래스에서는 허용가능한데 외부(main)에서는안됨
		
		SuperClass sc = new SuperClass();
		sc.Super_method();
		//sc.Child_func(); //호출안됨, 부모클래스에서 자색클래스는 사용불가 
	}

}
