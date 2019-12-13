package overLoad;

public class mainClass {
	public static void main(String[] args) {
		/*
		 *  Over Load : 함수명(메소드)은 같고
		 *  			인자, 인수(매개변수)의 자료형이나
		 *  			인수의 갯수가 다른 함수를 의미한다.(동명2인)
		 *  
		 *  ex)
		 *  image draw function (이미지를 뿌리는함수)
		 *  
		 *  RGB, RGBA(Alpha는 투명도)
		 *  
		 *  imageDraw(int x, int y);
		 *  imageDraw(int x, int y, int a);
		 *  
		 *  Over Ride : 상속성, 다형성
		 */
		func();
		func('A');
		func(123);
		func('B', 234);
		func( 345, 'C');
	}
	static void func() {
		System.out.println("func() 호출");
	}
	
	static void func(char c) {
		System.out.println("func(char c) 호출");
	}
	
	static void func(int i) {
		System.out.println("func(int i) 호출");
	}
	static void func(char c, int i ) {
		System.out.println("func (char c, int i) 호출");
	}
	static void func(int i , char c ) { //가능
		System.out.println("func (char c, int i) 호출");
	}
	
	/*
	static int func(int i , char c ) { //사용불가, 리턴값을 함수처리가 된후에 받아들임, 
		System.out.println("func (char c, int i) 호출");
		return 1;
	}
	*/
	
	/*
	static void func(int j , char ch ) { //불가능, 가인수(j)만 바꿔서사용하면 안됨
		System.out.println("func (char c, int i) 호출");
	}
	*/

}
