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

@WebServlet("/loginId")
public class LoginIdServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  resp.setContentType("text/html; charset=utf-8");
	      PrintWriter pw = resp.getWriter();
	      pw.println("<html>");
	      pw.println("<head>");      
	      pw.println("<title>제목</title>");
	      pw.println("</head>");   
	      pw.println("<body>");      
	   
	      pw.println("<h1>LoginId Servlet</h1>");   
	      //session은 쿠키와다르게 session객체가 있어야함
	     //원래는이렇게 바로접근한다...>> req.getSession().setAttribute(name, value);
	      HttpSession session = null;
	      if(session ==null) {
	    	  pw.println("<p>session을 등록합니다</p>");
	    	  session = req.getSession(true);
	    	  
	    	  session.setAttribute("name", "홍길동");
	    	  session.setAttribute("age", "24");
	      }
	      pw.println("<p>등록되어있는 session을 표시합니다.</p>");
	      //등록되어있는 session꺼내기
	      //String name = (String)session.getAttribute("name");
	      //pw.println("<p>name:" +name + "</p>");
	      
	      //session에 있는 모든정보꺼내기
	      Enumeration<String> enum_session =session.getAttributeNames();
	      
	      while(enum_session.hasMoreElements()) { //hasNext와같음
	    	  String key = enum_session.nextElement(); //session명 넘어오게
	    	  String value = (String)session.getAttribute(key); //key값을 통해 value값 얻기  return은 스트링
	    	  
	    	  pw.println("<p>"+key+":"+value+"</p>");
	      }
	      //age는 object임
	      pw.println("<a href=delObject>age 삭제</a>"); //class만들기
	      pw.println("<br>");
	      //session자체를 삭제하기위해 
	      pw.println("<a href=sessionDel>session삭제</a>"); //class만들기
	      
	      pw.println("</body>");      
	      pw.println("</html>");
	      pw.close();
	}

}
