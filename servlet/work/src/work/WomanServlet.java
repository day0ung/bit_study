package work;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/woman")
public class WomanServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// forward
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		ObjectDto dto = (ObjectDto)req.getAttribute("dto");
//		String name = req.getParameter("name");
//		int age = Integer.parseInt(req.getParameter("age"));
//		// String gender = req.getParameter("radio");
//		String hobby[] = req.getParameterValues("check");
//
//		ObjectDto dto = new ObjectDto(name, age, hobby);
		// System.out.println(dto.toString());

//	        if(gender.equals("woman")) {
//	            //womanServlet
//	            //forward
//	            RequestDispatcher dis = req.getRequestDispatcher("woman");
//	            dis.forward(req, resp);
//	            
//	        }else {
//	            //manServlet
//	            //session dto 에 담아서 가자
//	        }

		PrintWriter pw = resp.getWriter();
		pw.println("<html>");

		pw.println("<head>");
		pw.println("<title>제목</title>");
		pw.println("</head>");

		pw.println("<body>");
		pw.println("<h1>WomanServlet Servlet</h1>");
		pw.println("<p>이름: " + dto.getName() + "<p>");
		pw.println("<p>나이: " + dto.getAge() + "<p>");
		for (int i = 0; i < dto.getHobby().length; i++) {
			pw.println("<p>취미: " + dto.getHobby()[i] + "</p>");
		}

		pw.println("</body>");

		pw.println("</html>");

		pw.close();
	}

	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
