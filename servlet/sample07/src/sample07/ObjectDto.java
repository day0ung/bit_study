package sample07;

import java.io.Serializable;

public class ObjectDto implements Serializable{ //Serializable 직렬화 >>내부적으로 
	private String name;
	private int age;
	private String fluit[];
	
	public ObjectDto() {

	}

	public ObjectDto(String name, int age, String[] fluit) {
		super();
		this.name = name;
		this.age = age;
		this.fluit = fluit;
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

	public String[] getFluit() {
		return fluit;
	}

	public void setFluit(String[] fluit) {
		this.fluit = fluit;
	}
	
	
}
