package single;

import java.util.HashMap;

import dto.Human;
import file.DataClass;

public class Singleton { //Delegate(=대리인)
	private static Singleton single = null;
	public HashMap<String, Human> map;
	public int MemNumber; //파일에서 번호 다시해줄때 더해주는값
	public DataClass dataCls = new DataClass("baseball");
	
	private  Singleton() {
		
		map = new HashMap<String, Human>();
	}
	
	public static Singleton getInstance() {
		if(single == null) {
			single = new Singleton();
		}
		return single;
	}
}
