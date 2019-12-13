package dao;

import java.util.Scanner;

import dto.Human;
import singleton.Singleton;

public class Update {
	public Update() {

	}
	
	public void update() {
		
		
		Singleton s = Singleton.getInstance();
		Scanner scan = new Scanner(System.in);
		System.out.println("수정하고 싶은 선수명을 입력해주십시오");
		System.out.print(">>");
		String name = scan.next();
		
		Human h = null;
		h = s.map.get(name);
		
		if(h == null || h.getName().equals("")) {
			System.out.println("데이터를 찾을 수 없습니다.");
			return; //못찾고 튀어나감
		}
		
		
	}
}
