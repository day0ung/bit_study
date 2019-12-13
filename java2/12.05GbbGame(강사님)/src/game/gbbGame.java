package game;

public class gbbGame {
	
	int userNum, comNum;
	int win, lose, draw;
	int result;
	
	public gbbGame() {
		// TODO Auto-generated constructor stub
		win = lose = draw = 0;
	}
	
	public void init() {
		comNum = (int)(Math.random() * 3);	// 0, 1, 2
		System.out.println("comNum = " + comNum);
	}
		
	public String play() {
		String msg = "";
		result = (comNum - userNum + 2) % 3;
		switch(result) {
			case 1:	
				msg = "승리!!!";
				win++;
				break;
			case 0:
				msg = "패전입니다";
				lose++;
				break;
			case 2:			
				msg = "무승부입니다";
				draw++;
				break;		
		}
		return msg;
	}

	public int getWin() {
		return win;
	}

	public int getLose() {
		return lose;
	}

	public int getDraw() {
		return draw;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}	

	public String getUser() {
		String userCho;
		if(userNum == 0)		userCho = "가위";
		else if(userNum == 1)	userCho = "바위";
		else					userCho = "보";
		return userCho;
	}

	public String getCom() {
		String comCho;
		if(comNum == 0)		comCho = "가위";
		else if(comNum == 1)	comCho = "바위";
		else					comCho = "보";
		return comCho;
	}	
	

}
