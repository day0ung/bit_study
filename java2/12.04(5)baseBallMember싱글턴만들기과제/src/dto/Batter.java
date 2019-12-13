package dto;

public class Batter extends Human {
	private int batcount;
	private int hit;
	private double hitAvg;
	
	public Batter() {
		
	}

	public Batter(int number, String name, int age, double height, String birth, int batcount, int hit, double batAvg) {
		super(number, name, age, height, birth);
		this.batcount = batcount;
		this.hit = hit;
		this.hitAvg = batAvg;
	}

	public int getBat() {
		return batcount;
	}

	public void setBat(int bat) {
		this.batcount = bat;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public double getBatAvg() {
		return hitAvg;
	}

	public void setBatAvg(double batAvg) {
		this.hitAvg = batAvg;
	}

	@Override
	public void information() {
		// TODO Auto-generated method stub
		super.information();
		System.out.println("타율: "+ hitAvg);
	}

	@Override
	public String toString() {
		return super.toString() +"-" + batcount + "-" + hit + "-" +hitAvg;
	}
	
	
}
