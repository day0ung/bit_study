package sample08;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Member;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//아래코드를 써도 한글이 깨짐(콘솔에서)
		req.setCharacterEncoding("utf-8");
		
		//들어온데이터 받아주기
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		System.out.println("name:" +name);
		System.out.println("age:" +age);
		
		//sampleservlet만들기 >> servlet에서 servlet넘겨주기
		
		/*
		//한글깨지지 않도록하기위해
		String newname = URLEncoder.encode(name);
		
		//1방법, 데이터를 넘겼을대 sendRedirect로 만드는 방법은 우리가 만들어줘야함
		resp.sendRedirect("sample?name=" + newname + "&age=" +age);
		>>무조건 get으로 감
		*/
		
		//dto에서 만든데이터 sampleservlet으로 보내주기
		Member dto = new Member(name, age);
		req.setAttribute("dto", dto); //짐싸 하나로 묶어서 보내줌
																//가려고하는 부분의 이름
		RequestDispatcher dispatcher = req.getRequestDispatcher("sample");
		dispatcher.forward(req, resp); //>>post로 왔을때는 post로감
		
		
		
		/*
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter(); //pw에 값을 넣어주기 위함
		pw.println("<html>");
		
		pw.println("<head>");
		pw.println("<title>제목</title>");
		pw.println("</head>");

		pw.println("<body>");
	
		//request에서 받은 name쓰기
		pw.println("<p>" + name +"</p>");
		pw.println("<p>" + age +"</p>");
		
		
		pw.println("</body>");
	
		
		pw.println("</html>");
		
		pw.close();
		*/
	}
	
}
