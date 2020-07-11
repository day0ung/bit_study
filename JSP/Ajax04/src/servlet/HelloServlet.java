package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dto.CustUserDto;
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CustUserDto> list = new ArrayList<CustUserDto>();
		list.add(new CustUserDto(1001, "정수동"));
		list.add(new CustUserDto(1002, "성춘향"));
		
		resp.setContentType("application/json");	//응답할타입(형식)을 json으로 변환
		resp.setCharacterEncoding("utf-8");			//한글을 정상으로 출력
		
		//gson-2.8.5jar 추가 Gson클래스사용하기 위해
		String gson = new Gson().toJson(list); //gson =  Google Json
		
		//리턴해주는 함수
		resp.getWriter().write(gson);
		
	}
	
}
