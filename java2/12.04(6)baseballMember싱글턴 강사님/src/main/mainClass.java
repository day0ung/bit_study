package main;

import java.util.Scanner;

import dao.AllprintClass;
import dao.DaoInterface;
import dao.DeleteClass;
import dao.InsertClass;
import dao.SelectClass;
import dao.UpdateClass;
import file.DataClass;

public class mainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//데이터불러오기,
		//InsertClass insert = new InsertClass(); 해도됨
		
		//싱글턴을 먼저부르고나서, 파일을 불러야함
		DataClass dataCls = new DataClass("baseball");
		//싱글턴호출해놓는게 좋음, 
		dataCls.readFile(); //데이터 쭉들어옴
		
		while(true) {
			DaoInterface dao = null;
			int choice = 0;
			System.out.println(">>>>>>>>> menu ");
			System.out.println("1.선수등록");
			System.out.println("2.선수삭제");
			System.out.println("3.선수검색");
			System.out.println("4.선수수정");
			System.out.println("5.선수들 출력");
			System.out.println("6.파일저장");
			
			System.out.print("메뉴번호 =");
			choice = sc.nextInt();
			switch(choice) {
				case 1:
					dao = new InsertClass();
					break;
				case 2:
					dao = new DeleteClass();
					break;
				case 3:
					dao = new SelectClass();
					break;
				case 4:
					dao = new UpdateClass();
					break;
				case 5:
					dao = new AllprintClass();
					break;
				case 6:
					dataCls.writeFile();
					break;					
			}
			if(dao != null) {
			dao.process();
			}
		}
	}
}
