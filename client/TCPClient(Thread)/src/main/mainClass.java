package main;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class mainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
			1. 접속을 해야 할 Server IP(주소)를 설정 - Socket
			2. Socket 생성			
			3. 접속 connect
			
			4. packet 전송
		*/
		
		InetSocketAddress sockAddr = new InetSocketAddress("192.168.2.22", 9000);
		
		Socket socket = new Socket();
		
		try {
			//server 접속
			socket.connect(sockAddr, 10000);
			InetAddress inetAddr;
			
			if((inetAddr = socket.getInetAddress()) != null) {
				System.out.println("서버연결 성공: " +inetAddr);
			}else {
				System.out.println("서버연결 실패 ");
			}
			
			new ReadThread(socket).start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
