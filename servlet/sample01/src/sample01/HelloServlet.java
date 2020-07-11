package sample01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	
	
	
	
	//html에서 form에서 들어올려면 WEB INF폴더에 new- other- xml -  web.xml 만들어준후
	//C:\apache-tomcat-8.5.50\conf 폴더의 xml폴더를 복사 - web.xml폴더에 version3.1코드를 넣는다 
	
	
	//서버 영역 Source의 override
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HelloServlet doGet"); //창의 url에서 http://localhost:8090/sample01/location? <<물음표가 보임
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HelloServlet doPost"); //창의 url에서 http://localhost:8090/sample01/location <<물음표가 보이지 않는다.
	}
	
}
