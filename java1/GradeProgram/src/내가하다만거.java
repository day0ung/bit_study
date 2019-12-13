import java.util.Scanner;

public class 내가하다만거 {
	public static void main(String[] args) {
		
		/*		각각함수로만듦
		 *  String str[][];
		 *  1.학생정보 추가(이름, 나이, 영어, 수학)
		 *  2.학생정보 삭제
		 *  3.학생정보 검색
		 *  4.학생정보 수정
		 *  5.학생성적 조회(1명)  총점
		 *  6.전체 학생성적 총점
		 *  7.전체 학생성적 평균
		 *  8.학생 성적순 출력
		 *  
		 *  어느작업을 하시겠습니까?
		 */
		//선언부 필요한것
		String datas[][] = new String[10][4];
		int choice = 0;

		Scanner scan = new Scanner(System.in);
		//기본데이터
				datas[0][0] = "김창렬";
				datas[0][1] = "43";
				datas[0][2] = "20";
				datas[0][3] = "20";
				
				datas[1][0] = "김혜자";
				datas[1][1] = "51";
				datas[1][2] = "100";
				datas[1][3] = "100";


		// [회원수][정보]
		while(true) {
			System.out.println("1.학생정보 추가");
			System.out.println("2.학생정보 삭제");
			System.out.println("3.학생정보 검색");
			System.out.println("4.학생정보 수정");
			System.out.println("5.학생성적 조회(1명)  총점");
			System.out.println("6.학생성적 총점");
			System.out.println("7.학생성적 평균");
			System.out.println("8.학생 성적순 출력");
			System.out.println("----------------------");
			System.out.println("어느작업을 하시겠습니까?");
			choice =scan.nextInt();
			if (choice == 1) {
			  insert(datas);
			}
			else if(choice ==2) {//정보삭제
				delete(datas, scan);
			}
			else if(choice ==3) { //정보검색
				find(datas, scan);				
			}
			else if(choice ==4) { //정보수정
				update(datas, scan);
			}
			else if(choice ==5) { //학생성적 조회(1명)  총점
				oneTotalScore(datas, scan);
			}
			else if(choice ==6) { //학생성적 총점
			}
			else if(choice ==7) { //학생성적평균
			}
			else if(choice ==8) { //성적순 출력
			}
		}

	}
	private static void oneTotalScore(String[][] datas, Scanner scan) {
		//조회할 학생
		System.out.print("총점을 조회할 학생이름입력:");
		String name = scan.next();
		int sum[] = new int[datas.length];
		
		int findIndex = -1;
		for (int i = 0; i < datas.length; i++) {
			if(name.equals(datas[i][0])) {
				findIndex = i;
				break;
			}
		}
		
		
		if(findIndex != -1) {
			for (int i = 0; i < datas.length; i++) {
				for (int j = 2; j < datas[0].length; j++) {
					sum[i] = Integer.parseInt(datas[i][j]); 
				}
			}
		}

	}
	private static void delete(String[][] deleteData, Scanner scan) {
		System.out.print("학생이름: ");
		String name = scan.next();
		int findIndex = -1;
		
		for (int i = 0; i < deleteData.length; i++) { //이름이 같은지 확인하는것
			if(name.equals(deleteData[i][0])) {
				findIndex = i;
				break;
			}
		}
		
		String[] colunm = {"이름", "나이", "영어점수", "수학점수"};
		if(findIndex == -1) {
			System.out.println("삭제할 학생의 정보를 찾을 수 없습니다.");
		}else {
			System.out.println("----기존정보----");
			for (int i = 0; i < colunm.length; i++) {			
					System.out.println(colunm[i]+ " : " + deleteData[findIndex][i]);
				}
				deleteData[findIndex][0] = "";
				deleteData[findIndex][1] = "";
				deleteData[findIndex][2] = "";
				deleteData[findIndex][3] = "";								
			}
			System.out.println("삭제완료");
		}
		

	private static void update(String[][] datas, Scanner scan) {
		System.out.print("학생 이름: ");
		String name = scan.next();

		int findIndex = -1; //
		for (int i = 0; i < datas.length; i++) {
			if (name.equals(datas[i][0])) {
				findIndex = i;
				break;
			}
		}
		String colunm[] = {"이름", "나이", "영어점수", "수학점수"};
		if(findIndex == -1) {
				System.out.println("학생의정보를 찾을수 없습니다.");			
		}else {
			for (int i = 0; i < colunm.length; i++) {
			System.out.println(colunm[i]+ " : " + datas[findIndex][i]);
		}
		System.out.println("수정할 영어점수: ");
		String eng = scan.next();
		
		System.out.println("수정할 수학점수: ");
		String math = scan.next();
		
		datas[findIndex][2] = eng;
		datas[findIndex][3] = math;
		
		System.out.println("----수정한 정보----");
		
		for (int i = 0; i < colunm.length; i++) {
			System.out.println(colunm[i] + ":" + datas[findIndex][i]);
			}

		}

	}
	static void insert(String arr[][]) {

		Scanner scan = new Scanner(System.in);

		
		
		System.out.println("정보를 추가할 학생의 수를 입력하세요");
		int addNum = scan.nextInt();

		System.out.println((addNum)+ "명");
		arr = new String[addNum][4];

		for (int i = 0; i < arr.length; i++) {
					
			String name;
			String age;
			String eng;
			String math;
			
			System.out.println((i+1) + "번째학생");
			System.out.println("이름: ");
			name = scan.next();

			System.out.println("나이: ");
			age = scan.next();

			System.out.println("영어점수: ");
			eng = scan.next();

			System.out.println("수학점수: ");
			math = scan.next();

			arr[i][0] = name;
			arr[i][1] = age;
			arr[i][2] = eng;
			arr[i][3] = math;
			
		}
		
	}
	static void find(String findName[][], Scanner scan) {
		
		System.out.print("찾을 이름: ");
		String name = scan.next();

		int findIndex = -1; //
		for (int i = 0; i < findName.length; i++) {
			if (name.equals(findName[i][0])) {
				findIndex = i;
				break;
			}
		}
		String colunm[] = {"이름", "나이", "영어점수", "수학점수"};
		if(findIndex == -1) {
				System.out.println("학생의정보를 찾을수 없습니다.");			
		}else {
			for (int i = 0; i < colunm.length; i++) {
			System.out.println(colunm[i]+ " : " + findName[findIndex][i]);
			}

		}

	}
}
