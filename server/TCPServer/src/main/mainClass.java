package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class mainClass {
	public static void main(String[] args) {
		
		/*
		    TCP: Transmission Control Protocol
		  			전송 			 제어 	 규약
		 	Server : TCP, DB, WEB(tomcat)  + WEB Socket
		 	
		 	종단 시스템 : host -네트워크 상에서 더 연장되지 않는 기기를 의미함
		 			  PC, SmartPhone, PDA, Scanner, Printer
		 	
		 	Router : Hardware
		 			 host 간에 상호데이터를 교환할 수 있도록 하는 장비
		 	
		 	 inter Network : 포괄적인 통신
		 	 
		 	 TCP - Transmission Control Protocol(동기 통신)
		 	 UDP - User Datagram Protocol		(비동기 통신)
		 	 
		 	 7 Layer 
		 	 1계층  Physical layer 	   물리계층
		 	 2계층  Data link layer	   주소를 헤더에 첨부
		 	 3계층  Network layer	           네트워크 IP ->Adress (숫자 4개로형성되어있는주소)
		 	 4계층  Transport layer	   네트워크 Port
		 	 5계층  Session layer		   세션부분을 동기화 
		 	 6계층  Presentation layer  보안, 압축, 확장
		 	 7계층  Application layer	  프로그램(소프트)
		 	 
		 	 TCP
		 	 신사적인 Protocol
		 	 전화 -> 상대방 -> 연결 ->통신 start
		 	 동기화 : 보낸다 -> 받는다 (처리 순서가 일치해야한다) 
		 	 데이터의 경계가 없다. 
		 	 1 대 1 통신만 가능하다
		 	 채팅에 많이 쓰임, Object(class)통채로 보낼 수 있다.
		 	 
		 	 UDP(속도더빠름)
		 	 비 연결형 Protocol 
		 	 ex)편지 편지보낼때 주소적고, 보내는사람, 받는사람 적음(확인은안함)
		 	 	지상파 방송 (한번 전송하고나서 끝남)
		 	 데이터의 경계가 있다.(용량이설정되어있음)
		 	 1 대 1 통신 가능(unicast)
		 	 1 대 多통신 가능(broadcast)
		 	 다 대 다 통신 가능(multicast)
		 	 
		 	 Packet(묶음)
		 	 제어정보, 데이터 등이 결합된 형태로 전송이 되는 실제의 데이터 
		 	 IP, Port, String: 1001-홍길동-서울시
		 			   Object: Dto
		 	 IP: Internet Protocol = 주소
		 	 IPv4 : XXX.XXX.XXX.XXX  0~255
		 	 IPv6 : XXX.XXX.XXX.XXX.XXX.XXX
		 	 
		 	 127.0.0.1 -> 자기자신의 IP
		 	 
		 	 Port Number(각각의 프로세스(web, kakaotalk 등..)들을 구분해주는 숫자)
		 	 IP주소는 인터넷에 존재하는 host(PC)를 식별할 수 있으나
		 	 최종 주체인 프로세스(프로그램)를 식벽하지 못하기 때문에
		 	 프로세스를 구별하기 위해서 지정된 수치(0~1024:System)외의 숫자를 지정한다.
		 	 
		 	 Socket -->유닉스에서옴(file)
		 	 통신의 주체, 통신을 하기 위한 Object
		 	 IP, TCP/UDP를 갖고 있다.  
		 	 server = socket많음, client = 1개
		 	 
		 	 통신순서
		 	 	Server								Client
		 	 1. Socket버전확인	  					1. Socket버전확인
		 	 2. Binding ->Ip, PortNum설정	
		 	 3. Listen
		 	 4. Accept(client정보(ip,port)  <--------2. Connect (먼저통신해주는것은 client)
			            				        접속성공!	
			    1) recv(read) 		       <------- send(write)
			    2) send(wirte)            --------> recv(read)  >>요런것을 동기화라고함
			 
			 
			 DNS(Doamin Name System) Server
			 	IP가 들어온것을 문자열로 바꿔주는 작업(IP - String)
		 */
		
		
		Socket clientSocket = null;
		try {
			
			//문지기 소켓
			ServerSocket serSocket = new ServerSocket(9000);
		
			//소켓안에 자동으로 자신의 IP를 설정, binding, listen이 포함되어있음(통신순서 123이 끝났음)
			System.out.println("접속대기중...");
			clientSocket = serSocket.accept(); //accept이 connect과 연결이 됨, 클라이언트정보를던져줌(상대방주소는 clientSocket에 있음)
			//clientSocket->클라이언트에 있는정보를 받아들임 담당자소켓, 지금접속이된소켓의 담당소켓
			
			
			
			//접속됬는지 확인해보기 .getInetAddress() 어떤클라이언트의 IP가 왔느냐
			System.out.println("clinet IP:" + clientSocket.getInetAddress()
												+ "Port:" +clientSocket.getPort());
			
			//다른클라이언트와 소통하고싶으면 accept를 열어주면됨
			while(true) {
				//1. recive
				BufferedReader reader 								//socket은 문지기소켓이아님, 클라이언트 소켓임(담당자)
						= new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				String str = reader.readLine();
				System.out.println("서버로부터 받은 메시지: " + str);
				
				str = "반갑습니다.";
				
				//2. send
													//socket에 잇는부분을 outprint
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream()); 
				writer.println(str); //실질적으로 전송되는것
				writer.flush(); //절대잊으면안됌!끝맺음
			}
			//clientSocket.close();
			//serSocket.close();
			
			//cmd에서 ip주소 얻기 ping www.naver.com //netstat -a -ntcp보기
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}

