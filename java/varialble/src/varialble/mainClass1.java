package varialble;

import java.util.Scanner; //클래스명 Scanner, String은 import안함 자주쓰는거라

public class mainClass1 {
	public static void main(String[] args) {
	//input scan == instance ==class variable(클래스변수, 객체라고도함)
	Scanner scan = new Scanner(System.in); //콘솔에서만쓰는 함수
	
	//boolean
	boolean b;
	
	System.out.print("true/false =");
	b = scan.nextBoolean();
	
	System.out.println("b = "+b);
	
	
	
	
	 //integer
	 
	int number;
	System.out.print("정수= ");
	number = scan.nextInt(); //number가 받을 값 입력한 숫자가 들어옴
	System.out.println("number = "+number);
	System.out.printf("number = %d",number); //f = format
	
	
	//double == 소수
	double d;
	System.out.println("실수 = ");
	d = scan.nextDouble();
	System.out.println("d = "+ d);
	
	
	
	// String == 문자열
	String str;
	System.out.print("str= ");
	str = scan.next(); //리턴값을 받으면서 저장시킴, 이걸써야함
	System.out.println("str = "+str);
	
	
	System.out.print("num =");
	int num = scan.nextInt(); //입력받고나서  enter치면 enter값이 밑으로내려감
	
	System.out.print("str =");
	str = scan.nextLine(); //엔터값 즉, 빈값이 들어감 쓰면안됀다..
	
	System.out.println("num = ");
	System.out.println("str =" +str);

	}
	
}
