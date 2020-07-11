package sample03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.createHTML("Get", req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//공개를하지말아야할데이터
		this.createHTML("Post", req, resp);
	}
	
	
	//doget,dopost 어느쪽으로 오나 접근을 하기 위한 함수
	public void createHTML(String methodType, HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		String name = req.getParameter("name");
		
		System.out.println("name: " + name); 
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter(); //pw에 값을 넣어주기 위함
		pw.println("<html>");
		
		pw.println("<head>");
		pw.println("<title>제목</title>");
		pw.println("</head>");

		pw.println("<body>");
		
		pw.println("<h1>Hello Servlet</h1>");
		pw.println("<p>Hello Servlet</p>");
		
		pw.println("<p>" + methodType +"방식</p>");
		
		
		//request에서 받은 name쓰기
		pw.println("<p>" + name +"</p>");
		
		
		pw.println("</body>");
	
		
		pw.println("</html>");
		
		pw.close();
		//서버로 이동된다음 html코드로 응답해줌. 
	}
}
