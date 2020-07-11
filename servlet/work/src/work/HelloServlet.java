package work;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		int age = Integer.parseInt( req.getParameter("ages") );
		String gender =req.getParameter("gender");
		String[] hobby = req.getParameterValues("hobby");
		System.out.println(gender);

		ObjectDto dto = new ObjectDto(name, age, hobby);
		System.out.println(dto.toString());
		//dto에서 만든데이터 sampleservlet으로 보내주기
		req.setAttribute("dto", dto); //짐싸 하나로 묶어서 보내줌
		
		
		if(gender.equals("woman")) {
			//forward방식
			RequestDispatcher dispatcher = req.getRequestDispatcher("woman");
			dispatcher.forward(req, resp); 
			req.setAttribute("dto", dto);
		}else {
			// man 
			//session으로 넘겨주는 방식
			HttpSession session = req.getSession(true);
            session.setAttribute("dto", dto);
            resp.sendRedirect("man");
		}
		

		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter(); 
		pw.println("<html>");
		
		pw.println("<head>");
		pw.println("<title>제목</title>");
		pw.println("</head>");

		pw.println("<body>");
		
		pw.println("<h1>Hello Servlet</h1>");
		
		pw.println("<a href='woman'>여성사이트로 이동</a>");
		pw.println("<br>");
		pw.println("<a href='man'>남성사이트로 이동</a>");
		
		
		pw.println("</body>");
		pw.println("</html>");
		
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		int age = Integer.parseInt( req.getParameter("ages") );
		String gender =req.getParameter("gender");
		String[] hobby = req.getParameterValues("hobby");
		
		ObjectDto dto = new ObjectDto(name, age, hobby);
		System.out.println(dto.toString());
		//dto에서 만든데이터 sampleservlet으로 보내주기
		req.setAttribute("dto", dto); //짐싸 하나로 묶어서 보내줌
		
		
		if(gender.equals("woman")) {
			//forward방식
			RequestDispatcher dispatcher = req.getRequestDispatcher("woman");
			dispatcher.forward(req, resp); 
		}else {
			// man 
			//session으로 넘겨주는 방식
			HttpSession session = req.getSession(true);
            session.setAttribute("dto", dto);
            resp.sendRedirect("man");
		}
		

		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter(); 
		pw.println("<html>");
		
		pw.println("<head>");
		pw.println("<title>제목</title>");
		pw.println("</head>");

		pw.println("<body>");
		
		pw.println("<h1>Hello Servlet</h1>");
		
		pw.println("<a href='woman'>여성사이트로 이동</a>");
		pw.println("<br>");
		pw.println("<a href='man'>남성사이트로 이동</a>");
		
		
		pw.println("</body>");
		pw.println("</html>");
		
		pw.close();
	}
	

	
	
}
