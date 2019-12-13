
public class MemberDTO {
	private int number;
	private String name;
	
	public MemberDTO() {

	}

	public MemberDTO(int number, String name) {
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

	@Override
	public String toString() {
		return "MemberDTO [number=" + number + ", name=" + name + "]";
	}
	
}
