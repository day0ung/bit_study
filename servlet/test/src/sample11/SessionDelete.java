package sample11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionDel")
public class SessionDelete extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
	      PrintWriter pw = resp.getWriter();
	      pw.println("<html>");
	      pw.println("<head>");      
	      pw.println("<title>제목</title>");
	      pw.println("</head>");   
	      pw.println("<body>");      
	   
	      pw.println("<h1>SessionDelete Servlet</h1>");   
	   
	      HttpSession session = req.getSession(false);
	      session.invalidate(); //logout일 경우에 호출
	      
	      if(req.getSession(false) == null) {
	    	  pw.println("<p>세션이 비어있습니다.</p>");
	      }
	      pw.println("</body>");      
	      pw.println("</html>");
	      pw.close();
	      //정다영 바보 멍청이 똥개 해삼 말미잘 메에에에에에에에롱  
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
	
}
