
public class mainClass {
	public static void main(String[] args) {
		MyClass cls = new MyClass();
		cls.method();
		cls.method();
		/* 출력결과
				num = 1
				number =1
				stNumber = 1
				num = 1
				number =2
				stNumber = 2
				*/
		MyClass cls1 = new MyClass();
		cls1.method();
		cls1.method();
		//instance가 달라져서 멤버변수는 다시시작함
		//static은 늘어남
		
		/* 멤버변수와 static변수의 차이점
				num = 1
				number =1
				stNumber = 3
				num = 1
				number =2
				stNumber = 4
		 */
		
		//상수 (고칠수없는수, 주로 대입할때 값을갖고올때 사용됨)
		final int NUMBER = 3; //define(C), const(C++)
		//NUMBER = 5; //에러남
		int num;
		num = NUMBER;
		
		Object /*MyClass*/ mcls = new YouClass();
		//MyClass 이거대신에 사용할 수 있는것, Object
		
		//instance를 자유롭게 쓸수 있다.
		MyClass my = (MyClass)mcls;
		YouClass yo = (YouClass)my; //my를 담을때
		
		YouClass ycl = new YouClass();				
		//MyClass my = (MyClass)ycl;  뷸가능
	}
}
//final붙이는순간 상속금지됨
/*final*/ class MyClass{
	private int number; //member 변수
	public static int stNumber; //static 변수
	
	public final void method() { //method앞에 final붙이면 오버라이딩금지
		int num = 0; //local변수(메소드안에서만돈다)
		num++;
		this.number++;
		MyClass.stNumber++;
		
		System.out.println("num = " +num); //계속 1만나옴, 
		System.out.println("number =" +number);
		System.out.println("stNumber = " + stNumber);
		
	}
}

class YouClass extends MyClass{ //final class MyClass{했기때문에 에러남
	/*
	public void method() { //final void method() 했기때문에 에러남		
	}
	*/
}
