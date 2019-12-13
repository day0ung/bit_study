package main;

import java.util.Scanner;

import dao.Delete;
import dao.Insert;
import dao.Select;
import dao.Sorting;
import dao.Update;


public class MainClass {

	public static void main(String[] args) {
		Insert insert = new Insert();
		Delete delete = new Delete();
		Select select = new Select();
		Update update = new Update();
		Sorting sorting = new Sorting();
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("야구 선수등록프로그램");
			System.out.println("1.선수추가");
			System.out.println("2.선수검색");
			System.out.println("3.선수삭제");
			System.out.println("4.선수정보수정");
			System.out.println("5.선수정보보기");
			System.out.println("6.데이터저장");
			System.out.print("번호입력 >>>");
			int choice = scan.nextInt();

			switch (choice) {
			case 1:
				insert.input();
				break;
			case 2:
				select.search();
				break;
			case 3:
				delete.delete();
				break;
			case 4:
		
				break;
			case 5:
				insert.allprint();
				break;
			case 6: 
				
			default:
				System.out.println("잘못입력하셨습니다.");
				break;
			}

		}
	}

}
