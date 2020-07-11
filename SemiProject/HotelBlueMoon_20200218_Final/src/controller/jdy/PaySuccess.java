package controller.jdy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import singleton.Singleton;
@WebServlet("/paysuccess")
public class PaySuccess extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//dao ad
		String sresvSeq = req.getParameter("resvSeq");
		int resvSeq = Integer.parseInt(sresvSeq);
		
		Singleton s = Singleton.getInstance();
		s.resvSerivce.addPayment(resvSeq);
		
		resp.sendRedirect(req.getContextPath()+"/JSP/mypagefoward");	
	}
	
	
}
