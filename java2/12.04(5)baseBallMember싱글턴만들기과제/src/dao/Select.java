package dao;

import java.util.Scanner;

import dto.Human;
import singleton.Singleton;

public class Select {
	Scanner scan = new Scanner(System.in);
	
	
	public void search() {
	System.out.println("검색하고 싶은 선수명을 입력해주십시오");
	System.out.print(">>");
	String name = scan.next();
	
	Human h = null;
	Singleton sin = Singleton.getInstance();
	
	h = sin.map.get(name);
	
	if(h == null || h.getName().equals("")) {
		System.out.println("데이터를 찾을 수 없습니다.");
		return;
	}
	//상속받아서 다시 기입할 수 있는 함수 불러오기(dto에서 만들기)
	System.out.println("검색된 선수 입니다.");
	h.information();
	
	}
}
