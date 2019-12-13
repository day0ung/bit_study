package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		   1. 접속을 해야할 서버의 IP (주소 설정) - Socket
		   2. Socket 생성
		   3. 접속 connect(항상 connect가 먼저임)
		   4. packet전송
		 */
											//192.168.2.22자신의 아이피지정
											//포트넘버는 내가지정해준 9000
		InetSocketAddress sockAddr = new InetSocketAddress("192.168.2.22", 9000);
		
		Socket socket = new Socket();
		
		//Server접속			//timeout접속이 언제까지 되다가 안되면 끊어라 (1000= 1초)
		try {
			socket.connect(sockAddr, 10000);
			
			InetAddress inetAddr;
			if((inetAddr = socket.getInetAddress()) != null) {
				System.out.println("서버연결 성공:" + inetAddr);
			}else {
				System.out.println("서버연결 실패");
			}
			while(true) {
				//input
				//패킷전송 (전송하고싶은 문자열)1.send
				System.out.print("전송 문자열: ");
				String str = sc.next();				//socket에 잇는부분을 outprint
				PrintWriter writer = new PrintWriter(socket.getOutputStream()); 
				writer.println(str); //실질적으로 전송되는것
				writer.flush(); //절대잊으면안됌!끝맺음
				
				//다시 받을것2. recive
				BufferedReader reader 
						= new BufferedReader(new InputStreamReader(socket.getInputStream()));
				str = reader.readLine();
				System.out.println("서버로부터 받은 메시지: " + str);
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
