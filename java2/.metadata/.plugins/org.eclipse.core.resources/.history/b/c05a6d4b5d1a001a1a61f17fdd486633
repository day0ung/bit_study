package main;

import java.util.Iterator;

import dto.Human;
import single.Singleton;
import view.MenuView;

public class mainClass {

	public static void main(String[] args) {
		
		new MenuView();
		
		Singleton s = Singleton.getInstance();
		s.dataCls.readFile();
		
	//	Singleton s = Singleton.getInstance();		
	/*	Iterator<String> it = s.map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			Human h = s.map.get(key);
			System.out.println(h.toString());
		}*/

	}

}
