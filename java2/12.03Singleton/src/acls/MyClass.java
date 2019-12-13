package acls;

import single.Singleton;

public class MyClass {
	private int myNum;
	private String myName; //성춘향 넘겨받을려고하는 변수선언해야함
	public MyClass() {
		myNum =333;
		//123이란 숫자를 you클래스에 넘겨줄려면?get/set말고 singleton 사용
		
		Singleton single = Singleton.getInstance(); //getinstance에서 싱글턴클래스가 생성되고, 첫번째를 넘겨받음 
		single.num = myNum;
		//싱글턴의 변수에 마이클래스의 넘버를 넣어줌
		
		
	}
	/*
	public int getMyNum() { //getter만 필요함, you클래스에서는 setter만
		return myNum;
	}
	*/
	
	//성춘향 넘겨받을려고하는 부분
	public void MyMethod() {
		Singleton si = Singleton.getInstance();
		
		myName = si.name;
		
		System.out.println("myName =" + myName);
	}
}
