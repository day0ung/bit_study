import abstractClass.AbstractClass;
import child.MyClass;
import child.YouClass;

public class mainClass {
	public static void main(String[] args) {
		/*
		 * abstract : 추상  Class
		 * Class: 객체와의 대한 설계도
		 * 		  method의 내용이 모두 설정되어 있는 것
		 * 		  method가 정의만 되어있는 요소(추상 method)
		 * 
		 * 추상 method 를 한개이상 포함하고 있는 것.
		 * 추상 class만을 생성이 불가능하다.
		 * 추상 class를 상속한 후에 자식 class에서 정의 후에 생성이 가능하다
		 * instance로 설정은 가능
		 */
		
		//AbstractClass ac = new AbstractClass(); 
		//new AbstractClass(); 이렇게 하면 에러남
		//추상클래스만은 생성이불가능
		
		MyClass cls = new MyClass();
		cls.abstractMethod();
		cls.method();
		 
		//추상메소드는 내용물을 작성을 해놓지 않음, 추상메소드에서 필요하다면, 기능들을 구현해놓아야함
		//My클래스에서 추상메소드를 불러옴
		
		AbstractClass myCls = new MyClass();  //추상클래스 인스턴스설정, 생성은 자식클래스 
		myCls.abstractMethod();
		cls.method();
		
		AbstractClass aCls = new AbstractClass() {
			
			@Override
			public void abstractMethod() {
				System.out.println("abstractMethod() 상속안하고 정의");
				
			}
		};
		aCls.abstractMethod();
		aCls.method();
		
		
		//myclass와  youClass 중아무거나 생성을 할 수 있음
		//상속받은 클래스에서 재정의를 해서 사용할 수 있음
		AbstractClass mCls  = new MyClass();		
		AbstractClass nClas = new YouClass();
	}
}
