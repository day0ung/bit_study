package child;

import parents.ParentsClass;

public class ChildClass extends ParentsClass {
	private String name;
	
	public ChildClass() { //기본생성자
		super(); // super();기본생성자호출한다는뜻, 
		//부모클래스의 기본생성자가 없으면 여기서 에러남
		System.out.println("ChildClass ChildClass()");
	}
	
	public ChildClass(String name, int num) {
		super(num); //부모클래스있는데 까지 쭉올라감
		this.name = name;
		System.out.println("ChildClass ChildClass(String name)");
	}
}
