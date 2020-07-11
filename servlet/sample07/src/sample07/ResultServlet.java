package sample07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResultServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ResultServlet doGet");
		
		//req.setAttribute("Obj", dto); HelloServlet의 짐을 보내준것을 받기위해서
		ObjectDto dto = (ObjectDto)req.getAttribute("Obj"); //..>return값이 object여서 캐스트변환해주어야함
		
		//짐풀기
		String name = dto.getName();
		int age = dto.getAge();
		String fluit[] = dto.getFluit();
		
		//시각화보여주기 위해서 만드는 부분
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter(); 
		pw.println("<html>");
		
		pw.println("<head>");
		pw.println("<title>제목</title>");
		pw.println("</head>");

		pw.println("<body>");
		
		pw.println("<p>이름: " +name +"</p>");
		pw.println("<p>이름: " +age +"</p>");
		for (int i = 0; i < fluit.length; i++) {
			pw.println("<p>과일: " + fluit[i] +"</p>");
		}
		
		
		pw.println("</body>");
	
		
		pw.println("</html>");
		
		pw.close();
		
	}
	
}
