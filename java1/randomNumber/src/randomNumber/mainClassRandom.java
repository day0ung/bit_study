package randomNumber;

import java.util.Scanner;

public class mainClassRandom {
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
		Scanner sc = new Scanner(System.in);
		// 1.선언부
		int r_num, u_num; // random번호와, user넘버가 필요
		boolean clear; // 게임을 맞췄느냐 안맞췄느냐의 변수
		int w;
		// 초기화
		while (true) {
			clear = false;
			w = 0;
			// 2.random산출
			r_num = (int) (Math.random() * 100) + 1;
			System.out.println("r_num =" + r_num); // 확인하기
			////////////////////////////////////////////// loop

			while (w < 10) {
				// 3.user입력
				System.out.print("user number =");
				u_num = sc.nextInt();

				// 4.판정
				int findnum = 0; // 다르게나가는것 여러가지코드들..

				if (u_num > r_num)
					findnum = 1;
				else if (u_num < r_num)
					findnum = 2;
				else
					findnum = 3;

				switch (findnum) {
				case 1:
					System.out.println("too big");
					break;
				case 2:
					System.out.println("too small");
					break;
				case 3:
					System.out.println("bingo!!");
					clear = true;
					break;

				}
				if (clear == true) {
					break;
				}
				w++;
			}
			// 5.결과
			if (clear) {
				System.out.println("game clear");
			} else {
				System.out.println("game over");
			}
			// replay?
			String msg = "";
			System.out.println("replay OK(y/n)= ");
			msg = sc.next();

			if (msg.charAt(0) != 'y' && msg.charAt(0) != 'Y') {
				System.out.println("good bye");
				break;
			}
			System.out.println("restart game");
		}

	}

}
