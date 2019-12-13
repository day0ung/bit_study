package gbbGame;

import java.util.Scanner;

public class mainClass {
	public static void main(String[] args) {
		/*
		 *  가위, 바위, 보
		 *  user: com
		 *  ? win ? lose ? draw
		 *  
		 *  replay ->(y/n)
		 */
		Scanner scan = new Scanner(System.in);
		int userC;
		int computer = (int)(Math.random()*3);
		while(true) {
		System.out.println(computer);
		String[] rsp = { "가위", "바위", "보" };
		System.out.println("0.가위 1.바위 2.보");
		System.out.print(">");
		
		userC = scan.nextInt();
		if (userC == computer) {
			System.out.println("사용자:"+rsp[userC]);
			System.out.println("컴퓨터:"+rsp[computer]);
			System.out.println("draw");
		}else {
			switch(userC) {
			case 0:
				if (computer == 1) {
					System.out.println("사용자패배");
					System.out.println("사용자:"+rsp[userC]);
					System.out.println("컴퓨터:"+rsp[computer]);
				} else {
					System.out.println("사용자승리");
					System.out.println("사용자:"+rsp[userC]);
					System.out.println("컴퓨터:"+rsp[computer]);
				}

				break;
			case 1:
				if(computer == 2) {
					System.out.println("사용자패배");
					System.out.println("사용자:"+rsp[userC]);
					System.out.println("컴퓨터:"+rsp[computer]);
				}else {
					System.out.println("사용자승리");
					System.out.println("사용자:"+rsp[userC]);
					System.out.println("컴퓨터:"+rsp[computer]);
				}
				break;
			case 2:
				if (computer == 3) {
					System.out.println("사용자패배");
				} else {
					System.out.println("사용자승리");
				}

				break;
			}
			String msg = "";
			System.out.println("replay OK(y/n)= ");
			msg = scan.next();

			if (msg.charAt(0) != 'y' && msg.charAt(0) != 'Y') {
				System.out.println("good bye");
				break;
			}
			System.out.println("restart game");
		}
		}

		
	}

}
