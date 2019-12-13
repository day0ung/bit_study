package staticClass;
/*class
 * 1.은닉성(캡슐화) 접근제어 private, public, protected
 * 		class내부에서 member변수와, member메소드로 처리
 * 		변수의 값을 접근하고싶은경우 getter, setter을 통해서  접근
 */

public class MyClass {
	private int number;
	private String strArr[];
	
	public MyClass() { //생성시에 자동호출 메소드, overload가능
	//	this(1); //항상맨위에 있어야함 
		//생성자가 호출이 됬을때 그다음 밑의 클래스MyClass(int number)가 호출이됨
		System.out.println("MyClass MyClass()");
		//출력결과값---------
//		MyClass MyClass(int number)
//		MyClass MyClass()
		strArr = new String[10];
	}
	
	public MyClass(int number) {
		this(); //둘중에 하나는 지워야함
		this.number = number;
		System.out.println("MyClass MyClass(int number)");
	}
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public void method() {
		System.out.println("method()");
		System.out.println("number =" +this.number);
	}

}