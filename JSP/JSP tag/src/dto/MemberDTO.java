package dto;

import java.io.Serializable;

public class MemberDTO implements Serializable{
	private String message;
	public MemberDTO() {
		
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
