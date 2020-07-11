package model;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustUserDao;
import dto.CustUserDto;
import util.CustUtil;

public class CustUserList extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.processFunc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.processFunc(req, resp);
	}
	
	public void processFunc(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		
		CustUserDao dao = CustUserDao.getInstance();
		
		List<CustUserDto> list = dao.getCustUserList();
		
		req.setAttribute("custlist", list);	// 짐싸!
		
		CustUtil.forward("custuserlist.jsp", req, resp);	// 잘가(전진)	
	}
	
	

	
}






