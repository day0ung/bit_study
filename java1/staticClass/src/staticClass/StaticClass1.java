package staticClass;

public class StaticClass1 {
	public StaticClass1() {
		System.out.println("StaticClass1 StaticClass1()");
	}
	
	public void func() {
		System.out.println("StaticClass1 func()");
	}
	
	public void method() {
		System.out.println("StaticClass1 method()");
	}
	
	public static StaticClass1 getInstance() { //staitcClass1을 리턴값받음
		StaticClass1 sc = new StaticClass1();
		sc.method();
		sc.func();
		return sc;
		//하나로다묶임, 생성까지다
		
	}
	public static void staticMethod() {
		System.out.println("staticMethod() 호출");
		
		//this사용못함
	}
	

}