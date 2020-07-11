package sample08;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Member;

public class SampleServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//sendredirect확인하기
		//form에서 왔을때는 get과post가 갈리는데 그것이아니였을때는 doget으로 옴(java에서)
		System.out.println("SampleServlet doGet");
		
		//한글안깨지게 안해도됨 이미 Helloservlet에서 encoder해줬기 떄문에
		//req.setCharacterEncoding("utf-8");
		/*
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		
		System.out.println("name:" +name);
		System.out.println("age:" +age);
		*/
		
		//dto로 보내준 데이터 꺼내기  //hello에서 dto로 보냈기때문에 받을때도 dto
		Object obj = req.getAttribute("dto"); 
		Member mem = (Member)obj;
		
		System.out.println(mem.toString());
		//현재 위치에 따라서 이동(post->post) 이곳에서는 출력되지않는다.
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("SampleServlet doPost");
		//dto에서 보내준곳은 post이기떄문에 이곳에 작성해야함
		Object obj = req.getAttribute("dto"); //짐풀어
		Member mem = (Member)obj;
		
		System.out.println(mem.toString()); //객체로묶어서 보냈을때는 urlencoder사용하지않아도됨
		
		
		//다시 form으로 보내줄때 , sendRedirect,forward >>jsp파일 생성
		//--재포장--
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		//String name = "성춘향";
		//int age = 17;
		//form으로 가기위한 포장
		Member member = new Member(name, age);
		req.setAttribute("member", member);
		
		//포장해서가져갈때는 반드시 request소속의 forward를 사용해야한다.
		req.getRequestDispatcher("detail.jsp").forward(req, resp);
		
	}

}
