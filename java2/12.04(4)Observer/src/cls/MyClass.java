package cls;

import java.util.Observable;

public class MyClass extends Observable { //감시를 해야될 클래스 (감시용클래스) Observable >> 감시자역할을할수 있게 만들어 놓는 상위클래스
	
	private String preArg = null;
	
	
	//일반메소드 
	@Override
	public void notifyObservers(Object arg) {
		
		String str = (String)arg; //문자열이 넘어옴
		
		//파라매터로 들어온 문자열과 비교 		
		//변화가 없을때 
		if(str.equals(preArg)) return; //빠져나감 밑에작업안해줌
		
		//변화가 있을때(데이터가 변경되었을떄)
		preArg = str;
		
		//부모클래스의 메소드 observable
		setChanged(); //reset이 된다.
		
		super.notifyObservers(arg);
		clearChanged();
	}

		
	
	
}
