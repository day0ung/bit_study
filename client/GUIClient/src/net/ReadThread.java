package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import view.ClientFrame;

public class ReadThread extends Thread {

	Socket socket;
	ClientFrame cf;
	public ReadThread(Socket socket, ClientFrame cf) {
		this.socket = socket;
		this.cf = cf;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String str = br.readLine();
			if(str ==null) {
				System.out.println("접속끊김");
			}
			cf.textA.append(str + "\n"); 
			Thread.sleep(300);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
