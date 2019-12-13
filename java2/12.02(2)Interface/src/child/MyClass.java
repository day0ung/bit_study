package child;

import inter.Interface;

public class MyClass implements Interface {

	@Override
	public void method() {
		System.out.println("MyClass method()");
		
	}

	@Override //자식클래스에서 오버라이드
	public void func() {
		System.out.println("MyClass func()");
		
	}

}
