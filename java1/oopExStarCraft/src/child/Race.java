package child;

import parent.StarCraft;

public class Race extends StarCraft {
	public void life() { //over ride  메소드
		System.out.println("Race life");
	}
	
	public void fly() {
		System.out.println("Race 날다");
	}


}
