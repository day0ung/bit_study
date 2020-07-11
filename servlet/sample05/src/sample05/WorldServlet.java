package sample05;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WorldServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getParameter("url");
		
resp.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
		//helloservlet의 setheader 응답을 통해서 header로 location지정해주면 바로 링크로 이동
		//worldservlet의 sendRedirect >>링크로걸어서 이동하는게 안됌(url같은거)  다른곳으로 이동하게끔 만듦
		if(url.equals("naver.com")) {
			resp.sendRedirect("Naver.html"); 
		}
		
		
	}

}
