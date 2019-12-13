import java.util.Scanner;
/*
 * sorting
 * 
 * 선언부
 * 
 * 입력부 몇개를 정렬하시겠습니까? 동적할당(갯수에맞춰서) 숫자를 갯수에 맞게 입력받는다 올림(1)/내림(2)
 * 
 * 정렬
 * 
 * 결과출력
 */

public class lecMain {
	public static void main(String[] args) {
//sorting 할 numbers[] = 1번과 2번 3번이 필요함, updown = 1.2.3 번필요
		int number[];
		boolean updown[] = new boolean[1]; //넘겨줬다가 넘겨받아야함
//1.입력(함수)
		//input이 무엇일지 , output이 무엇일지 잘생각해야함
		number = userInput(updown); //입력받는처리만 함
		//입력은 나오
//2.정렬처리
//	swap
		sorting(number, updown[0]); //정렬만함
		
//3. 결과처리
		result_print(number); //결과처리만함
		/*
		Scanner sc = new Scanner(System.in);

		int count;
		String strNum[]; // 배열을 스트링으로받음
		boolean updown = true; // 올림/내림

		// 1.input
		
		// count 몇개를 할건지?
		System.out.print("몇개의 숫자를 정렬하시겠습니까? =");
		count = sc.nextInt();

		// 동적할당 allocation(배당)
		strNum = new String[count]; // 갯수는 count의 갯수

		// 정렬할 숫자들을 입력
		boolean ok = true; // 숫자가 입력이 다됬으면 true, 그렇지않고 뭐가끼여있으면 false

		int w = 0;
		while (w < strNum.length) { // strNum.length유동적임
			ok = true;
			System.out.print((w + 1) + "번째 수");
			strNum[w] = sc.next(); // 입력을받을때는 문자로 받는게 편함, 숫자는 나중에바꾸면됨

			// 정상적으로 숫자를 입력했는지 확인 123 1ab
			for (int i = 0; i < strNum[w].length(); i++) { 
				// strNum[w]이거는 문자하나에대한 문자, count가 아님 
				//문자열에대해서 문자열길이값만큼 돌리는것
				int n = strNum[w].charAt(i); // 한문자씩 확인
				if (n < 48 || n > 57) {
					ok = false;
					break;
				}
			}
			if (ok == false) { // 문자가 섞여 있을때
				System.out.println("잘못입력하셨습니다. 다시입력해주세요");
				continue; // 이거걸리면 w증가안됨
			}
			w++;
		}

		// 입력부분 올림/내림
		System.out.print("올림(1)/내림(2) =");
		int ud = sc.nextInt();
		if (ud == 1)
			updown = true;
		else
			updown = false;

		// 확인필수
		for (int i = 0; i < strNum.length; i++) {
			System.out.println("strNum[" + i + "]=" + strNum[i]);
		}
		// ------------입력부분 끝
		*/
		
		/*
		// 2.대입
		// 숫자로 변환해줄 배열을 선언
		int number[] = new int[strNum.length];

		for (int i = 0; i < number.length; i++) {
			number[i] = Integer.parseInt(strNum[i]);
		}
		*/
		
		// 3.정렬sorting
		/*
		int temp;
		for (int i = 0; i < number.length - 1; i++) {
			for (int j = i + 1; j < number.length; j++) {
				if (updown == true) { // 올림(앞의숫자가 클때 뒤로보내기위
					if (number[i] > number[j]) {
						temp = number[i];
						number[i] = number[j];
						number[j] = temp;
					}
				} else { // 내림
					if (number[i] < number[j]) {
						temp = number[i];
						number[i] = number[j];
						number[j] = temp;
					}
				}

			}

		}
		*/
		/*
		// 4.결과
		for (int i = 0; i < number.length; i++) {
			System.out.println(number[i] + " ");
		}
		*/
	}
	
	static int[] userInput(boolean ud[]) { //셋팅되서 넘어옴, int[]리턴으로 받아서 상관없음, 
		Scanner sc = new Scanner(System.in);
		System.out.print("몇개의 숫자를 정렬하시겠습니까? =");
		int count = sc.nextInt();

		// 동적할당 allocation(배당)
		String strNum[] = new String[count]; // 갯수는 count의 갯수

		// 정렬할 숫자들을 입력
		boolean ok = true; // 숫자가 입력이 다됬으면 true, 그렇지않고 뭐가끼여있으면 false

		int w = 0;
		while (w < strNum.length) { // strNum.length유동적임
			ok = true;
			System.out.print((w + 1) + "번째 수");
			strNum[w] = sc.next(); // 입력을받을때는 문자로 받는게 편함, 숫자는 나중에바꾸면됨
			//strNum[w] 이건 isnumber하면됨

			// 정상적으로 숫자를 입력했는지 확인 123 1ab
			for (int i = 0; i < strNum[w].length(); i++) { 
				// strNum[w]이거는 문자하나에대한 문자, count가 아님 
				//문자열에대해서 문자열길이값만큼 돌리는것
				int n = strNum[w].charAt(i); // 한문자씩 확인
				if (n < 48 || n > 57) {
					ok = false;
					break;
				}
			}
			if (ok == false) { // 문자가 섞여 있을때
				System.out.println("잘못입력하셨습니다. 다시입력해주세요");
				continue; // 이거걸리면 w증가안됨
			}
			w++;
		}

		// 입력부분 올림/내림
		System.out.print("올림(1)/내림(2) =");
		int updown = sc.nextInt();
		if (updown == 1)
			ud[0] = true;
		else
			ud[0] = false;

		// 확인필수
		for (int i = 0; i < strNum.length; i++) {
			System.out.println("strNum[" + i + "]=" + strNum[i]);
		}
		
		int number[] = new int[strNum.length];

		for (int i = 0; i < number.length; i++) {
			number[i] = Integer.parseInt(strNum[i]);
		}
		return number;
	}
	
	static void sorting(int num[], boolean up) { // boolean up올림,내림이냐만 확인하면됨, 값을바꿔줄 필요가없음
		//int temp; swap함수에서 만들어줄거니까 필요없음
		for (int i = 0; i < num.length - 1; i++) {
			for (int j = i + 1; j < num.length; j++) {
				if (up == true) { // 올림(앞의숫자가 클때 뒤로보내기위
					if (num[i] > num[j]) {
//						temp = num[i];
//						num[i] = num[j];
//						num[j] = temp;
						swap(num, i, j);
					}
				} 
				else { // 내림
					if (num[i] < num[j]) {
//						temp = num[i];
//						num[i] = num[j];
//						num[j] = temp;
						swap(num, i, j);
					}
				}

			}

		}
	}
	
	static void swap(int num[], int i, int j) { //넘버를 받은 int배열
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
	
	static void result_print(int num[]) {
		for (int i = 0; i < num.length; i++) {
			System.out.println("number"+(i+1) +" : " + + num[i]);
		}
	}

}
