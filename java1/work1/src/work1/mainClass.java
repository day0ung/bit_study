package work1;

import java.util.Scanner;

public class mainClass {
	public static void main(String[] args) {
		/*
		 * 성적통계 프로그램
		 * 
		 * 몇명의 학생의 점수를 입력?
		 * 
		 * 2차원배열 String [학생명수][정해져있음 4] 1 { 홍길동, 90, 85, 100} //한명(colum)의대한 데이터가
		 * 4개(변함이없음),
		 * 
		 * 
		 * 이름, 국어, 영어, 수학, // 행
		 * 
		 * 각 학생의 총점 sum 전체 학생의 총점 allSum 총점의 1등 max 총점의 꼴지 min
		 * 
		 */

		// 1.학생수 입력받는곳

		// 2.동적할당

		// 3.(절차지향)이름, 성적 입력받는곳: 이름 , 국어, 영어, 수학

		// 4. 각 학생의 총점

		// 5.전체학생의 총점

		// 6. 총점의 1등 & 꼴찌
//--------------------------------순서		
		// 선언부
		Scanner sc = new Scanner(System.in);
		// student[학생수][이름 + 과목]
		String student[][] = null; // 이름까지 해야하니까 int아니고 String
		int count;

		// 1.학생수 입력받는곳
		System.out.print("학생수: ");
		count = sc.nextInt();
		// 2.동적할당(산출해내는것이 중요함)
		student = new String[count][4];

		// 3.(절차지향)이름, 성적 입력받는곳: 이름 , 국어, 영어, 수학
		for (int i = 0; i < student.length; i++) {

			// for문을 돌리기전에 하나하나 집어넣어야함.아래먼저하고 for문으로 덮기
			System.out.print("이름:");
			String name = sc.next(); // 이름입력받는곳
			System.out.print("국어:");
			String kor = sc.next();
			System.out.print("영어:");
			String eng = sc.next();
			System.out.print("수학:");
			String math = sc.next();

			student[i][0] = name;
			student[i][1] = kor;
			student[i][2] = eng;
			student[i][3] = math;
		}
				
		// 4. 각 학생의 총점(따로출력하고싶으면 배열사용
		//합계를 낸 부분을 배열에다가 넣음
		int sum[] = new int[student.length];
		for (int i = 0; i < student.length; i++) {
			for (int j = 1; j < student[0].length; j++) { //뒤쪽  for문 4과목을 +할때까지 입력 
				//력 name =0도 같이 있으니 j = 1번째로j =1 국어부터 수학까지 점수를 가산하기 위함
				sum[i] += Integer.parseInt(student[i][j]);
				//각각 학생수에 맞춰서 합계가 들어갈것임
			}
		}
		

		// 5.전체학생의 총점
		int allSum = 0;
		for (int i = 0; i < student.length; i++) {
			for (int j = 1; j < student[0].length; j++) {
				allSum += Integer.parseInt(student[i][j]);
			}
		}
		
		//5-1.학생들의 총점의 평균점수
		double avg = 0.0;
		avg = (double)allSum / student.length;
		//주의사항: 형변환, allsum은 int이다.

		// 6. 총점의 1등 & 꼴지
		int max = sum[0]; //0으로 셋팅
		for (int i = 0; i < sum.length; i++) {
			if(sum[i] > max) {
				max = sum[i];
			}
		}
		//이점수를 맞춰보기 위하여 for문 돌림
		int findIndex = -1; //배열번호가 없음, 배열을찾을때는 
		//왜 -1인지? i의 값을넘겨주는것, 같은값이 여려명 있을 수도 있음 그거는 밑에서처리함
		for (int i = 0; i < sum.length; i++) {
			if(max == sum[i]) {
				findIndex = i;
			}
		}
		
		//각학생의 총점 출력
		 for (int i = 0; i < sum.length; i++) {
			System.out.println((i+1)+"번째 학생의 총점:"+ sum[i]);
		}
		//전체학생의 총점 출력
		 System.out.println("전체 학생의 총점:"+ allSum);
		//학생 총점의 평균점수
		 System.out.println("학생들의 총점의 평균 점수:"+avg);
		//총점의 1등 &꼴지 
		 
		//1등
		 for (int i = 0; i < student[0].length; i++) {	
		 System.out.println("학생들의 1등:"+student[findIndex][i]);
		 }	

	}

}
