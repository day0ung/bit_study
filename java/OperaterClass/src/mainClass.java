
public class mainClass {
	public static void main(String[] args) {
		//TODO : 맨 위 todo는 제목을적어놓고 어딧는지 찾는데 쓰임
		/*
		  operator: 연산자
		  int a, b;
		  a = 1;
		  b = a;
		  
		  + - * %
		 
		 */
		int num1, num2;
		int result;
		
		num1 = 9;
		num2 = 2;
		//2+3 =
		//TODO : 사칙연산
		/*
		result = num1 +num2;
		System.out.println(num1+"+"+ num2+ "="+"result = " +result);
		result = num1 -num2;
		System.out.println(num1+"-"+ num2+ "="+"result = " +result);
		result = num1 *num2;
		System.out.println(num1+"*"+ num2+ "="+"result = " +result);
		result = num1 /num2; //몫을구함
		System.out.println(num1+"/"+ num2+ "="+"result = " +result);
		/**/  //이렇게하면 위에것만 지우면됨
		
		// %
		//나눈 나머지
		result = num1 %num2; //나머지를구함
		System.out.println(num1+"%"+ num2+ "="+"result = " +result);
		
		num1 = num1 +1;
		num1 += 1;
		
		// 증가연산increment, 증감연산decrement
		num1++;
		++num1;
		System.out.println("num1 =" +num1);
		
		num1--;
		--num1;
		System.out.println("num1= "+num1);
		//주의점
		int a, b;
		a = 1;
	//	a++;
	//	b = a;
		
	//	b =a++; >> b가 1이나오지만		
	//	b =++a; >> 2가나옴
		b =(a++); //1이나옴
		System.out.println("b ="+b);
	}

}