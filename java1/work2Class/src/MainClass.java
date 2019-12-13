import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		Scanner sc = new Scanner(System.in);
		while (true) {
			// DAO Data Access Object
			// >> insert delete select update 이것을 다루는 클래스
			System.out.println("1.데이터의 추가(insert) "); //create (CRUD =DAO)
			System.out.println("2.데이터의 삭제 (delete)"); //delete
			System.out.println("3.데이터의 검색 (select)"); //read
			System.out.println("4.데이터의 수정 (update)"); //update
			System.out.println("5.데이터의 모두출력 ");

			System.out.print("메뉴번호를 입력해주십시오>>");
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					dao.insert();
					break;
				case 2:
					dao.delete();
					break;
				case 3:
					dao.select();
					break;
				case 4:
					dao.update();
					break;
				case 5:
					dao.allPrint();
					break;
				case 6:
					System.exit(0); //강제종료(평상시사용잘안함)
					break;
				default:	
					System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
}
