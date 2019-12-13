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
		
		
		Iterator<String> it = s.map.keySet().iterator();
		while(it.hasNext()) {
			String key =it.next();
			Human h = s.map.get(key); //휴먼데이터가나옴
			System.out.println(h.toString()); //피처건배터건 상속받은부분의 toString이 나옴
		}
	}
}
