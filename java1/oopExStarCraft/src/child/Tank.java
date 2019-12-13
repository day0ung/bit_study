package child;

import parent.StarCraft;

public class Tank extends StarCraft {
	public void life() { //over ride  메소드
		System.out.println("Tank life");
	}
	
	public void canon() {
		System.out.println("Tank 포격");
	}

}
