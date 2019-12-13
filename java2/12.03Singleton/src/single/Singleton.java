package single;

public class Singleton {
	
	private static Singleton single = null; //static 공간은 garbage collector가 못건들임
	
	//마이클래스를 넘겨줘야할 공간만들때 public
	public int num;
	
	//성춘향이름
	public String name;
	
	private Singleton() {//규칙이있음 다시는 못만들게 private을 생성자에 붙임, 이렇게하면 메인에서 접근을못함
	}
	
	public static Singleton getInstance() { //static메소드는 클래스명. 하고 호출함
		if(single == null) { //위에  rivate static Singleton single = null; 해줬으니 생성이됨 
			single = new Singleton(); //내부에서 생성은 가능함  생성이 되야 변수에접근가능함
		}
		return single; //아까만들어진 그인스턴스로 가라 이말이야(조건문으로들어가는거아니구, 아까만든 그주소값)
		//인스턴스 한번만생성해놓고 그인스턴스를 계속호출해줌
	}
}
