package dto;

public class Pitcher extends Human {
	private int win;
	private int lose;
	private double defence;
	
	public Pitcher() {


	}

	public Pitcher(int number, String name, int age, double height, int win, int lose, double defence) {
		super(number, name, age, height); //휴먼에서 기입할내용들을 추가, 
		this.win = win;
		this.lose = lose;
		this.defence = defence;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public double getDefence() {
		return defence;
	}

	public void setDefence(double defence) {
		this.defence = defence;
	}
	
	

	@Override //부모에 있는 메소드 호출
	public void infomation() {
		super.infomation(); //
		System.out.println("방어율: "+defence);
	}

	@Override
	public String toString() {
		return super.toString() +"-" + win + "-" + lose + "-" + defence ;
	}
	//super.toString() 위의값과 밑의 값을 한꺼번에 볼수 있음 앞부분human의 toString 과 pit의 toString을 한번에 볼수 있음
	
	
	
	
}
