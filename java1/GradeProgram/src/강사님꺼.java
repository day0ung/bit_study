import java.util.Scanner;

public class 강사님꺼 {
	public static void main(String[] args) {

		/*
		  	String student[][];
		 	 
			1.학생정보 추가	(이름, 나이, 영어, 수학)
			2.학생정보 삭제
			3.학생정보 검색
			4.학생정보 수정
			5.학생성적 조회(1명)	총점  평균
			6.전체 학생성적 총점
			7.전체 학생성적 평균			 
			8.학생성적순 출력
			
			어느 작업을 하시겠습니까?
		*/
		
	//	String student[][] = new String[10][4];		
		/*
		for (int i = 0; i < student.length; i++) {
			for (int j = 0; j < student[0].length; j++) {
				student[i][j] = new String("");
			}			
		}
		*/
				
	//	insert(student);
		
	//	insert(student);
		
	//	delete(student);
		
	//	select(student);
		
	//	update(student);
		
	//	student_one_sum_avg(student);
		
	//	student_all_sum(student);
		
	//	student_all_avg(student);
		
		
		String student[][] = {
				{ "홍길동", "24", "100", "90" },
				{ "성춘향", "16", "100", "95" },
				{ "", "", "", "" },
				{ "일지매", "22", "80", "70" },
				{ "정수동", "25", "95", "85" }
		};
		
		student_sort(student);
		
		
	}
	
	static void insert(String student[][]) {
		Scanner sc = new Scanner(System.in);
		
		// next node == null 찾는다
		int nextNode = 0;
		for (int i = 0; i < student.length; i++) {
//			for (int j = 0; j < student[i].length; j++) {
				if(student[i][0] == null) {
					nextNode = i;
					break;
				}
//			}
		}		
		System.out.println("nextNode = " + nextNode);
		
		String column[] = { "name", "age", "eng", "math" };
		
		for (int i = 0; i < column.length; i++) {
			System.out.print(column[i] + " = ");
			student[nextNode][i] = sc.next();
		}
		
		for (int i = 0; i < column.length; i++) {
			System.out.print(student[nextNode][i] + " ");
		}		
		System.out.println("\n데이터가 등록 되었습니다");
		
		/*
		System.out.print("name = ");
		String name = sc.next();
				
		student[nextNode][0] = name;
		*/
	}
	
	static void delete(String student[][]) {
		Scanner sc = new Scanner(System.in);
		
		// 입력
		System.out.print("삭제할 학생의 이름을 입력 = ");
		String name = sc.next();
		
		// 찾기
		int findIndex = -1;
		for (int i = 0; i < student.length; i++) {
			if(name.equals(student[i][0])) {
				findIndex = i;
				break;
			}
		}
		
		// 삭제
		if(findIndex == -1) {
			System.out.println("학생데이터를 찾을 수 없습니다");
		}else {
			for (int i = 0; i < student[0].length; i++) {
				student[findIndex][i] = "";
			}
			System.out.println("학생데이터를 삭제하였습니다");
		}		
	}
	
	static void select(String student[][]) {
		Scanner sc = new Scanner(System.in);
		
		// 입력
		System.out.print("검색할 학생의 이름을 입력 = ");
		String name = sc.next();
		
		// 찾기
		int findIndex = -1;
		for (int i = 0; i < student.length; i++) {
			if(name.equals(student[i][0])) {
				findIndex = i;
				break;
			}
		}
		
		if(findIndex == -1) {
			System.out.println("학생데이터를 찾을 수 없습니다");
		}
		else {
			System.out.println("학생데이터를 찾았습니다");
			System.out.println("이름:" + student[findIndex][0]);				
			System.out.println("나이:" + student[findIndex][1]);
			System.out.println("영어:" + student[findIndex][2]);
			System.out.println("수학:" + student[findIndex][3]);			
		}		
	}
	
	static void update(String student[][]) {
		Scanner sc = new Scanner(System.in);
		
		// 입력
		System.out.print("수정할 학생의 이름을 입력 = ");
		String name = sc.next();
		
		// 찾기
		int findIndex = -1;
		for (int i = 0; i < student.length; i++) {
			if(name.equals(student[i][0])) {
				findIndex = i;
				break;
			}
		}
		
		if(findIndex == -1) {
			System.out.println("학생데이터를 찾을 수 없습니다");
		}
		else {
			System.out.println("학생데이터를 찾았습니다");
			System.out.println("수정할 점수를 입력해 주십시오");
			System.out.print("영어 = ");
			String eng = sc.next();			
			System.out.print("수학 = ");
			String math = sc.next();
			
			student[findIndex][2] = eng;
			student[findIndex][3] = math;
			
			System.out.println("점수를 수정하였습니다");
			System.out.println("영어:" + student[findIndex][2]);
			System.out.println("수학:" + student[findIndex][3]);	
		}
	}
	
