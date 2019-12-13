package cls;

import writer.WriteMode;

public class Pencil implements WriteMode {

	@Override
	public void writer() {
		System.out.println("연필로 기입을 합니다.");
	}
	
	public void erase() {
		System.out.println("지우개로 지웁니다.");
	}

}
