package baseball클래스화;

import java.util.Scanner;

public class BaseballClass {
	private int r_num[], u_num[];
	private boolean clear;

	//초기화
	public void init() {
		r_num = new int[3];
		u_num = new int[3];
		clear = false;
		
		randomSet(r_num);
	
	}
	
	//랜덤산출
	public void randomSet(int rnum[]) { //호출할때마다 랜덤값이 바뀌어야하는것이 편함
		
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
	
	
	//userInput
	public int[] userInput(int unum[]) {
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
	
	
	//finding
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
	
	//loop
	public void loop() {
		
		int message[] = new int[2];
		int w = 0;
		while(w <10) {
		u_num = userInput(u_num); //u_num =사실이거 필요없음 (return값이 있을 때는 받는값 u_num = 이 필요함)
		//4. 판정
		  clear = finding(r_num, u_num, message);
		  if(clear) break;
		  //5.메시지
		  System.out.println(message[0] +"스트라이크"+ message[1] + "볼입니다.");
		w++;
		}
	}
}
