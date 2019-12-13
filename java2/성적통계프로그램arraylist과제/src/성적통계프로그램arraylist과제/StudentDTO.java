package 성적통계프로그램arraylist과제;

public class StudentDTO {
	String name;
	int age;
	int kor;
	int eng;
	int math;
	int sum;
	
	public StudentDTO() {
		
	}
	
	

	public StudentDTO(String name, int sum) {
		super();
		this.name = name;
		this.sum = sum;
	}



	public StudentDTO(String name, int age, int kor, int eng, int math) {
		super();
		this.name = name;
		this.age = age;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
	
	

	public int getSum() {
		return sum;
	}



	public void setSum(int sum) {
		this.sum = sum;
	}



	@Override
	public String toString() {
		return "학생정보 이름:" + name + ", 나이:" + age + 
				"국어점수:" + kor + "영어점수:" + eng +
				"수학점수:" + math + "]";
	}
	
	

}
