package ex;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class mainClass {
	public static void main(String[] args) {
		Socket clientSocket = null;
		
		try {
			ServerSocket serSocket = new ServerSocket(9000);
			System.out.println("접속대기중...");
			clientSocket = serSocket.accept();
			
			System.out.println("clinet IP:" + clientSocket.getInetAddress()
			+ "Port:" +clientSocket.getPort());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
