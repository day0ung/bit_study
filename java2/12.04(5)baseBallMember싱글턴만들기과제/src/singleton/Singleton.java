package singleton;

import java.util.HashMap;
import java.util.Scanner;

import dto.Human;

public class Singleton {

	private static Singleton single = null;
	public HashMap<String, Human> map;
	
	
	private Singleton() {
		map = new HashMap<String, Human>();
	}
	
	

		
	public static Singleton getInstance() {
		if (single == null) {
			single = new Singleton();
		}

		return single;
	}
	
	
}
