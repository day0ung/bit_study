package work;

import java.util.Arrays;

public class ObjectDto {
	private String name;
	private int age;
	private String hobby[];
	
	public ObjectDto() {
		// TODO Auto-generated constructor stub
	}

	public ObjectDto(String name, int age, String[] hobby) {
		super();
		this.name = name;
		this.age = age;
		this.hobby = hobby;
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

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "ObjectDto [name=" + name + ", age=" + age + ", hobby=" + Arrays.toString(hobby) + "]";
	}
	

	
	
	
	
}
