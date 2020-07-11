package sample05;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HelloServlet doGet");
					//받는것은 req
		//index에서 작성한 <a>의 href의 age 콘솔에 출력
		String age = req.getParameter("age");
		System.out.println("age: " + age);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HelloServlet doPost");
		//redirect설정한곳
		
		//index.html의 select의 name값 받기
		String url = req.getParameter("url");
		
		//link를 설정한경우 추가해야할것 <하지않으면 링크가 정상적으로 이동하지않음>
		resp.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
		
		if(url.equals("naver.com")) {
			resp.setHeader("Location", "http://www.naver.com"); //setHeader(location은 정해져있음, 가려고하는 링크부분의 주소작성)
		}
		else if(url.equals("google.com")) {
			resp.setHeader("Location", "http://www.google.com");
		}
		else {
			resp.setHeader("Location", "http://zum.com");

		}
	}

}
