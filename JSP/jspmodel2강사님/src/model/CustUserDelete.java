package model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustUserDao;
import dto.CustUserDto;

@WebServlet("/custuserdelete")
public class CustUserDelete extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");		
		CustUserDao.getInstance().deleteCustUser(id);		
		resp.sendRedirect("custuserlist");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("CustUserDelete doPost");
		
		req.setCharacterEncoding("utf-8");
		
		String command = req.getParameter("command");
		CustUserDao dao = CustUserDao.getInstance();
		
		if(command.equals("mudel")) {
			System.out.println("CustUserControl muldel");
			String delArr[] = req.getParameterValues("delck");
			
			dao.deleteCustUsers(delArr);
			resp.sendRedirect("custuserlist");
		}
	}

	
}
