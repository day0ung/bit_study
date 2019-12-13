package ccls;

import single.Singleton;

public class HeClass {
	private String name;
	private String heName;
	
	public HeClass() {
		name = "성춘향";
		//이이름을 마이클래스에 넘겨주고싶다.
		//name이라는 공간이 싱글턴에잇어야함
		Singleton s = Singleton.getInstance();
		s.name = name;  //싱글턴 소속의 네임에 성춘향이라는 밸유값을넘겨줌 >> 마이클래스로이동(my method)
		
	}
	
	public void heMethod() {
		Singleton s= Singleton.getInstance();
		heName = s.name;
		System.out.println("haName = " + heName);
	}
}
