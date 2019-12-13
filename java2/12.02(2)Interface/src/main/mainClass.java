package main;

import child.MyClass;
import cls.Ballpen;
import cls.Pencil;
import inter.Interface;
import writer.WriteMode;

public class mainClass {
	public static void main(String[] args) {
		/*
		 * abstract Class : method +abstract method 를합해놓은것
		 * 					변수의 선언이 가능하다
		 * 					class 다중상속이 불가능
		 * 차이점, 
		 * interface : abstract method로만 이루어져있다. 선언만해놓음
		 * 				변수의 선언 불가능하다
		 * 				다중상속이 가능하다
		 */
		
		//사용법 1
		MyClass cls = new MyClass();
		cls.method();
		cls.func();
		
		//사용법 2 (인스턴스 여러개가 필요하면 이것을사용
		Interface inter = new MyClass();
		inter.method(); //오버라이딩된 메소드는 부모클래스(inter)에서 사용가능
		inter.func();
		
		//사용법 3 (인스턴스 하나만 필요할때 이걸사용
		Interface in = new Interface() {
			
			@Override
			public void method() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void func() {
				// TODO Auto-generated method stub
				
			}
		};
		//인터페이스는 공통작업을하기에 편리하다
		WriteMode wm = new Pencil();
		wm.writer(); //writer처리와 erase처리는 똑같이 들어감, 달라지는 것은 없으며 외부만 달라짐
		if(wm instanceof Pencil) {
			((Pencil)wm).erase();
		}else {
			((Ballpen)wm).erase();
		}
	}
}
