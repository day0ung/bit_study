package bcls;

import single.Singleton;

public class YouClass {
	
	private int youNum;
    /*
	public void setYouNum(int youNum) {
		this.youNum = youNum;
	}
	*/
	public void method() {
		Singleton single = Singleton.getInstance();
		//넣어주기
		youNum = single.num;
		//싱글턴넘버엥 있는것을 you에 넣어줌
		
		System.out.println("youNum ="+ youNum);
	}

}
