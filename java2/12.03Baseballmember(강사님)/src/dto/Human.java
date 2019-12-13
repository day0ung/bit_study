package dto;

public class Human {
	private int number; //sequence number
	private String name;
	private int age;
	private double height;
	
	public Human() {
	
	}

	public Human(int number, String name, int age, double height) {
		super();
		this.number = number;
		this.name = name;
		this.age = age;
		this.height = height;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
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

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	//상속받아서 다시기입할수 있는 함수
	public void infomation() {
		//이름외의 나머지것들을 다시 기입해라
		System.out.println("이름: "+ name);
		System.out.println("나이: "+ age);
		System.out.println("신장: " + height);
	}
	
	@Override
	public String toString() {
		return  number + "-" + name + "-" + age + "-" + height;
	}
	
	
}
