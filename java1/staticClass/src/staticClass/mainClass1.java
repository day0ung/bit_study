package staticClass;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class mainClass1 {
	public static void main(String[] args) {
		/*
		System.out.println("sn = "+StaticClass.staticNumber);
		StaticClass.staticNumber = 1;
		//동적할당안해도 불러올수있음
		//static변수는 선언과동시에 자동으로 e
		System.out.println("sn = "+StaticClass.staticNumber);
		
		StaticClass sc = new StaticClass();
		System.out.println("sc sn = "+sc.staticNumber);
		sc.method();//+1해주는메소드
		
		StaticClass sc1 = new StaticClass();
		System.out.println("sc1 sn = "+sc.staticNumber);
		//sc1 sn = 2 객체가 여러개 있든 한놈임, 접근하는변수는 static영역에 하나만있음
		
		//static의 장점 어디서나 호출할 수 있다.
		//instance로 호출할수도있고, 클래스명으로도 호출가능
		//전체흐름을볼때 사용
		*/
		
		/*
		StaticClass1 s = StaticClass1.getInstance(); //한곳에 다호출됨
//-----출력결과-----		
//       StaticClass1 StaticClass1()
//		StaticClass1 method()
//		StaticClass1 func()
		
		Calendar cal = new GregorianCalendar();
		Calendar cal1 = Calendar.getInstance();
		*/
		
		StaticClass1.staticMethod();
		//이안에서스태틱변수는 호출할수 있지만, 멤버메소드는 호출할수 없다
		//this를 통해서 호출해야함, static은 this접근을못한다.
		}


}
