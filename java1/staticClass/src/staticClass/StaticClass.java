package staticClass;

public class StaticClass {
	
	private int number;  // instance변수
	public static int staticNumber; //class 변수
	/*
	 * 
	 *   메모리의영역
	 * stack ==local  
	 * heap == new(동적할당) 
	 * static == 정적- 메모리에상주함, 프로그램시작하면 자동으로 잡힘, 값을 계속유지함
	 * sys
	 */
	
	//블록이시작하면  stack영역이 시작함 
	//int i ; //변수i 는 {에서 시작해서 }에서 끝남, 지역변수i s
	public StaticClass() { 
		
	}
	public void method() {
		staticNumber++;
	}

}
