package randomNumber;

import java.util.Scanner;

public class mainClass {
	public static void main(String[] args) {
		/*
		 * random -> 1개 받음 범위( 1~ 100)
		 * 
		 * -----------------------loop 기회는 10번 입력 >> 50 message: 너무작습니다 입력 >>70 message:
		 * 너무작습니다 입력>> 90 message: 너무큽니다 ----------------------- 결과
		 * 
		 * ==필요한것 1.선언부 2.random 산출(1~100) ----------------loop start 3.User로 부터 입력 4.판정
		 * ----------------loop end 5.결과
		 * 
		 */

		// 선언부

		Scanner scan = new Scanner(System.in);
		// 랜덤산출
		int rNum = (int) (Math.random() * 100) + 1;
		int w = 0;
		// user로부터 입력

		System.out.println("번호를 입력하세요: ");
		int choice = scan.nextInt();
		if (choice == rNum) {
			System.out.println("맞추셨습니다.");

		} else if (choice > rNum) {
			System.out.println("너무 큽니다.");
			while (w < 10) {
				if (choice > rNum)
					System.out.println("다시입력해주세요");
				choice = scan.nextInt();
				w++;
				System.out.println((10 -w)+"번의 기회남음");
			}

		} else if (choice < rNum) {
			System.out.println("너무 작습니다.");
			while (w < 10) {
				if (choice < rNum)
					System.out.println("다시입력해주세요");
				choice = scan.nextInt();
				w++;
				System.out.println((10 -w)+"번의 기회남음");
			}
		}

		// 판정

		// 결과

	}

}
