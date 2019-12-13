package castClass;

public class mainClass {

	public static void main(String[] args) {
		/*
		 * 우선순위(위로올라갈수록 낮은순위
		 * boolean	1byte		
		 * 
		 * byte		1byte  -128 ~127		낮음    1111 1111
		 * short	2byte						1111 1111 1111 1111
		 * int 		4byte
		 * long		8byte
		 * 
		 * float	4byte
		 * double	8byte		높음
		 * 
		 * char 	2byte
		 * String 	?
		 * 
		 * 자료형변환(자동,강제)
		 */
		//자동
		short sh =123;  //2byte
		int i ;			//4byte
		i = sh; //자동 형 변환
		System.out.println("i ="+ i);
		
		i = 2345;
		sh = (short)i;  //강제(cast)형 변환
		System.out.println("sh= "+sh);
		
		long l = 12312313131L;
		float f = l;
		System.out.println("f= "+f);
		
		double d = l;
		System.out.println("d= "+d);
		// 1.23123128E10   E*10   10 == 10승
		
		int number; //형변환세금계산할때 필요함
		double dNumber = 123000.456;
		
		number = (int)dNumber;
		System.out.println("number= "+number);
		
		int num1,num2;
		double result;
		num1 = 5;
		num2 = 2;
		
		result = (double)num1/num2;
		System.out.println("result= "+result); //result= 2.0 우리는 2.5를원함 (double)(num1/num2);이렇게하면 2.0나옴 연산처리먼저해서
		
		//1.2345e3 (e 대소문자 둘다가능)
		double f1 = 1.2345e3; //*10 *10 *10 세번한거임
		System.out.println("f1= "+f1);
		
		f1 = 123.4567e-2; // *0.1 *0.1
		System.out.println("f1= "+f1);
		
		

	}

}
