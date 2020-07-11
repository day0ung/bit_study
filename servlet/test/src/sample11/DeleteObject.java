package sample11;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/delObject")
public class DeleteObject extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
	      PrintWriter pw = resp.getWriter();
	      pw.println("<html>");
	      pw.println("<head>");      
	      pw.println("<title>제목</title>");
	      pw.println("</head>");   
	      pw.println("<body>");      
	   
	      pw.println("<h1>DelObject Servlet</h1>");   
	      //session얻어오기
	      HttpSession session = req.getSession(false);
	      //session에 들어가있는object삭제
	      session.removeAttribute("age");
	      
	      pw.println("<p>현재등록되어있는 세션 표시</p>");
	      Enumeration<String> enum_session =session.getAttributeNames();
	      
	      while(enum_session.hasMoreElements()) { //hasNext와같음
	    	  String key = enum_session.nextElement(); //session명 넘어오게
	    	  String value = (String)session.getAttribute(key); //key값을 통해 value값 얻기  return은 스트링
	    	  
	    	  pw.println("<p>"+key+":"+value+"</p>");
	      }
	      
	      pw.println("</body>");      
	      pw.println("</html>");
	      pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
	
}
