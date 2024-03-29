
public class mainClass {
	public static void main(String[] args) {
		/*
		 * Exception : 예외 != 에러
		 * 			   개발자 용(유지보수), 어떤 예외가 발생했는지 보기위함
		 * 
		 * baseball -> 1 2 3 -> 'A' -> 65 
		 * 숫자입력하라했는데 A를 입력함, ascii코드값으로 65임
		 * 
		 * -----exception이 발생하는상황들-------
		 * number -> format	   1 2 3 -> 'A'
		 * array -> index number [0번째 1번째]  int arr[] = new int [3] ->arr[3]error
		 * class -> Scanner import안하면 못찾는다.
		 * file  -> 경로로지정해준 경로에 파일이없을때
		 * 
		 * int number[] = new int[2];
		 * 
		 * try{
		 * 	   number[2] = 'a'; //예외가 발생할 가능성이 있는 코드
		 * 
		 * }catch(예외 클래스1 e){
		 * 		메시지(예외가 발생했다)
		 * }catch(예외 클래스2 e){
		 * 		메시지
		 * }catch(예외 클래스3 e){
		 * 		메시지
		 * }finally{
		 *    //무조건 실행
		 *    //뒤처리
		 *      파일 close
		 *      DB 원상복구 -> rollback = undo
		 * }
		 */
		int num[] = { 11, 22, 33};
		System.out.println("프로그램시작");
		
		try {
		for (int i = 0; i < 4; i++) {
			System.out.println(num[i]);
		}		
		System.out.println("배열출력완료");
		}catch (ArrayIndexOutOfBoundsException e){
		//	System.out.println("배열범위 초과");
		//	e.printStackTrace();
			//java.lang.ArrayIndexOutOfBoundsException: 3
			//at mainClass.main(mainClass.java:40)  배열 3번째
		System.out.println(e.getMessage()); //출력값 3
		
		//return; //프로그램 끝 실행안됨, 여기서 튀어버림 밑에 sysOut프로그램끝까지 못미침, 
				//finally는 실행됨, 
		
		}catch (NumberFormatException e) { //숫자로들어와야하는데 문자로들어왓을때
			e.printStackTrace();
			
		}finally {
			System.out.println("finally무조건 실행됨"); //원상복구의 영역
		}
		System.out.println("프로그램 끝");
		funcExcp();
	}
	
	static void funcExcp()throws ArrayIndexOutOfBoundsException { 
		//throws ArrayIndexOutOfBoundsException  <<이 함수내부에서 예외가 발생할 소지가 있다.
		//()매개변수 괄호 닫은부분 다음에 적어주면됨
		int n[] = { 1, 2, 3 };
//		try {
			for (int i = 0; i < 4; i++) {
				System.out.println(n[i]);
			}
//		} catch (ArrayIndexOutOfBoundsException e) {
//			e.printStackTrace();
//		}
	}

}
