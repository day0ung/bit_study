package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class ServerThread extends Thread {
	Socket socket; //담당자 (내꺼)
	List<Socket> list; //소켓안에있는 것을 리스트로 만듦
	
	public ServerThread(Socket socket, List<Socket> list) {
		this.socket = socket;
		this.list = list;
		
	}

	@Override
	public void run() { // 오버라이드 나오게 thread에 있는 (run) 선택
		// TODO Auto-generated method stub
		super.run();
		try {
			// 1.recv
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String str = reader.readLine();
			System.out.println("클라이언트로 부터 받은 메시지: "+ str);
			//2.send
			for(Socket sock: list) { //sock = client소켓 list에 담당자가 생기니까 
				if(socket != sock) { //자기자신이아닐떄 채팅을보낼때 나자신이 아닌 다른사람에게 보내야하니까
					PrintWriter writer = new PrintWriter(sock.getOutputStream());
					writer.println(str);
					writer.flush();
					
				}
			}
			Thread.sleep(300); //잠시휴식...
			//스레드시작하면 본체에 깜박거리는것, 일정하게 잡아주는것, 
		} catch (Exception e) {
			System.out.println("연결이 끊긴 IP:" + socket.getInetAddress());
			list.remove(socket);
		} 
		
		//남은 클라이언트 확인
		for (Socket s : list) {
			System.out.println("접속되어 있는 IP:" + s.getInetAddress()
							+ " Port:" + s.getPort());
		}	
		try {
			socket.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	
}
