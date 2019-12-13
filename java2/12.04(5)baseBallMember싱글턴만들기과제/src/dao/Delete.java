package dao;

import java.util.Scanner;

import dto.Human;
import singleton.Singleton;

public class Delete {
	Scanner scan = new Scanner(System.in);
	
	public void delete() {
		System.out.println("방출하고 싶은 선수명을 입력해주십시오");
		System.out.print(">>");
		String name = scan.next();
		
		Singleton sin = Singleton.getInstance();
		Human h = null;
		h = sin.map.get(name);
		if(h == null || h.getName().equals("")) {
			System.out.println("데이터를 찾을 수 없습니다.");
			return; //그다음작업하지않게
		}
		
		h = sin.map.remove(name);
		System.out.println(h.getName()+ "의 데이터가 삭제 되었습니다.");
		
	}
}
