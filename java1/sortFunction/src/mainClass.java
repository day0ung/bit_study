

import java.util.Scanner;

public class mainClass {
	public static void main(String[] args) {
		/*
		 * baseball random 1~10 사이의숫자중 3개 뽑음 -> 7 3 5
		 * 
		 * user input - 3개입력받음 1 2 3 (자리는안맞았는데 숫자는맞았다. 1ball) 7 8 9 (1 strike) 7 5 3
		 * (1strike 2ball)
		 * 
		 * #주의사항(증복제거) rnum != rnum2 != rnum3 2 4 4 2 4 1 -> 2strike 1ball
		 * 
		 * user input -> 같은 수가 입력이 되면 다시입력!
		 * 
		 * 10번의 기회
		 * 
		 * replay
		 */

		Scanner sc = new Scanner(System.in);

		int r_num[], u_num[]; // 랜덤값, 유저값
		boolean clear; // finding result에서 필요함 , 한군데에서만 필요한 변수는 local변수
		int strike, ball;
		boolean _switch[] = new boolean[10]; // 랜덤중복하기위해서만드는것
		int w, r; // w는 루프변수,r은 랜덤변수
		int count =0; //몇회만에 맞추는지 변수

		// 1.초기화

		r_num = new int[3];
		u_num = new int[3];
		clear = false; // 클리어를못한다는가정하에..false
		for (int i = 0; i < _switch.length; i++) {
			_switch[i] = false; // switch를 f로 다 꺼놓은상태
		}

		// * 2.random
//		r_num[0] = (int)(Math.random()*10)+1;
//		r_num[1] = (int)(Math.random()*10)+1;
//		r_num[2] = (int)(Math.random()*10)+1;  >>요것은 for문돌리면됨
//		while (true) {
//			for (int i = 0; i < r_num.length; i++) {
//				r_num[i] = (int) (Math.random() * 10) + 1;
//			}
//		}
//	중복제거	if (r_num[0] != r_num[1] && 
//				r_num[0] != r_num[2] && 
//				r_num[1] != r_num[2]) {
//				break;
//			} >>하드코딩, 한계가 있어염, 3개가아니라 8개면?힘들다
			
		//	밑에 _switch[0] =true; //이렇게하면 값이 안나옴.

			w = 0;			
			while (w < 3) {
				r = (int) (Math.random() * 10); // 0~9
				if (_switch[r] == false) { // 다시루프로 돌아오면 조건안맞음, 왜냐면 이미t여서
					_switch[r] = true; // fftff fffff 어느숫자가 나온것을 t로 바꾼것임
					r_num[w] = r + 1; // 1~10
					w++;
				}
			}

			for (int i = 0; i < r_num.length; i++) {
				System.out.println("r_num[" + i + "] =" + r_num[i]);
			}
			// * --------------loop 
			while(w <10) {
				strike = ball = 0; // loop안에서 초기화해야함
			// * 3.user input
				while(true) {
				for (int i = 0; i < u_num.length; i++) {
					System.out.print((i+1)+"번쨰 수 =");
					u_num[i] = sc.nextInt();
				}
				if(u_num[0] != u_num[1] &&
						u_num[0] != u_num[2] &&
						u_num[1] != u_num[2]) {
					break;
				}
				System.out.println("중복된숫자가 있습니다.");
			}
			// * 4.finding
			//unum 과 rnum비교
			//ball
			for (int i = 0; i < r_num.length; i++) {
				for (int j = 0; j < r_num.length; j++) {
					if(r_num[i] == u_num[j] && i!=j) {
						ball++;
					}
				}
			}
			//strike
			for (int i = 0; i < r_num.length; i++) {
				if(r_num[i] == u_num[i]) {
					strike++;
				}
			}
			//판정
			if(strike >2) {
				count = w + 1;
				clear = true;
				break;
			}
			//메시지
			System.out.println(strike +"스트라이크"+ ball + "볼입니다.");
			w++;
			}
			
			// * --------------
			// * 5.result
			
			if(clear) {
				System.out.println(count + "회 game Clear!!");
			}
			else {
				System.out.println("game over");
			}
			
		}

	}

