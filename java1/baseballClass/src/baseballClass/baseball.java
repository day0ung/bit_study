package baseballClass;

import java.util.Scanner;

public class baseball {
	private int u_num[], r_num[];
	private boolean clear;
	private int strike, ball; //언제든접근가능
	private int count;
	
	//메소드=파라미터로 넘겨줄필요가없음, 내부에서해결이됨
	public void init() {
		//이부분은 constructor에 있으면됨
		r_num = new int[3];
		u_num = new int[3];		
		clear = false;
		count = 0;
		random();
	}
	
	public void random() {
		boolean _switch[] = new boolean[10];	
		int w, r;
		
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
	}
	
	public void loop() {
		int w = 0;
		//int message[] = new int[2]; 멤버변수선언으로필요없어짐
		while(w < 10) {
			count++; //처음시작할때 1회하기위함
			//userInput호출
			userInput();
			
			//finding은 boolean갖고있게해야함(리턴값이있어야함)
			clear = finding();
			if(clear) break; //clear가 true엿을때 브레이크
			
			System.out.println(strike + "스트라이크 " + ball + "볼입니다");
			w++;
			
		}
		
	}
	
	public void userInput() { //리턴값할필요가없음(멤버변수가있기때문)
		Scanner sc = new Scanner(System.in);
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
		
	}
	
	public boolean finding() { //void에서 boolean으로 바뀐이유는 strike때문에
		//int strike = 0, ball = 0;
		strike = ball = 0;
		// ball
		for (int i = 0; i < r_num.length; i++) {
			for (int j = 0; j < r_num.length; j++) {
				if (r_num[i] == u_num[j] && i != j) {
					ball++;
				}
			}
		}

		// strike
		for (int i = 0; i < r_num.length; i++) {
			if (r_num[i] == u_num[i]) {
				strike++;
			}
		}
		//message필요없어짐
		if(strike > 2) {
			return true;
		}
		return false;
	}
	
	public void resultPrint() {
		if(clear) {
			System.out.println(count+ "회에 성공하였습니다\nGame Clear!!");
		}
		else {
			System.out.println("Game Over~");
		}
	}
	

}