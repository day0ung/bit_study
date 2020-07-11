package model;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustUserDao;
import dto.CustUserDto;
import util.CustUtil;

@WebServlet("/custuserupdate")
public class CustUserUpdate extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processFunc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processFunc(req, resp);
	}

	public void processFunc(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String command = req.getParameter("command");
		CustUserDao dao = CustUserDao.getInstance();
		
		if(command.equals("update")) {
			String id = req.getParameter("id");
			
			CustUserDto dto = dao.getCustuser(id);
			System.out.println(dto.toString());
			req.setAttribute("custuserdto", dto);			
			CustUtil.forward("custuserupdate.jsp", req, resp);
		}
		else if(command.equals("updateAf")) {						
			String id = req.getParameter("id");
			String name = req.getParameter("name");
			String address = req.getParameter("address");
			System.out.println("name:" + name);
			System.out.println("address:" + address);
						
			dao.updateCustUser(id, name, address);
			resp.sendRedirect("custuserlist");
		}
	}
			
}
