package varialble;

public class mainClass {
	public static void main(String[] args) {
		/*
		  1.소스코드 
		  
		  2.compile(문자코드-> 기계어(2진수)) - library참조파일(*.jar)
		  
		  3.build == .exe(cute) 실행파일
		  
		  4.실행 
		 */
		
		/*
		 	정수(==상수)
		 	2진수 	0,1					1100 1010
		 	8진수		0~7 -> 010 -> 8		8421 8421
		 	10진수	0~9					
		 	16진수	0~9 A~F(15)			C    A
		 	
		 	변수: 특정 이름을 정하고 값을 원하는 경우 변경할 수 있는 수
		 		name   value
		 		(key    value) json
		 		AAA <- 24
		 		AAA -> 24
		 		AAA <- 12
		 		
		 		변수명은 바로 알아 볼수 있도록 변수 명을 지정한다.
		  		  
		 */
		int i;
		//변수자료형 변수;
		
		int aa;
		int num;
		int _num;
		int num_;
		int n;
		
		int studentNumber;
		int stuNum;
		int stu_num;
		// int == 예약어 
		//int int; 사용x
		//int num; 같은 변수이름안됨
		//int +num; 앞에 연산기호사용 안됨
		//int 12num; 앞에숫자안됨, 뒤에는 가능
		//int 123;
		
		/*
		   변수의 자료형
		   숫자형
		  		정수
		  		byte 	1byte  ==>8bit ->256개 -128~ 127
		  		short	2byte short int
		  		int		4byte
		  		long	8byte long int
		  			  		
		  		실수
		  		float	4byte
		  		double	8byte
		  		>>우선순위가있음, 
		   문자형
		   		문자
		   		char	2byte	character C언어 ->1byte 한글(2byte)
		   		문자열 
		   		char arrChar[] = new char[10]; -> String
		   		String -> class   wrapper class

		   true/false
		   		boolean 1byte true(1)/false(0)
		   		
		   		boolean -> boll(1) true/ false , BOOL(4) TRUE/FALSE 0 ~1100 (C언어에서)
		 */
		int number;		//4byte 짜리 영역을 잡아논것임 
		//자료형: integer
		//변수명: number
		number = 123; //대입연산자 해주지않으면 <<에러남 지역변수넘버가 초기값을가지고있지않음,
		System.out.println(number);
		number = 234;
		System.out.println(number);
		byte by  =1;
		by = 123;
		
		byte by1 =127; //선언과 동시에 값을 집어넣은것임, 128;왜 오류났냐면, 범위가 넘어서
		
		float f;
		f =123.4f; //뒤에다가 f꼭넣어야함
		System.out.println("f = "+f);
		
		double d;
		d = 1.453535435523;
		System.out.println("d = "+d);
		
		char c;
		c ='한';
		c ='A'; //ASCII(아스키 코드) 문자에 숫자가 정해져있음
		System.out.println("c ="+c);
		System.out.printf("c = %c %d",c, (int)c);  //%c는 char의 약자 (int)c강제형변환
		
		//문자열 String
		//String != 자료형이 아니다. ==class클래스임
		//Wrapper class ==자료형을 class로 만들어 놓은것
		String str;
		str = "안녕하세요";
		str = "반갑습니다";
		
		char cStr[] = new char[5];
		cStr[0] = '안';
		cStr[1] = '녕';
		cStr[2] = '하';
		
		char sCtr1[] = {'안','녕', '하', '세', '요'};
		
		boolean b;
		b = true;
		b = false;
		//b =1; 에러남, 타언어에서는 가능
		
		//escape sequence
		//\n
		//\t
		//\b >백스페이스
		//\"
		//\'
		// \\
		System.out.println("\\hello \n Java\t world \\");
		

	}


}