	static void student_one_sum_avg(String student[][]) {
		Scanner sc = new Scanner(System.in);
		
		// 입력
		System.out.print("총점과 평균점수를 산출할 학생의 이름을 입력 = ");
		String name = sc.next();
		
		// 찾기
		int findIndex = -1;
		for (int i = 0; i < student.length; i++) {
			if(name.equals(student[i][0])) {
				findIndex = i;
				break;
			}
		}
		
		if(findIndex == -1) {
			System.out.println("학생데이터를 찾을 수 없습니다");
		}
		else {
			System.out.println("이름:" + student[findIndex][0]);
			int eng = Integer.parseInt(student[findIndex][2]);
			int math = Integer.parseInt(student[findIndex][3]);
			
			int sum = eng + math;
			double avg = (double)sum / 2;
			
			System.out.println("총점:" + sum);
			System.out.println("평균:" + avg);
		}
	}
	
	static void student_all_sum(String student[][]) {
		int sum = 0;
		
		for (int i = 0; i < student.length; i++) {
			if(student[i][0] != null && !student[i][0].equals("")) {
				sum = sum + Integer.parseInt(student[i][2]);
				sum = sum + Integer.parseInt(student[i][3]);
			}
		}
		
		System.out.println("전체 학생의 총점:" + sum);		
	}
	
	static void student_all_avg(String student[][]) {
		
		// 각 학생의 합계에 대한 평균
		// 학생 몇명?
		int count = 0;
		for (int i = 0; i < student.length; i++) {
			if(student[i][0] != null && !student[i][0].equals("")) {
				count++;
			}
		}
		System.out.println("count:" + count);
		
		if(count == 0) {
			System.out.println("학생이 한명도 등록되어 있지 않습니다");
			return;
		}
		
		int sum[] = new int[count];
		
		int j = 0;
		for (int i = 0; i < student.length; i++) {	// 0 2 3
			if(student[i][0] != null && !student[i][0].equals("")) {
				sum[j] = sum[j] + Integer.parseInt(student[i][2]);
				sum[j] = sum[j] + Integer.parseInt(student[i][3]);
				j++;
			}
		}
		
		int allSum = 0;
		for (int i = 0; i < sum.length; i++) {
			allSum = allSum + sum[i];
		}
		
		double allAvg = (double)allSum / count;
		
		System.out.println("학생들의 총점에 대한 평균:" + allAvg);
				
	}
	
	static void student_sort(String student[][]) {
		String studentSort[][];
		int count = 0;
		
		for (int i = 0; i < student.length; i++) {
			if(student[i][0] != null && !student[i][0].equals("")) {
				count++;			
			}
		}
		System.out.println("count:" + count);
		
		studentSort = new String[count][4];
		int val = 0;
		for (int i = 0; i < student.length; i++) {
			if(student[i][0] != null && !student[i][0].equals("")) {
				studentSort[val][0] = student[i][0]; 
				studentSort[val][1] = student[i][1];
				studentSort[val][2] = student[i][2];
				studentSort[val][3] = student[i][3];
				val++;
			}
		}		
		
		for (int i = 0; i < studentSort.length; i++) {
			for (int j = 0; j < studentSort[0].length; j++) {				
				System.out.print(studentSort[i][j] + " ");
			}
			System.out.println();
		}		
		
		// 내림 정렬		
		int sum[] = new int[studentSort.length];
		
		for (int i = 0; i < studentSort.length; i++) {
			sum[i] = sum[i] + Integer.parseInt(studentSort[i][2]);	// 영어
			sum[i] = sum[i] + Integer.parseInt(studentSort[i][3]);	// 수학
		}
		
		for (int i = 0; i < sum.length; i++) {
			System.out.println("sum[" + i + "] = " + sum[i]);
		}
		
		String temp[];
		for (int i = 0; i < sum.length - 1; i++) {
			for (int j = i + 1; j < sum.length; j++) {				
				if(sum[i] < sum[j]) {
					temp = studentSort[i];
					studentSort[i] = studentSort[j];
					studentSort[j] = temp;
				}				
			}
		}
		
		for (int i = 0; i < studentSort.length; i++) {
			for (int j = 0; j < studentSort[0].length; j++) {
				System.out.print(studentSort[i][j] + " ");
			}	
			System.out.println();
		}
		
		
	}
	
	

}
