package cls;

import writer.WriteMode;

public class Ballpen implements WriteMode {

	@Override
	public void writer() {
		System.out.println("볼펜으로 기입을 합니다.");

	}
	
	public void erase() {
		System.out.println("화이트로 지웁니다.");
	}
	
	

}
