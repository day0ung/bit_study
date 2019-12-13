
public class PitcherDTO extends HumanDTO {
	private int win;
	private int lose;
	private double defense;
	
	public PitcherDTO() {
		// TODO Auto-generated constructor stub
	}

	public PitcherDTO(int number, String name, int age, double height, int win, int lose, double defense) {
		super(number, name, age, height);
		this.win = win;
		this.lose = lose;
		this.defense = defense;
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

	public double getDefense() {
		return defense;
	}

	public void setDefense(double defense) {
		this.defense = defense;
	}

	@Override
	public String toString() {
		
		return super.toString() + "|승: " + win + "|패: " + lose + "|방어율:" + defense;
	}
	
	
}
