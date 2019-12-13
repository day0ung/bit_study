import java.util.Scanner;

public class mainlectur {
	public static void main(String[] args) {
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

		// 2.대입
		// 숫자로 변환해줄 배열을 선언
		int number[] = new int[strNum.length];

		for (int i = 0; i < number.length; i++) {
			number[i] = Integer.parseInt(strNum[i]);
		}

		// 3.정렬sorting
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
		// 4.결과
		for (int i = 0; i < number.length; i++) {
			System.out.println(number[i] + " ");
		}
	}
}