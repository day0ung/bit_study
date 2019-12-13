package gbbgameClass;

import java.util.Scanner;

public class Game {
	Scanner sc = new Scanner(System.in);
	//멤버변수는 대부분 private, 멤버메소드는 대부분 public 
	//두개의 메소드 이상에서 꼭접근해야하는 변수들은 필요함, 한군데에서 필요할때는 멤버변수설저할 필요없음
	private int userNum, comNum;
	private int win, lose, draw;
	private int result;
	
	public void init() { //초기화는 리턴값필요없음
		win = 0;
		lose = 0;
		draw = 0;
	}
	
	public void randomSet() {
		//random
		comNum =(int)(Math.random()*3);
		System.out.println("comNum ="+comNum);
	}
	public void userInput() {
		//Scanner sc = new Scanner(System.in); //만약 다른함수에도 더 필요하면 멤버변수에 넣어줌
		System.out.print("가위(0), 바위(1), 보(2) =");
		userNum = sc.nextInt();
	}
	
	public String resultMessage() {
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
		return resultMsg;
	}
	
	public void loop() {
		while(true) {
			//random받는부분
			randomSet();
			//userinput받는부분
			userInput();
			//가져온부분
			result = (comNum - userNum +2) %3;
			String resultMsg = resultMessage();
			/*
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
			*/
			String userCho =""; //local변수임, 멤버변수로 갖고 있을 필요없음
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
