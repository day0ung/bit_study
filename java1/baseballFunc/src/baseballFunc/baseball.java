package baseballFunc;

import java.util.Scanner;

public class baseball {

	public static void main(String[] args) {
		/*
		 * 1. 초기화
		 * 
		 * 2. random 산출 r_num[]필요 >> 2개이상 변수가 필요하면 메인에 있어야함
		 * -------------------------loop 10번의 기회
		 * 3. user input >> Scanner sc = new Scanner(System.in);여기만필요함
		 * 
		 * 4. 판정 r_num[]필요 boolean clear;필요 >> 2개 이상필요
		 * 
		 * 5.메세지 1strike같은것들
		 * -------------------------
		 * 6.결과처리  boolean clear;
		 * 
		 *  함수에서 중요한것 어떤것을 넘겨받고 넘겨주는지 잘알면됨
		 */
		
		//필요한 변수들
		int r_num[], u_num[];
		boolean clear;
		
		//1 .초기화
		r_num = new int[3];
		u_num = new int[3];
		clear = false;
		
		//2. random산출 >> 랜덤숫자 3개뽑는것이 목적 //return 받을필요없음, address할당
		ballRandom(r_num); //랜덤 3개 받는것
		 //loop-----------
		int message[] = new int[2];
		int w = 0;			
		while (w < 10) {
			  //3. user input //숫자 3개 입력받아야함 리턴해도되고 address할당해도됨
			u_num = userInput(u_num); //u_num =사실이거 필요없음 (return값이 있을 때는 받는값 u_num = 이 필요함)
			 //4. 판정
			  clear = finding(r_num, u_num, message);
			  //5.메시지
			  System.out.println(message[0] +"스트라이크"+ message[1] + "볼입니다.");
			w++;
		}
		// 6.결과
		if(clear) {
			System.out.println("Game Clear!!");
		}
		else {
			System.out.println("Game Over~");
		}
		/*
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

			//랜덤
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
			*/
		}
	static void ballRandom(int rnum[]) { //호출할때마다 랜덤값이 바뀌어야하는것이 편함
		boolean _switch[] = new boolean[10]; 
		int w, r;
		w = 0;			
		while (w < 3) {
			r = (int) (Math.random() * 10); // 0~9
			if (_switch[r] == false) { // 다시루프로 돌아오면 조건안맞음, 왜냐면 이미t여서
				_switch[r] = true; // fftff fffff 어느숫자가 나온것을 t로 바꾼것임
				rnum[w] = r + 1; // 1~10
				w++;
			}
		}
		for (int i = 0; i < rnum.length; i++) {
			System.out.println("r_num[" + i + "] =" + rnum[i]);
		}
	}
	
	static int[] userInput(int unum[]) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			for (int i = 0; i < unum.length; i++) {
				System.out.print((i+1)+"번쨰 수 =");
				unum[i] = sc.nextInt();
			}
			if(unum[0] != unum[1] &&
					unum[0] != unum[2] &&
					unum[1] != unum[2]) {
				break;
			}
			System.out.println("중복된숫자가 있습니다.");
		}		
		return unum;
	}

	
	static boolean finding(int rnum[], int unum[], int message[]) {
		int strike = 0 , ball = 0;
		//ball
		for (int i = 0; i < rnum.length; i++) {
			for (int j = 0; j < rnum.length; j++) {
				if(rnum[i] == unum[j] && i!=j) {
					ball++;
				}
			}
		}
		//strike
		for (int i = 0; i < rnum.length; i++) {
			if(rnum[i] == unum[i]) {
				strike++;
			}
		}
		
		message[0] = strike;
		message[1] = ball;
		
		if(strike >2) {
			return true;	
		}
		return false;
	}
	
}