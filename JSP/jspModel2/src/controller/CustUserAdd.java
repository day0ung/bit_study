package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustUserDao;
import dto.CustUserDto;

//xml에등록
@WebServlet("/custuseradd")
public class CustUserAdd extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.processFunc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.processFunc(req, resp);
	}
	
	public void processFunc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//custuserlist의 a태그의 command?add 파라미터 받기
		String command = req.getParameter("command");
		
		//고객추가 -> View로 이동
		if(command.equals("add")) {
			resp.sendRedirect("custadd.jsp");
		}
		//고객추가가됬으면 -> DB에 저장
		else if(command.equals("addAf")) { //custadd.jsp의 addAf
			String id = req.getParameter("id");
			String name = req.getParameter("name");
			String address = req.getParameter("address");
			
			System.out.println(id + " " + name+ " " + address);
			
			//dao에 추가하기 (dao에 고객추가하는 함수불러오기) == 얘가 service//
			
			CustUserDao dao = CustUserDao.getInstance();
			boolean isS = dao.addCustUser(id, name, address);
			
			///////////////////////////////////////////////////
			//판별하기
			resp.sendRedirect("finding.jsp?isS=" +isS);
		}
	}
	
}
