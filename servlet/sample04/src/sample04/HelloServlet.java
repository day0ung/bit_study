package sample04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("code");
		System.out.println("code: " +code);
		
		//세금받아오기
		//init-param으로 초기화해놓은 것임 -> web.xml에 잇음
		String tax = this.getInitParameter("tax");
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter(); 
		pw.println("<html>");
		
		pw.println("<head>");
		pw.println("<title>제목</title>");
		pw.println("</head>");

		pw.println("<body>");
		
		if(code.equals("200")) {
			pw.println("<p>200:SC_OK</p>");
		}else {
			if(code.equals("404")) {
				resp.sendError(HttpServletResponse.SC_NOT_FOUND, "못찼겠다는 에러");
			}
			else if(code.equals("500")) {
				resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "코드가 틀렸다는 에러");
			}
		}
		
		//세금 출력하기
		pw.println("<p>tax:"+tax+"</p>");
		
		
		pw.println("</body>");
	
		
		pw.println("</html>");
		
		pw.close();
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	
}
