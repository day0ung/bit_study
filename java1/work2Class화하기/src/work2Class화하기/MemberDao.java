package work2Class화하기;

import java.util.Scanner;

public class MemberDao {
	MemberDTO dto[] = new MemberDTO[10];
	Scanner scan = new Scanner(System.in);
	
	public void loop() {
		int choice;
		while(true) {
			System.out.println("1.데이터의 추가(insert) ");
			System.out.println("2.데이터의 삭제 (delete)"); 
			System.out.println("3.데이터의 검색 (select)"); 
			System.out.println("4.데이터의 수정 (update)");
			System.out.println("5.데이터의 모두출력 ");

			System.out.print("메뉴번호를 입력해주십시오>>");
			choice = scan.nextInt();
			if(choice == 1) {
				insert();
			}else if(choice ==2) {
				
			}else if(choice ==3) {
				select();
			}else if(choice ==4) {
				
			}else if(choice ==5) {
				
			}
		}
		
	}
	
	public void insert() {
		for (int i = 0; i < dto.length; i++) {
			dto[i] = new MemberDTO();
		}
		int w = 0;
		System.out.println("추가할 데이터수입력");
		int add = scan.nextInt();
		if (add > 10 && add < 0) {
			System.out.println("다시입력해주세요");
		} else {
			while (w < add) {
				System.out.println((w + 1) + "번째 데이터추가");
				System.out.print("번호: ");
				dto[w].setNumber(scan.nextInt());
				System.out.print("이름: ");
				dto[w].setName(scan.next());
				System.out.print("나이: ");
				dto[w].setAge(scan.nextInt());
				System.out.print("주소: ");
				dto[w].setAddress(scan.next());
				w++;
			}
		}
	}
	
	public void delete() {
		System.out.print("삭제할이름: ");
		
	}
	public void select() {
		System.out.print("검색할이름: ");
		String name = scan.next();
		
		int findIndex = -1;
		for (int i = 0; i < dto.length; i++) {
			if(name.equals(dto[i].getName())){
				findIndex = i;
				break;
			}
		}
		String column[] = {"번호", "이름", "나이", "주소"};
		for (int i = 0; i < dto.length; i++) {
			if (dto[findIndex] == null && findIndex == -1) {
				System.out.println("검색하신정보를 찾울수 없습니다.");
			} else {
				for (int j = 0; j < column.length; j++) {
					MemberDTO dto = new MemberDTO();
					System.out.println(column[j] + ":" + dto);
				}

			}
		}
	}
	public void update() {
		
	}
	public void allPrint() {
		
	}
	
	
	}
	
	
	
	
		
		
	
	
	



