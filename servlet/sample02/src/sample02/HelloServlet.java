package sample02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	
	
	//server와 client를 연동시켜주는 작업
	//request.getParameter("name"); 
	//request의 실물은 HttpServletRequest이거임 (받는부분)
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("Hello Servlet doGet"); //http://localhost:8090/sample02/loc?name=hello <<name  = hello라고 나타남parameter를 받아줌
		
		/*
		    Servlet -> Java코드안에 html코드가 들어감
		    JSP -> html코드안에 java코드가 들어감
		 	
		 	JSP(mvc)
		 	Model1 --> servlet사용안함
		 	Model2 --> servlet은 이동역할(controller)
		 	doget까지했으면 container안에서 html코드를 꺼내야함
		 */
		
		
		//받아주는 부분 >>여기까지 가져오는 이유는 db와 접근하기 위해
		String name = req.getParameter("name");
		
		System.out.println("name: " + name); //콘솔창에 >>name: 아무거나 << 출력됨 외부(client)에서 서버까지 들어온것임
		
		//java에서 server자체를 실행시킬때:: Server start를 누르고 아무창에서 http://192.168.2.22:8090/sample02/index.html 실행
		
		//container에서 꺼내와서 web에 출력하기
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter(); //pw에 값을 넣어주기 위함
		pw.println("<html>");
		
		pw.println("<head>");
		pw.println("<title>제목</title>");
		pw.println("</head>");

		pw.println("<body>");
		
		pw.println("<h1>Hello Servlet</h1>");
		pw.println("<p>Hello Servlet</p>");
		//request에서 받은 name쓰기
		pw.println("<p>" + name +"</p>");
		
		
		pw.println("</body>");
	
		
		pw.println("</html>");
		
		pw.close();
		//서버로 이동된다음 html코드로 응답해줌. 
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String name = req.getParameter("name");
		
		System.out.println("name: " + name); //콘솔창에 >>name: 아무거나 << 출력됨 외부(client)에서 서버까지 들어온것임
		
		//java에서 server자체를 실행시킬때:: Server start를 누르고 아무창에서 http://192.168.2.22:8090/sample02/index.html 실행
		
		//container에서 꺼내와서 web에 출력하기
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter(); //pw에 값을 넣어주기 위함
		pw.println("<html>");
		
		pw.println("<head>");
		pw.println("<title>제목</title>");
		pw.println("</head>");

		pw.println("<body>");
		
		pw.println("<h1>Hello Servlet</h1>");
		pw.println("<p>Hello Servlet</p>");
		//request에서 받은 name쓰기
		pw.println("<p>" + name +"</p>");
		
		
		pw.println("</body>");
	
		
		pw.println("</html>");
		
		pw.close();
	}
	
	
}
