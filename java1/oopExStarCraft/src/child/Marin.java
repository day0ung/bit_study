package child;

import parent.StarCraft;

public class Marin extends StarCraft {
	
	public void life() { //over ride  메소드
		System.out.println("Marin life");
	}
	
	public void run() {
		System.out.println("Marin 뛰다");
	}

}
