package sample10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//cookie는 respon소속
		//쿠키저장하기
		 Cookie cookie = new Cookie("id", "abc123"); 
	      resp.addCookie(cookie);
	      
	      cookie = new Cookie("pwd", "aabbcc");
	      resp.addCookie(cookie);
	      
	      
	      resp.setContentType("text/html; charset=utf-8");
	      PrintWriter pw = resp.getWriter();
	      pw.println("<html>");
	      pw.println("<head>");      
	      pw.println("<title>제목</title>");
	      pw.println("</head>");   
	      pw.println("<body>");      
	   
	      pw.println("<h1>Hello Servlet</h1>");   
	      //다른곳으로 이동해서 확인하기
	      pw.println("<a href='dispCookie'>Cookie를 표시</a>");
	      
	      pw.println("</body>");      
	      pw.println("</html>");
	      pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
}
