package WindowChange;

public class Singleton {
	
	private static Singleton single = null;
			
	public WindowOne win1;
	public WindowTwo win2;
	
	private Singleton() {
		win1 = new WindowOne();
		win2 = new WindowTwo();
	}
	
	public static Singleton getInstance() {
		if(single ==null) {
			single = new Singleton();
		}
		return single;
	}
}
