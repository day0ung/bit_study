package main;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class mainClass {
	public static void main(String[] args) {
		Socket clientSocket = null;

		try {

			// 문지기 소켓
			ServerSocket serSocket = new ServerSocket(9000);
			// 자동으로 자신의 IP를 설정, binding, listen 포함

			List<Socket> list = new ArrayList<Socket>();

			while (true) {

				System.out.println("접속 대기중...");
				clientSocket = serSocket.accept();

				list.add(clientSocket);

				System.out.println("client IP:" + clientSocket.getInetAddress() + " Port:" + clientSocket.getPort());

				new ServerThread(clientSocket, list).start();
				/*
				 * // 1.recv BufferedReader reader = new BufferedReader(new
				 * InputStreamReader(clientSocket.getInputStream())); String str =
				 * reader.readLine(); System.out.println("클라이언트로부터 받은 메시지:" + str);
				 * 
				 * str = "반갑습니다";
				 * 
				 * // 2.send PrintWriter writer = new
				 * PrintWriter(clientSocket.getOutputStream()); writer.println(str); // 실질적으로 전송
				 * writer.flush();
				 */
			}

			// clientSocket.close();
			// serSocket.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}