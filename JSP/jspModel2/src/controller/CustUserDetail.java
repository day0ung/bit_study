package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustUserDao;
import dto.CustUserDto;

@WebServlet("/custuserdetail")
public class CustUserDetail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processFunc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processFunc(req, resp);
	}
	

	public void processFunc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//id값을 받아오기
		String id = req.getParameter("id");
		System.out.println(id);
		
		CustUserDao dao = CustUserDao.getInstance();
		CustUserDto dto = dao.getCustuser(id);
		if(dto == null) {
			resp.sendRedirect("custuserlist");
		}else {
		//컨트롤러 보내기 오브젝트보낼때는 forward로 보내야한다
		//resp.sendRedirect("selectCust.jsp?dto=" + dto); <<이것은안됌
		req.setAttribute("dto", dto); //짐싸
		forward("selectCust.jsp", req, resp); //컨트롤러로 보내주기
		}
	}
	
	public void forward(String link, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		RequestDispatcher dispatch = req.getRequestDispatcher(link);
		dispatch.forward(req, resp);
	}
}
