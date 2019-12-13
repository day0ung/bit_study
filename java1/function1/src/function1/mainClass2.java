package function1;

public class mainClass2 {
	public static void main(String[] args) {
		/*  //자료형 매개변수 리턴값을 배열로받을 수 있다.
		 *  array      array
		 *  자료형 함수명(매개변수)
		 *  	처리
		 *  	리턴값  array
		 * 
		 */
		
		int num;
		int arrNum[] = new int [1];
		
		num = 11;		
		arrNum[0] = 11;
		
		System.out.println("arrNum =" +arrNum);  //주소값나옴
		
		func(num, arrNum, arrNum[0]); //arrNum >> 주소를넘겨준것임 / arrNum[0] >>값 value을 넘겨준것임
		System.out.println("num =" +num);
		System.out.println("arrNum[0]" + arrNum[0]);
		//------func의 출력결과-----
//		n =11   
//		arr[0] =11 
//		num =11      >> 바뀌지않음 (일반변수) num이 넘어가는 것이아니라  11이 넘어감
//		arrNum[0]22  >>바뀜 (배열, 참조변수) , 넘어갈때 주소값이 넘어가는것임 본인이 넘어감,
		
		
		int aNumber[] = {2, 4, 6, 8, 10};
		arrDiv2(aNumber);
		for (int i = 0; i < aNumber.length; i++) {
			System.out.println("aNumber[" +i+"] ="+aNumber[i]);
		}
		
		
		int a, b;
		a = 1;
		b = 2;
		//함수 갔다오기전
		System.out.println("함수전a ="+ a+ "b = " +b);
		//swap
		swap(a,b);
		System.out.println("함수후a ="+ a+ "b = "+b);
		//--------출력결과------
//				함수전a =1b = 2
//				함수안a =2b = 1
//				함수후a =1b = 2
		//자료형(int, double)같은것들은 int a자체가 들어가는 것이 아니라, a에 대입된 value 즉, 1이 들어간것이기 때문에
		//함수후 a =1, b =2 라는 결과를 출력한다.
		
		int arr[] = new int[2];
		
		arr[0] =1;
		arr[1] =2;
		System.out.println("함수전arr[0] ="+ arr[0]+ "arr[1] = " +arr[1]);
		swapArr(arr); //하나가넘어가는데 덩어리로 넘어가는것
		System.out.println("함수후arr[0] ="+ arr[0]+ "arr[1] = " +arr[1]);
		//--------출력결과---------
//				함수전arr[0] =1arr[1] = 2
//				함수안arr[0] =2arr[1] = 1
//				함수후arr[0] =2arr[1] = 1
		//참조형변수는  arr[0] =1에 대입된 변수value 1 이 대입되는것이아니라
		// arr그자체(주소값)이 들어가는 것이기 때문에, 
		// 함수후arr[0] =2arr[1] = 1(변경된값)이 출력된다.

	}
	
	
	//				value,  address  ,  value     //두가지가 다름, 앞의 것과 뒤이 차이점 앞은 값이 넘어옴, 뒤는 자기자신(=pointer)이 넘어옴
	static int func(int n, int arr[], int arrNum) {
		System.out.println("n =" +n);
		System.out.println("arr[0] =" +arr[0]);
		
		n = 22;
		arr[0] =22;
		return n;
	}
	
	static void arrDiv2(int anum[]) {
		for (int i = 0; i < anum.length; i++) {
			anum[i] =anum[i] /2;
			
		}
	}
	
	static void swap(int a, int b) {
		int temp;
		temp = a;
		a = b;
		b = temp;
		System.out.println("함수안a ="+ a+ "b = " +b);
	}
	
	
	static void swapArr(int arr[]) {
		int temp;
		temp = arr[0];
		arr[0] = arr[1];
		arr[1] = temp;
		
		System.out.println("함수안arr[0] ="+ arr[0]+ "arr[1] = " +arr[1]);
		
	}
	
//	static void standardFunc(int a, int[] arr) {
//		// int a =input들어가기만하는값,  int[] arr = output값 갖고나옴, 리턴을안해줘도 나옴
//		
//	}
	
	static int[] randomValue(int rnum) {
		int array[] = new int[rnum]; // new int[rnum]인자값에 따라서 랜덤갯수가 달라짐
		for (int i = 0; i < array.length; i++) {
			array[i] = (int)(Math.random()*10);
		}
		return array; // new int[3] 햇을때는3개 무조건넘어감,  int rnum 인자값에 따라서 넘어감
	}
}
