package sample01;

public class YouClass {
	private int number;
	private String name;
	
	public YouClass() {
		
	}

	public YouClass(int number, String name) {
		super();
		this.number = number;
		this.name = name;
	}

	@Override
	public String toString() {
		return "YouClass [number=" + number + ", name=" + name + "]";
	}
	
}	
