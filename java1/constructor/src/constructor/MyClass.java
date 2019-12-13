package constructor;

public class MyClass {
	
	private float number;
	
	public MyClass() { //기본생성자
		number = 1.23F;
		System.out.println("MyClass MyClass()");
	}
	
	public MyClass(int n) {
		System.out.println("MyClass MyClass(int n)");
	}
	
	public MyClass(int n, char c) {
		System.out.println("MyClass MyClass(int n, char c)");
	}
	
	public MyClass(float _number) {
		number = _number; //생성자가 호출되는동시에 멤버변수값이 타고들어와서 멤버변수 까지 들어옴,초기값을설저하고 싶을때 많이씀
	}
	
	public void setNumber(float _number) {
		number = _number;
	}
	public float getNumber() {
		return number;
	}

}