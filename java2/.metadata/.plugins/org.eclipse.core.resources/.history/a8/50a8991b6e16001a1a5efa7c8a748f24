package dto;

public class Pitcher extends Human {
	private int win;
	private int lose;
	private double defence;
	
	public Pitcher() {
		
	}

	public Pitcher(int number, String name, int age, double height, String birth, int win, int lose, double defence) {
		super(number, name, age, height, birth);
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

	
	@Override
	public void information() {
		// TODO Auto-generated method stub
		super.information();
		System.out.println("방어율: "+ defence);
	}

	@Override
	public String toString() {
		return super.toString() +"-" + win + "-" + lose + "-" + defence ;
	}
	
	
}
