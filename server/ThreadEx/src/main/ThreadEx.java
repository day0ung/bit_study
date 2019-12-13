package main;

public class ThreadEx extends Thread{
	
	String msg;
	
	public ThreadEx(String msg) {
		this.msg = msg;
	}

	@Override
	public void run() {		
		super.run();
		
		// for for for

        //for for for 문이 같이 돌고 있음. 원래 포문은 조건을 만족하고 나가면 포문 밖을 나가서 다른 런함수에 가서 돌지만
        // 스레드는 그렇지 않고 여러개가 돌고있음 그니까 원래대로라면 퐁이 10번나오고 당이 10나오고 !!가 열번나와야 하는데
        // 지금보면 퐁당!! !!당퐁 이런식으로 공평하게 같이 나옴. 
		for (int i = 0; i < 10; i++) {
			System.out.println(msg);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
	

}
