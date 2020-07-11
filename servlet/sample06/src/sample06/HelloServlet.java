package sample06;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HelloServlet doGet");
		
		//짐풀어주기		getParameter로 넘어오는 것은 무조건 문자열이다
		String name = req.getParameter("name");
		String sage = req.getParameter("age");
		
	
		int age = 0;
		
		if(sage ==  null || sage.trim().equals("")) {
			resp.sendRedirect("index.html"); //값이 null이거나 빈문자열이면 다시 index로 보내줌
		}else {
			age = Integer.parseInt(sage);
		}
		
		//html>>selcet의 값가져오기
		String fruits[] = req.getParameterValues("fruit");
		/*
		 아무것도 선택안했을시 조건걸어주기
		 if(fruits == null || fruits.length <= 0) { resp.sendRedirect("index.html"); }
		 */
		String fArr = "";
		for (int i = 0; i < fruits.length; i++) {
			fArr = fArr + "&fluit=" + fruits[i];
		}
		
		//&fluit= apple&fluit=pear parameter를 &로 구분한다
		
		//resutl servlet에서 데이터 판정하도록 만듬
		
		//데이터가 넘어왔다는가정하에 날려줌
		resp.sendRedirect("resultServlet?name="+ /*name>>한글안깨지게*/URLEncoder.encode(name) +"&age=" + age + fArr); //html의 a 와 비슷함 단순이동만 시킬때 사용한다,
	
		 //html의 a 와 비슷함 단순이동만 시킬때 사용한다,
		// parameter를 넘겨줄 수 는있다. parameter를 뒤에다가 붙ㅇ줘야함(farr) 파라미터를 다 만들어줘야한다.
		
		//RequestDispatcher dispatch = req.getRequestDispatcher("resultServlet");//ResultServlet.java로 가게만듬
		//dispatch.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}

}
