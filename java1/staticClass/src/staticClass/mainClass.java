package staticClass;

public class mainClass {
	public static void main(String[] args) {
		
		//MyClass cls = new MyClass(); //클래스사용하려면 동적할당
		//cls = instance
		
		MyClass cls = new MyClass(12);
	
    //  메인클래스도 불러올수 있음
	//	mainClass mcls = new mainClass();
	//	mcls.func();
	}
	
	public void func() {
		System.out.println("mainClass func()");
	}
}
