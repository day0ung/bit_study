package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustUserDao;
import dto.CustUserDto;

//이곳은 servlet부분 >>xml에 등록
public class CustUserList extends HttpServlet{
	
	/* CustUserDao dao = new CustUserDao(); 싱글턴대신에 사용해도됨*/
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.processFunc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.processFunc(req, resp);
	}
	
	
	//doget과 dopost에 오든상관없는 함수
	public void processFunc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CustUserDao dao = CustUserDao.getInstance(); //dao싱글턴확보하기
		
		//dao를통해서 list가져오기
		List<CustUserDto> list = dao.getCustUserList();
		
		//servlet이여서 데이터를 가지고 이동해야함
		req.setAttribute("custlist", list); //짐싸
		forward("custuserlist.jsp", req, resp);//잘가(전진 ,이동)
	}
	
	
	//짐보내주는 forward함수  만들어주기
	public void forward(String link, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		RequestDispatcher dispatch = req.getRequestDispatcher(link);
		dispatch.forward(req, resp);
	}
}
