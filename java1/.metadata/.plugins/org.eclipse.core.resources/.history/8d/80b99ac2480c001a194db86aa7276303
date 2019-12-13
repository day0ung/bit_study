package baseball;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		/*
			baseball
			
			random
			1 ~ 10
			-> 
			7 3 5
			
			user input -> 3개 숫자
			1 2 3	-> 1 ball
			7 8 9	-> 1 strike
			7 5 3	-> 1 strike 2 ball
			
			rnum1 != rnum2 != rnum3
			2 4 4
			2 4 1	-> 2 strike 1 ball
			
			user input -> 같은 수가 입력이 되면 다시 입력!
			
			10번의 기회
			
			replay
		*/	
		Scanner sc = new Scanner(System.in);
		
		int r_num[], u_num[];
		boolean clear;
		int strike, ball;	
		boolean _switch[] = new boolean[10];	
		int w, r;
		int count = 0;
				
		//	1.초기화
		r_num = new int[3];
		u_num = new int[3];
		clear = false;
		for (int i = 0; i < _switch.length; i++) {	// fffff fffff
			_switch[i] = false;
		}
			
		//	2.random
		/*
		while(true) {
			for (int i = 0; i < r_num.length; i++) {
				r_num[i] = (int)(Math.random() * 10) + 1;
			}
			if(r_num[0] != r_num[1] 
					&& r_num[0] != r_num[2]
							&& r_num[1] != r_num[2]) {
				break;
			}
		}
		*/
		
		w = 0;
		while(w < 3) {
			r = (int)(Math.random() * 10);	// 0 ~ 9
			if(_switch[r] == false) {
				_switch[r] = true;		// fftff fffff
				r_num[w] = r + 1;		// 1 ~ 10
				w++;
			}
		}
		
		for (int i = 0; i < r_num.length; i++) {
			System.out.println("r_num[" + i + "] = " + r_num[i]);
		}
					
		//////////////////	loop
		w = 0;
		while(w < 10) {
			strike = ball = 0;
			//	3.user input
			while(true) {
				for (int i = 0; i < u_num.length; i++) {
					System.out.print((i + 1) +  "번째 수 = ");
					u_num[i] = sc.nextInt();
				}
				if(u_num[0] != u_num[1] 
						&& u_num[0] != u_num[2]
								&& u_num[1] != u_num[2]) {
					break;
				}
				System.out.println("중복된 숫자가 있습니다");
			}
				
			//	4.finding
			// ball
			for (int i = 0; i < r_num.length; i++) {
				for (int j = 0; j < r_num.length; j++) {
					if(r_num[i] == u_num[j] && i != j) {
						ball++;
					}
				}
			}		
			
			// strike
			for (int i = 0; i < r_num.length; i++) {
				if(r_num[i] == u_num[i]) {
					strike++;
				}
			}
			
			// 판정
			if(strike > 2) {
				count = w + 1;
				clear = true;
				break;
			}
			
			// 메시지
			System.out.println(strike + "스트라이크 " + ball + "볼입니다");
			
			w++;
		}
		
		//////////////////
			
		//	5.result
		if(clear) {
			System.out.println(count + "회 Game Clear!!");
		}
		else {
			System.out.println("Game Over~");
		}
			
		
		

	}

}






