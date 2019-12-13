
public class BatterDTO extends HumanDTO {
	private int bat;
	private int hit;
	private double batAvg;
	
	public BatterDTO() {
		// TODO Auto-generated constructor stub
	}

	public BatterDTO(int number, String name, int age, double height, int bat, int hit, double batAvg) {
		super();
		this.bat = bat;
		this.hit = hit;
		this.batAvg = batAvg;
	}

	public int getBat() {
		return bat;
	}

	public void setBat(int bat) {
		this.bat = bat;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public double getBatAvg() {
		return batAvg;
	}

	public void setBatAvg(double batAvg) {
		this.batAvg = batAvg;
	}

	@Override
	public String toString() {
		return super.toString() + "|타수: " + bat + "|안타: " + hit + "|타율: " + batAvg ;
	}
	
	
}
