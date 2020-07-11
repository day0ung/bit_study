package bit.com.a.websock;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
//WebScocket은 생성이 되어있어야함, servlet-context.xml에서 baen으로 생성해놓음
public class WebSocket extends TextWebSocketHandler{ //서버부분임
	//중요한요소: session websocket의 저장공간 , 접속이 된 소켓들을 저장함
	
	//소켓을 담을 수 있는 맵을 만듬
	private Map<String, WebSocketSession> users = new ConcurrentHashMap<String, WebSocketSession>();
	
	public WebSocket() {
		System.out.println("EchoHandler 생성됨" + new Date());
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		//연결된 후에 실행 되는 것
		//session이 타고들어옴 -> session = socket정보
		System.out.println("연결됨" + new Date());
		
		//연결되면 제일먼저 해주는 작엄: 소켓을 담아주어야함
		users.put(session.getId(), session);
		
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		//연결종료
		System.out.println("연결종료" + new Date());
		
		//연결종료가되면 담겨있던 소켓을 없애주어야함
		users.remove(session.getId());
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		//메세지 수신
		System.out.println("메세지 수신" + new Date());
		
		//전체한테 다 보내주어야함, 만약 방만들어서 방을만들어서 특정사람들에게만 주고싶다면 이곳을 조정해 주어야함
		 for ( WebSocketSession s : users.values()) {
			s.sendMessage(message); //for문을 돌면서 지금접속되어있는 모든유저에게 메세지를 보내줌
		}
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		//예외
		System.out.println( session.getId()+"Exception"+  new Date());
	}
	
	
	
}
