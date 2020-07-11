package dto;

import java.io.Serializable;

public class CustUserDto implements Serializable {
	
	private int number;
	private String name;
	
	public CustUserDto() {

	}

	public CustUserDto(int number, String name) {
		super();
		this.number = number;
		this.name = name;
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
	
	
}
