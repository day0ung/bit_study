package 성적통계프로그램arraylist과제;

public class StudentMain {
	public static void main(String[] args) {
		/*		각각함수로만듦
		 *  String student[][];
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
		StudentDAO dao = new StudentDAO();


		dao.stuendtSort();
	}
}
