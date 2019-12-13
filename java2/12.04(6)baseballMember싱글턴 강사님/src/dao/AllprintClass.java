package dao;

import java.util.Iterator;

import dto.Human;
import single.Singleton;

public class AllprintClass implements DaoInterface{
	public AllprintClass() {
		
	}
	
	public void process() {
		Singleton s = Singleton.getInstance();
		Iterator<String> it = s.map.keySet().iterator();
		
		while(it.hasNext()) {
			String key =it.next();
			Human h = s.map.get(key); //휴먼데이터가나옴
			System.out.println(h.toString()); //피처건배터건 상속받은부분의 toString이 나옴
		}
	}
}
