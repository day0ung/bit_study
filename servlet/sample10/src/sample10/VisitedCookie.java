package sample10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/visitedCookie")
public class VisitedCookie extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		
		pw.println("<head>");
		pw.println("<title>제목</title>");
		pw.println("</head>");
		pw.println("<body>");
		
		pw.println("<p>Visited Servlet</p>");
		Cookie cookies[] = req.getCookies();
		Cookie visitCookie = null;
		if(cookies != null) {
			//쿠키는 있음
			
			//검색
			 for (int i = 0; i < cookies.length; i++) {
				if(cookies[i].getName().equals("visited")) {
					visitCookie = cookies[i];
					break;
				}
			}
			 
			//찾음
			if(visitCookie != null) {
				int count = Integer.parseInt( visitCookie.getValue() ) +1; //visitCookie.getValue() >>return값이 String이여서parseint
				pw.println("<p>" + count +"번째 방문입니다");
				
				//쿠키값을 갱신해서 넣는다.
				visitCookie.setValue(count +"");
				visitCookie.setMaxAge(60); //60초기한
				//visitCookie.setMaxAge(10); //기한설정 365 *24 * 60 * 60 -> 1년 //10초.. --설정하지않으면 기한없음
				resp.addCookie(visitCookie); //갱신
				
			}else {//못찾음
				//쿠키가 한개도없음 -> 생성
				pw.println("<p>첫번째 방문입니다</p>");
				Cookie newCookie = new Cookie("visited","1"); //value값은 String
				resp.addCookie(newCookie);
			}
			
		}else {
			//쿠키가 한개도없음 -> 생성
			pw.println("<p>첫번째 방문입니다</p>");
			Cookie newCookie = new Cookie("visited","1"); //value값은 String
			resp.addCookie(newCookie);
		}

		
		pw.println("</body>");
		pw.println("</html>");
		
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}

}
