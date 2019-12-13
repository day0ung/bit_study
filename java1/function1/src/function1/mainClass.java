package function1;

public class mainClass {
	public static void main(String[] args) {
		/*
		 *   function : 함수, 독립적(자체만으로도 사용이가능하게만듬)  C언어  - function
		 *   method : 함수, 클래스에 종속적(소속되어있음)			JAVA - class
		 * 
		 *   구성요소
		 *   들어가는 값 : 매개변수, 인수, 인자, Parameter
		 *   돌려주는 값: return 값
		 *  
		 *   //Oracle - PL(오라클언어를 함수화시킨것)
		 *   
		 *   형식 
		 *   return 값(자료형/int같은것들)   함수명( 자료형의 변수(가상인수), 자료형의 변수...(여러개가있으면 , 로 구분 ){
		 *   		처리
		 *    return 값:
		 *   }
		 *   
		 *   int, float, double, String[], void(return값이 없음)
		 *   int functionName(char c, int i){
		 *         //처리
		 *         return 값;(자료형 int에 맞춰서 해야함)
		 *   }
		 *   
		 *   장점: 코드를 간략화 할수 있다.
		 *   	    동일한 처리의 코드를 여러번 작성할 필요가 없다.
		 *        소스의 분업이 가능해 진다.
		 */
		
		funcName(); //함수 호출
		funcName1(12);
		int n = 17;
		funcName1(n); //변수의 값도 넣을 수 잇다.
		funcName2("hello", 'A'); //외부에서 호출하면, String str 은 stack영역에 올라감, 함수 가 끝나면 사라짐
		
		int r; //리턴값을 받을 변수
		r = funcName3(123.456);
		System.out.println("r =" +r);
		
		int asciiNum;
		asciiNum = getASCIIcode('a');
		System.out.println("asciiNum =" + asciiNum);
		
		double d = funcName4();
		System.out.println("d =" +d);
	}
	
	//ex1번 들어오는값도 나오는값도 없음
	static  void funcName() {
		System.out.println("funcName() 호출");
	}
	
	//ex2번 들어오는값은 있고 나오는값 없음
	static void funcName1(int i) { //(int i) <- 외부에서 값을받아옴
		System.out.println("funcName1(int i) 호출 i ="+ i);
	}
	
	//들어오는 값 2개, 나오는값 없음
	static void funcName2(String str, char c) { //외부에서 값을 가지고 오기위함, 
		System.out.println("funcName2(String str, char c)");
		System.out.println("str = " + str);
		System.out.println("c = "+ c);
		
		str = "world"; //내부적으로 가인수를 바꿀 수 있다.
		System.out.println("str = " + str);
	}
	
	//들어오는값(매개변수) 1개, 리턴값 1개 /들어오는값 double, 나가는값 int
	static int funcName3(double d) {
		System.out.println("funcName3(double d)");
		
		System.out.println("d = " +d);
		
		return 11;
	}
	
	//ascii코드값 알아내기 들어오는값 char
	static int getASCIIcode(char c) {
		return (int)c; 
	}
	
	// 돌아오는값 return만 있는 함수 random 같은거
	static double funcName4() {
		return 1.2345;
	}
	
}