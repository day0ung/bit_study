package gbbGame;

import java.util.Scanner;

public class mainClassGbb {
	public static void main(String[] args) {
		/*
		 *  가위, 바위, 보 (0,1,2)
		 *  user: com
		 *  ? win ? lose ? draw
		 *  
		 *  replay ->(y/n)
		 */
		Scanner sc = new Scanner(System.in);
		//선언
		int userNum, comNum;
		int win, lose, draw;
		int result;
		//초기화
		win = lose =draw = 0; 
		System.out.println("---------<<가위 바위 보>>------------");
		
		System.out.println("Start Game>>>>>>>>");
		
		while(true) {
		//random
		comNum =(int)(Math.random()*3); //0,1,2
		System.out.println("comNum ="+comNum);
		
		//user input( 사용자로부터 입력)
		System.out.print("가위(0), 바위(1), 보(2) =");
		userNum = sc.nextInt();
		
		//finding( 판정 )
		//win
		/*--------하드코딩--------
		if(userNum == 0 && comNum ==2) {
			result = 0;
		}else if(userNum == 1 && comNum ==0) {
			result = 0;
		}else if(userNum ==2 && comNum ==1) {
			result = 0;
		}
		
		//lose
		if(userNum == 2 && comNum ==0) {
			result = 1;
		}else if(userNum == 0 && comNum ==1) {
			result = 1;
		}else if(userNum ==1 && comNum ==2) {
			result = 1;
		}
		
		//draw
		if(userNum == 0 && comNum ==0) {
			result = 2;
		}else if(userNum == 1 && comNum ==1) {
			result = 2;
		}else if(userNum ==2 && comNum ==2) {
			result = 2;
		}
		*/
		
		
		
		
		//0(가위) 1(바위) 2(보)
		/*
		 * com 		user	  win
		 * 2	-	0  +2  =   4    %3 ->1
		 * 0	-	1  +2  =   1
		 * 1	-	2  +2  =   1
		 * 
		 * com 		user	  lose
		 * 0	-	2  +2  =   0    %3 ->0
		 * 1	-	0  +2  =   3
		 * 2	-	1  +2  =   3
		 * 
		 * com 		user	  draw
		 * 0	-	0  +2  =   2    %3 ->2
		 * 1	-	1  +2  =   2
		 * 2	-	2  +2  =   2
		 */
		
		result = (comNum - userNum +2) %3;
		
		String resultMsg ="";
		switch(result) {
			case 1:
				resultMsg ="이겼습니다.";
				win++;
				break;
			case 0:
				resultMsg = "졌습니다.";
				lose++;
				break;				
			case 2:
				resultMsg ="무승부";
				draw++;
				break;				
		}
		
		String userCho ="";
		String comCho = "";
		
		if(userNum == 0)  userCho ="가위";
		else if(userNum ==1) userCho = "바위";
		else				userCho = "보";
		
		if(comNum == 0)  comCho ="가위";
		else if(comNum ==1) comCho = "바위";
		else				comCho = "보";
		//result print
		System.out.println(resultMsg + "당신은"+ userCho +"내고 컴퓨터는 "+comCho+ "를 냈습니다.");
		
		//승패무
		System.out.println(win + "승" + lose+"패"+ draw +"무입니다." );
		
		//replay
		System.out.print("계속하시겠습니까(y/n) =");
		String msg = sc.next();
		
		if(msg.contentEquals("n") || msg.equals("N")) {
			System.out.println("안녕히가세요");
			break;
		}else {
			System.out.println("다시하기");
		}
		
		}
	}

}
