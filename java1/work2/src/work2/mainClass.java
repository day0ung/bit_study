package work2;

import java.util.Scanner;

public class mainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// [회원수][정보]
		String datas[][] = new String[10][4];

		/*
		 * [0] : 번호 
		 * [1] : 이름 
		 * [2] : 나이 
		 * [3] : 주소
		 */

		int choice;
		int memberNumber = 0;
		//기본데이터
		datas[0][0] = "1001";
		datas[0][1] = "홍길동";
		datas[0][2] = "24";
		datas[0][3] = "서울시";
		
		datas[1][0] = "1002";
		datas[1][1] = "일지매";
		datas[1][2] = "22";
		datas[1][3] = "부산시";

		while (true) {
			// DAO Data Access Object
			// >> insert delete select update 이것을 다루는 클래스
			System.out.println("1.데이터의 추가(insert) "); //create (CRUD =DAO)
			System.out.println("2.데이터의 삭제 (delete)"); //delete
			System.out.println("3.데이터의 검색 (select)"); //read
			System.out.println("4.데이터의 수정 (update)"); //update
			System.out.println("5.데이터의 모두출력 ");

			System.out.print("메뉴번호를 입력해주십시오>>");
			choice = sc.nextInt();
			if (choice == 1) { // 데이터추가
				// 입력받는 부분

				System.out.println("====데이터추가====");
				System.out.print("번호: ");
				String number = sc.next();
				System.out.print("이름: ");
				String name = sc.next();
				System.out.print("나이: ");
				String age = sc.next();
				System.out.print("주소: ");
				String address = sc.next();

				datas[memberNumber][0] = number;
				datas[memberNumber][1] = name;
				datas[memberNumber][2] = age;
				datas[memberNumber][3] = address;							

				memberNumber++;

			}
			else if (choice == 2) { // 데이터 삭제, " " 배열은 삭제안되니까 빈칸
				// 입력받는 부분 
				//데이터삭제 검색, 수정은 검색을 동반해야함. 찾아야 삭제,수정함
				
				System.out.print("삭제할이름: ");
				String name = sc.next();
				
				//검색
				int findIndex = -1; //0 으로하면 index번호 0를 찾게되니까 -1함
				for (int i = 0; i < datas.length; i++) { //for문을 계속돌리면서찾음
					if (name.equals(datas[i][1])) { // datas[i][1]) 1번째는 name
						findIndex = i; //i번째는 findIndex이다. 번지수를 찾음. i번째와 findIndex가 같으면break;
						break;
					}
				}
				if(findIndex == -1) { //findIndex != -1)찾았다는 이야기
					System.out.println("삭제할 데이터를 찾을 수 없습니다.");
				}else {
					datas[findIndex][0] = "";
					datas[findIndex][1] = "";
					datas[findIndex][2] = "";
					datas[findIndex][3] = "";
					
					System.out.println("성공적으로 데이터를 삭제하였습니다.");
				}			
			} 
			else if (choice == 3) { // 데이터 검색 ,
				//입력
				System.out.print("검색할이름: ");
				String name = sc.next();
				
				//검색
				int findIndex = -1; //
				for (int i = 0; i < datas.length; i++) {
					if (name.equals(datas[i][1])) { // datas[i][1]) 1번째는 name
						findIndex = i;
						break;
					}
				}
				//출력
				String column[] = {"번호", "이름", "나이", "주소"};
 				if(findIndex == -1) { //findIndex != -1)찾았다는 이야기
					System.out.println("검색하신 데이터를 찾을 수 없습니다.");
				}else {
					for (int i = 0; i < column.length; i++) {
						System.out.println(column[i]+ ":" +datas[findIndex][i]); 
						//column[i]에  column[] = {"번호", "이름", "나이", "주소"};가 들어감
					}
				
				}

		
				
			} else if (choice == 4) { // 데이터 수정,
				//입력
				System.out.print("수정할이름: ");
				String name = sc.next();
				
				//검색
				int findIndex = -1; //
				for (int i = 0; i < datas.length; i++) {
					if (name.equals(datas[i][1])) {
						findIndex = i;
						break;
					}
				}
				//출력
				
 				if(findIndex == -1) { //findIndex != -1)찾았다는 이야기
					System.out.println("수정할 데이터를 찾을 수 없습니다.");
				}else {
					System.out.print("수정할주소: ");
					String address = sc.next(); //빈칸으로클릭하면 다시기입하라고해야함
					
					datas[findIndex][3] = address;
					System.out.println("성공적으로 데이터를 수정하였습니다.");
				}

			} else if (choice == 5) { // 데이터출력

				for (int i = 0; i < datas.length; i++) {
					for (int j = 0; j < datas[0].length; j++) {
						if(datas[i][j] != null && !datas[i][0].equals("")) {
						System.out.println("datas["+i+"]["+j+"] = "+datas[i][j]);
						}
					}
				}
			}			
		}
		
	}

}
