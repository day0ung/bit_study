package main;

import java.net.ServerSocket;
import java.net.Socket;

public class mainClass {
	public static void main(String[] args)throws Exception {
		int MemberNum = 0;
		
		ServerSocket serSocket = new ServerSocket(9000); //문지기
		
		while(true) {
			System.out.println("대기중...");
			Socket socket = serSocket.accept();//담당자
			
			MemberNum++;
			
			new ObjectThread(socket, MemberNum).start();
			
		}
	}
}
