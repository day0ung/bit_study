package 성적통계프로그램arraylist과제;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentDAO {
	Scanner sc = new Scanner(System.in);
	private ArrayList<StudentDTO> list;
	
	public StudentDAO() {
		list = new ArrayList<StudentDTO>();
		list.add(new StudentDTO("이씨", 13, 90, 80, 80));
		list.add(new StudentDTO("김씨", 15, 70, 35, 60));
		list.add(new StudentDTO("박씨", 16, 100, 100, 100));
		
	}

	//1.학생정보 추가(이름, 나이, 영어, 수학)
	public void insert() {
		System.out.println("--학생정보추가--");
		System.out.print("이름: ");
		String name = sc.next();
		
		System.out.print("나이: ");
		int age = sc.nextInt();
		
		
		System.out.print("국어점수: ");
		int kor = sc.nextInt();
		
		System.out.println("영어점수: ");
		int eng = sc.nextInt();
		
		System.out.println("수학점수: ");
		int math = sc.nextInt();
		
		list.add(new StudentDTO(name, age, kor, eng, math));
	
	}
	
	 // 2.학생정보 삭제
	public void delete() {
		int findIndex;

		System.out.print("삭제할 이름");
		String name = sc.next();

		findIndex = search(name);

		if (findIndex == -1) {
			System.out.println("학생정보가 없습니다.");
		} else {
			list.remove(findIndex);
		}
	}
	
	// 3.학생정보 검색
	public void select() {
		int findIndex;
		
		System.out.print("검색할 이름");
		String name = sc.next();
		
		findIndex = search(name);
		
		if(findIndex == -1) {
			System.out.println("학생정보가 없습니다.");
		}else {
			StudentDTO dto = new StudentDTO();
			System.out.println("---학생정보---");
			System.out.println(list.get(findIndex).toString());
		}
	}
	
	//4.학생정보 수정
	public void update() {
		int findIndex;
		
		System.out.print("수정할 이름");
		String name = sc.next();
		
		findIndex = search(name);
		
		if(findIndex == -1) {
			System.out.println("학생정보가 없습니다.");
		}else {
			System.out.println("수정할 국어점수입력");
			int kor = sc.nextInt();
			System.out.println("수정할 영어점수입력");
			int eng = sc.nextInt();
			System.out.println("수정할 수학점수입력");
			int math = sc.nextInt();
			
			StudentDTO dto = list.get(findIndex);
			dto.setKor(kor);
			dto.setEng(eng);
			dto.setMath(math);
			System.out.println("수정완료");
			
			for (int i = 0; i < list.size(); i++) {	
				dto = list.get(i);
			
	
		}
			
			
			
		}
	}
	//삭제, 검색, 수정, 조회 에 필요한 메소드
	public int search(String name) {
		
		int findIndex = -1;
		for (int i = 0; i < list.size(); i++) {
			StudentDTO dto = list.get(i);
			if(name.equals(dto.getName())) {
				findIndex = i;
				break;
			}
		}
		return findIndex;
	}
	
	//5.학생성적 조회(1명)  총점
	public void student_one_sum_avg() {
		int findIndex;
		
		System.out.print("학생총점을 검색할 이름 =");
		String name = sc.next();
		
		findIndex = search(name);
		
		if(findIndex == -1) {
			System.out.println("학생정보가 없습니다.");
		}else {
			StudentDTO dto = new StudentDTO();
			int kor = list.get(findIndex).getKor();
			int eng = list.get(findIndex).getEng();
			int math =list.get(findIndex).getMath();
			int sum = kor+eng+ math;
			double avg = (double)sum /3;
			System.out.println("총점:" +sum);
			System.out.println("평균:" +avg);
	}
	}
	//6.전체 학생성적 총점
	public void allSum() {
		int sum = 0;

		for (int i = 0; i < list.size(); i++) {
			StudentDTO dto = list.get(i);
			if(dto != null && !dto.getName().equals("")) {
				int kor = list.get(i).getKor();
				int eng = list.get(i).getEng();
				int math =list.get(i).getMath();
				sum = sum + kor+eng+ math;
				
			}
		}
		System.out.println("전체학생총점: "+sum);
	}
	//7.전체 학생성적 평균
	public void allAvg() {
		double avg;
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			StudentDTO dto = list.get(i);
			if(dto != null && !dto.getName().equals("")) {
				int kor = list.get(i).getKor();
				int eng = list.get(i).getEng();
				int math =list.get(i).getMath();
				sum = sum + kor+eng+ math;			
			}
		}
		avg = (double)sum/list.size();
		System.out.println("전체학생 평균: "+avg);
	}
	//8.학생 성적순 출력
	public void stuendtSort() {

		//정렬을할 어레이리스트
		ArrayList<StudentDTO> sortlist = new ArrayList<StudentDTO>( list );
		//리스트의 값들이 소트리스트에 들어가있음
		StudentDTO dto = new StudentDTO();
		int sum[] = new int[list.size()];
		
		for (int i = 0; i < list.size(); i++) {
			int kor = list.get(i).getKor();
			int eng = list.get(i).getEng();
			int math =list.get(i).getMath();
			sum[i] = kor + eng + math;
		}
		//
		System.out.println("코드확인용");
		for (int i = 0; i < sum.length; i++) {
			System.out.println(sum[i]);
		}
		//리스트사용하기...
	    StudentDTO temp;
		for (int i = 0; i < sum.length; i++) {
			for (int j = i; j < sum.length; j++) {
				StudentDTO sdj = sortlist.get(j);
				if(sum[i] < sum[j]) {
		
					temp = list.get(i);
					sortlist.set(i, sdj);
					sortlist.set(j, temp);
					
					
					
				}
			}
		}
		
		System.out.println("코드재확인용");
		for (int i = 0; i < sortlist.size(); i++) {
			System.out.println(sortlist.get(i));
		}
//		for (int i = 0; i < list.size(); i++) {
//			for (int j = 0; j < sum.length; j++) {		
//				dto = list.get(i);
//			}
//			System.out.println(list.get(index[i]));
//		}
		
		
		//내림정렬 temp없이하기
		for (int i = 0; i < sum.length; i++) {
			for (int j = 0; j < sum.length; j++) {
				StudentDTO sdi = sortlist.get(i);
				StudentDTO sdj = sortlist.get(j);
				StudentDTO li = list.get(i);
				
				li = sdi;
				list.set(i, sdi); //위의코드와 같은소리
				sortlist.set(i, sdj);
				sortlist.set(j, li);
				//원본데이터 리스트를 복사해온자리에 소트리스트의 번호를 집어넣는다.
			}
		}
		
		

		
		

	}
}
