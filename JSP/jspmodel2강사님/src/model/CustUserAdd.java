package model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustUserDao;

@WebServlet("/custuseradd")
public class CustUserAdd extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processFunc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processFunc(req, resp);
	}
	
	public void processFunc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String command = req.getParameter("command");
		
		// 고객추가 View
		if(command.equals("add")) {
			resp.sendRedirect("custadd.jsp");
		}		
		// 고객추가 -> DB
		else if(command.equals("addAf")) {
			String id = req.getParameter("id");
			String name = req.getParameter("name");
			String address = req.getParameter("address");
			
			System.out.println(id + " " + name + " " + address);
			
			CustUserDao dao = CustUserDao.getInstance();
			boolean isS = dao.addCustUser(id, name, address);
			
			resp.sendRedirect("finding.jsp?isS=" + isS);			
		}		
	}

	
}




