package oop01;

public class mainClass {
	public static void main(String[] args) {
		/*
		 * Object Oriented Programming
		 *  	string 에서, Aspect(관점)Oriented Programming
		 * 
		 * oop는 처리중심, !=절차지향에서는 순차중심(장점: 속도)
		 * oop는 설계중요,
		 * 
		 * oop의 특징
		 * 1. 은닉성(캡슐화)
		 * 2. 상속성
		 * 3. 다형성(상속이되야 다형성이나옴)
		 * 
		 * 
		 * 클래스설계 문법(규칙)
		 * class 클래스명  
		 * {
		 *   --변수부
		 *   접근지정자(public) 변수자료형 변수명; member변수
		 *   
		 *   --메소드부 
		 *   접근지정자   자료형 메소드명(매개변수{
		 *   
		 *   }
		 * }
		 * 
		 * 변수(객체)를 선언후에 동적할당을 해야 접근가능.
		 * 
		 * class변수 -> Object(객체), instance(주체)
		 * 							실제 메모리 영역에 올라가는 변수 
		 * 클래스명 인스턴스 = new 클래스명();
		 * 
		 * 인스턴스 (참조, 접근하기위한 포인터) -> 실제영역
		 * (stack)	  					  (heap)
		 * 
		 */
		
		MyClass cls; // cls == instance >> 메모리영역에 올라가는놈은 cls임
		cls = new MyClass(); // (동적할당)
		//실제로 heap에 올라가지만, cls는 stack에 있다.
		
		//cls인스턴스를통해서 . 을 찍고 호출
		cls.c = 'A';
		cls.x = 12;
		cls.func();
		cls.method(33);
		
		//TV(한방, 홀, 내방)
		//절차지향을 했을때 메인에서 다 적어줘야 하는 경우, 인덱스로 관리함
		String name[] = new String[3];
		int channel[] = new int[3];
		boolean power[] = new boolean[3];
		
		TVclass tv1, tv2, tv3; //인스턴스로관리함
		tv1 = new TVclass();
		tv2 = new TVclass();
		tv3 = new TVclass();
		
		TVclass arrTV[] = new TVclass[3]; //이거는 변수 3개선언한것과 동일 ==TVclass tv1, tv2, tv3;
		for (int i = 0; i < arrTV.length; i++) {
			
			arrTV[i] = new TVclass();
		}
		
		arrTV[0].setChannel(11);
		//실행하면  nullexception뜸, 영역이없기때문에
		//사용하려면 객채배열도 생성해줘야함 >>arrTV[i] = new TVclass();
		
		
		
		tv1.name = "LG";//이건안됌!
		
		tv1.setName("LG"); //접근을할때는 이부분을 거쳐야함, 거치지않으면 접근을못함 = 은닉성
		tv2.setName("Samsung");
		tv3.setName("Daewoo");
		
		tv1.setPower(true);
		tv2.setPower(false);
		tv3.setPower(true);
		
		String tvname = tv1.getName(); //외부에서 얻어옴
		//변수는 접근하려면 제약을걸어줌
		//클래스는 외부에서 내부변수를 쓰기위함
	}

}

//클래스안에 클래스 선언가능, 클래스설계 
//>>실제로 메모리영역에올라가지않음, 클래스를사용하기위해서는 메인클래스나 외부클래스의 아무데서나 불러야함
class MyClass{ //이블록 안에 소스코드를집어넣을 수 없음 항상, 메소드안에서만해야한다
	//변수부(멤버)
	int x, y;
	char c;
	String str;
	//str = "hi"; -> 이거오류
	
	
	//메소드부
	void func() {
		x = 0;
		System.out.println("MyClass func()");
	}
	void method(int i) {
		str = "hello";
		x = i;
		System.out.println("Myclass method(int i)");
		System.out.println("x =" +x);
	}
	
}

class TVclass{
	//3개 데이터가 하나로 묶여짐
	String name;
	int channel;
	boolean power;
	
	void setName(String newName) {
		name = newName; //set을 통해서 멤버변수에 셋팅한것
		
	}
	String getName() { //외부에서 얻어오기위함
		return name;
	}
	
	void setChannel(int newChannel) {
		channel = newChannel;
	}
	int getChannel() {
		return channel;
	}
	
	void setPower(boolean pow) {
		power = pow;
	}
	boolean getPower() {
		return power;
	}
	
}




