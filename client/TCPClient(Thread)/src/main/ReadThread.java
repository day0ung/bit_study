package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReadThread extends Thread{
	
	Socket socket;
	
	public ReadThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		super.run();
		
		try {
			BufferedReader reader = new BufferedReader
					(new InputStreamReader(socket.getInputStream()));
			String str = reader.readLine();
			System.out.println("서버로부터 받은 메시지");
			
			Thread.sleep(300);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	

}
