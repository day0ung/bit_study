package work1;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		//편의점
		/*
		 	입력
		  	지불금액: 3230원
		  	money: 10000원
		  	
		  	거스름돈: 
		  	5000원 -> ?장
		  	1000원 -> ?장
		  	500원 -> ?개
		  	100원 -> ?개
		  	50원 -> ?개
		  	10원 -> ?개
		  	
		  	결과: ????원
		 */
		//변수선언 
		int price; //지불금액
		int myMoney; //계산 금액
		int changeMoney; //거스름돈
		
		int m5000;
		int m1000;
		int m500;
		int m100;
		int m50;
		int m10;
		//입력
		price = 2310;
		myMoney = 10000;
		
		//연산처리
		changeMoney = myMoney - price;
		
		m5000 =changeMoney / 5000;
		m1000 =(changeMoney % 5000)/1000;
		m500 =(changeMoney%1000) / 500;
		m100 =(changeMoney%500) /100;
		m50 =(changeMoney%100) / 50;
		m10 =(changeMoney%50) /10;
		//결과
		System.out.println("거스름돈: "+ changeMoney);
		System.out.println("5000원권: "+ m5000+"장");
		System.out.println("1000원권: "+ m1000+"장");
		System.out.println("500원권: "+ m500+"개");
		System.out.println("100원권: "+ m100+"개");
		System.out.println("50원권: "+ m50+"개");
		System.out.println("10원권: "+ m10+"개");
		
		
//		Scanner scan  = new Scanner(System.in);
//		int money = 10000;
//		System.out.println("지불금액을 입력하세요");
//		int a = scan.nextInt();
//		System.out.println("=====거스릅돈=====");
//		System.out.println("5000원: "+(money - a)/5000 +"장");
//		System.out.println("1000원: "+(((money - a)%5000)/1000) +"장");
//		System.out.println("500원: "+(((money - a)%5000)%1000)/500 +"개");
//		System.out.println("100원: "+(((money - a)%5000)%1000%500)/100 +"개");
//		System.out.println("50원: "+(((money - a)%5000)%1000%500%100)/50 +"개");
//		System.out.println("10원: "+(((money - a)%5000)%1000%500%100%50)/10 +"개");
//		System.out.println("결과: "+ (money-a)+"원");
//		
		
		//swap == 교환 sorting(정렬)  1 9 3 8 4 6 ->오름차순정렬 1 3 5 6 8 9
		//a,b
		//a =1, b =2; -> b = 1, a = 2;
		//why? 나중에 배울거중에 오름차순정렬하려는것에 교환이 필요함
		int a, b;
		int temp; //저장공간 == buffer
		a = 11;
		b = 22;
		
		temp = a;
		a = b;  //b의값을 a에 저장
		b = temp;
		//b = a; // 이렇게하면 22라는 값이 사라짐 특정저장공간이 필요함

		
	}

}
