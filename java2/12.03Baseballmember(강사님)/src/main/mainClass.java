package main;



import java.util.Scanner;

import dao.MemberDao;

public class mainClass {
	//프론트엔드
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MemberDao dao = new MemberDao();
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
				dao.insert();
				break;
			case 2:
				dao.select();
				break;
			case 3:
				dao.delete();
				break;
			case 4:
				dao.update();
				break;
			case 5:
				dao.allprint();
				break;
			case 6: 
				dao.saveData();
			default:
				System.out.println("잘못입력하셨습니다.");
				break;
			}

		}
	}
}
