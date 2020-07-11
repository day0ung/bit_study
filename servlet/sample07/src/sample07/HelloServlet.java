package sample07;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name"); //getParameter는 parameter를 받아올대 사용
		String sage = req.getParameter("age");
		int age = Integer.parseInt(sage);
		
		String fluit[] = req.getParameterValues("fruit");
		
		//2번째 forward하기 위한 짐싸
		//데이터모으기
		ObjectDto dto = new ObjectDto(name, age, fluit); //데이터를 수집
		//짐싸
		req.setAttribute("Obj", dto); //실제로  짐을 싸는 것은 이부분
		//setattribute 앞에다 이름을넣고  뒤에다는 오브젝트를 넣음
		
		
		//-------------------보내주기-------------------
		//데이터 넘길때 1번째, sendRedirect 
		resp.sendRedirect("resultServlet"); //단순이동 <a 짐을 갖고가지않음
		
		//데이터 넘길때 2번째, forard ==전진 
		//<짐들을가져감 name,age fluit등등 여러개의 데이터를 갖고 resultServlet으로 이동> dto만들어서 함
		req.getRequestDispatcher("resultServlet").forward(req, resp); //짐을들고감
		//	req.getRequestDispatcher("resultServlet") >> 보내주려고 하는 부분의 주소 .forward(req, resp)
		
	}

}
