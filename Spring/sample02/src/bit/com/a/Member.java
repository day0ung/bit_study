package bit.com.a;

import java.io.Serializable;

public class Member implements Serializable {
	private int age;
	private String name;
	private String address;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(int age, String name, String address) {
		super();
		this.age = age;
		this.name = name;
		this.address = address;
	}

	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Member [age=" + age + ", name=" + name + ", address=" + address + "]";
	}
	
	
	
	
}
