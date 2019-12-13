package dto;

public class Human {
	private int number;
	private String name;
	private int age;
	private double height;
	private String birth;
	
	public Human() {
		// TODO Auto-generated constructor stub
	}

	public Human(int number, String name, int age, double height, String birth) {
		super();
		this.number = number;
		this.name = name;
		this.age = age;
		this.height = height;
		this.birth = birth;
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

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}
	public void information() {
		System.out.println("이름: "+ name);
		System.out.println("나이: "+ age);
		System.out.println("신장: "+ height);
		System.out.println("생일: "+ birth);
	}

	@Override
	public String toString() {
		return number + "-" + name + "-" + age + "-" + height + "-" +birth;
	}
	
}
