package main;

import acls.MyClass;
import bcls.YouClass;
import ccls.HeClass;


public class mainClass {
	public static void main(String[] args) {
		/*
		  	Singleton pattern
		  	단 1개의 instance(객체) 만을 이용해서 접근하는 패턴
		 
		 */
		
		//Singleton sr = new Singleton(); 
		//에러남The constructor Singleton() is not visible 생성자가 private이여서 
		
		//myclass와 youclass는 메인클래스에서 만나야함
		MyClass mcls = new MyClass();
		YouClass ycls = new YouClass();
		HeClass hcls = new HeClass();

		//아래의경우는 두 클래스 끼리 대화를 한것임
//		int n = mcls.getMyNum(); 
//		ycls.setYouNum(n); //값을 넘겨받음
		
		ycls.method();
		
		mcls.MyMethod();
		
	}
}
