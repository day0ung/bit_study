package oop05;

import child.JaneClass;
import child.TomClass;
import parent.ParentClass;


public class mainClass {
	public static void main(String[] args) {
		
		TomClass tc = new TomClass();
		JaneClass jc = new JaneClass();
		
		tc.ParentMethod();
		jc.ParentMethod();
		
		// Over Ride의 목적: 하나의 instance형으로 관리를 용이하게 하기위함
		
		ParentClass p1 = new TomClass(); 
		//인스턴스는 부모클래스, 생성은 자식클래스로생성
		//호출시 자식클래스의 메소드가 호출됨
		p1.ParentMethod(); 
		//오버라이딩된 메소드가 호출됨
		//출력결과 >>TomClass ParetMethod()
		
		
		
		ParentClass p2 = new JaneClass(); 
		p2.ParentMethod();
		
		//클래스관리할때 하나로 묶어서 관리하는것이 편리함, 
		//자식클래스를하나로 묶어서 관리할 수 있다.
	
		
		//p1.func// 없음 //p1은 parent클래스만접근할수 있도록 함. 
		//인스턴스가 부모클래스로잡혀있기 때문에, 자식클래스 tom의 메소드 func에 접근할수 없다.
		
		//접근하려면?
		((TomClass)p1).func(); //p1 강제변환
		
		TomClass t = (TomClass)p1; //부모클래스에있는 인스턴스를 자식클래스형태로 강제변환
		t.func();
		
		/*
		//=================================
		TomClass tomArr[] = new TomClass[5];
		JaneClass janeArr[] = new JaneClass[5];
		
		tomArr[0] = new TomClass();
		janeArr[0] = new JaneClass();
		janeArr[1] = new JaneClass();
		
		
		ParentClass parArr[] = new ParentClass[10];
		parArr[0] = new TomClass();
		parArr[1] = new JaneClass();
		parArr[2] = new JaneClass();
		//하나로관리가됨
		 */
	}
}
