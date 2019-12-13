package oop4;

import child.ChildClass;

public class mainClass {
	public static void main(String[] args) {
		ChildClass cc = new ChildClass();
		//부모님걸먼저챙겨줌
		//---출력결과
//		ParentsClass ParentsClass()
//		ChildClass ChildClass()
		
		ChildClass cc1 = new ChildClass("", 245); //이숫자가 부모클래스의 변수까지 전달됨
	}

}
