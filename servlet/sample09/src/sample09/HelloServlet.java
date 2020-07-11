package sample09;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//xml등록안해도됨
@WebServlet("/hello") //namesapce -> 주석( 명시적주석)
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HelloServelt doGet");
		//include(가져오다),forward(그쪽으로 이동하다)
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter(); //pw에 값을 넣어주기 위함
		pw.println("<html>");
		
		pw.println("<head>");
		pw.println("<title>제목</title>");
		pw.println("</head>");

		pw.println("<body>");
		
		pw.println("<h1>Hello Servlet Start</h1>");
		//include(불러오기)
		RequestDispatcher dis = req.getRequestDispatcher("include");
		dis.include(req, resp);
		
		//forward(이동하기) //창에서 helloservletend가 출력되지않음 그냥이동하는것임
		//RequestDispatcher dis = req.getRequestDispatcher("forward");
		//dis.forward(req, resp);
		pw.println("<h1>Hello Servlet End</h1>");
			
		pw.println("</body>");
		
		
		pw.println("</html>");
		
		pw.close();
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
	
}
