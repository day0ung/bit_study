package function2;

public class mainClass {
	public static void main(String[] args) {
		
		/*
		 *  가변인수 	할당allocation
		 */
		allocParameter(2, 3, 4);
		
		allocParameter(1,2,3,4,5,6,7);
		
		alloc_Parameter("hello", 1,2,3);
	}
							
	static void allocParameter(int...ab) { // ...인수가 설정한 갯수에따라서 달라짐, 가변인수
		int sum = 0;
		for (int i = 0; i < ab.length; i++) {
			sum = sum + ab[i];
		}
		System.out.println("합계:" + sum);
	}
								//getter
	static void alloc_Parameter(String str, int...ab) { 
		//int...ab, String str ab에 에러가남,  String str, int...ab 에러안남, 가변인수는 마지막에 써줘야함
		int sum = 0;
		for (int i = 0; i < ab.length; i++) {
			sum = sum + ab[i];
		}
		System.out.println("합계:" + sum);
		
	}

}
