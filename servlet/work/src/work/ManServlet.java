package work;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/man")
public class ManServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//session에서 받아오기 get만가능
		 req.setCharacterEncoding("utf-8");
	        resp.setContentType("text/html; charset=utf-8");
	        HttpSession session = req.getSession();
	        
	        ObjectDto dto = (ObjectDto)session.getAttribute("dto");
	        String name = dto.getName();
	        int age = dto.getAge();
	        //String gender = req.getParameter("radio");
	        String hobby[] = dto.getHobby();
	        
	        PrintWriter pw = resp.getWriter();
	        pw.println("<html>");
	 
	        pw.println("<head>");
	        pw.println("<title>제목</title>");
	        pw.println("</head>");
	 
	        pw.println("<body>");
	        pw.println("<h1>MemServlet Servlet</h1>");
	        pw.println("<p>이름: "+name+"<p>");
	        pw.println("<p>나이: "+age+"<p>");
	        for (int i = 0; i < hobby.length; i++) {
	            pw.println("<p>취미: " + hobby[i] +"</p>");
	        }
	        
	        pw.println("</body>");
	 
	        pw.println("</html>");
	 
	        pw.close();
	    }
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
