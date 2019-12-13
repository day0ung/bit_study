
public class MemberDTO {
	//data transfer object
	//파일철에들어가는 종이한장..(설계부분)
	private int number;
	private String name;
	private int age;
	private String address;
	
	//생성자 꼭 만들어야함
	
	public MemberDTO() {
		
	}
	//모든값을담은 생성자 만들어야함	
	public MemberDTO(int number, String name, int age, String address) {
		super();
		this.number = number;
		this.name = name;
		this.age = age;
		this.address = address;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "MemberDTO [number=" + number + ", name=" + name + ", age=" + age + ", address=" + address + "]";
	}
	

}
