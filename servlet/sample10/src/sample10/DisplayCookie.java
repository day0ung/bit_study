package sample10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/dispCookie")
public class DisplayCookie extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		
		pw.println("<head>");
		pw.println("<title>제목</title>");
		pw.println("</head>");
		pw.println("<body>");
		
		pw.println("<p>DisplayCookie Servlet</p>");
		 //helloservlet의 쿠키 출력하기
		Cookie cookies[] = req.getCookies();
		if(cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				String value = cookies[i].getValue();
				pw.println("<p>");
				pw.println(cookies[i].getName());
				pw.println(":");
				pw.println(value);
				pw.println("</p>");
			}
		}
		
		//방문횟수확인하기
	    pw.println("<a href='visitedCookie'>방문횟수</a>");
		
		pw.println("</body>");
		pw.println("</html>");
		
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}

}
