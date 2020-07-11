import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.CustUserDto;
import net.sf.json.JSONObject;
@WebServlet("/custuser")
public class Servlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String id = req.getParameter("id");
		 String pwd = req.getParameter("pwd");
		 
		//전송 Data >>여러개의데이터 보내기 map
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("title","사과");
//		JSONObject obj = new JSONObject();
//		obj.put("map", map);
		
		
		//dto파일보내기
		List<CustUserDto> list = new ArrayList<CustUserDto>();
		list.add(new CustUserDto(101,"홍길동"));
		list.add(new CustUserDto(102,"일지매"));

		map.put("list", list);
		JSONObject obj = new JSONObject();
		obj.put("map", map);
		resp.setContentType("application/x-json; charset=UTF-8");
		resp.getWriter().println(obj);
		
		//gson -> ajax
		
		
		/* 
		String str =  "Hello";
		 //req.setAttribute("str", str);
			//>>이거안됌....jar파일넣기
		 
		
		//jar파일을 추가해야 jsonobject가 나옴
		JSONObject obj = new JSONObject();
		obj.put("str",str);
		
		resp.setContentType("application/x-json; charset=UTF-8");
		resp.getWriter().println(obj);
		*/
		
	}


	
}
