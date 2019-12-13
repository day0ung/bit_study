package child;

import parent.ParentClass;

public class TomClass extends ParentClass {
	public void ParentMethod() { //over ride 된 메소드
		System.out.println("TomClass ParetMethod()");
	}
	
	public void func() {
		System.out.println("TomClass  func()");
	}
}
