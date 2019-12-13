package abstractClass;

public abstract class AbstractClass {
	//멤버변수선언가능
	private int number;
	
	public void method() {
		System.out.println("AbstractClaass method()");
	}
	
	//추상메소드, 상속받은곳에서 알아서하라는 뜻, 
	
	public abstract void abstractMethod(); 

}
