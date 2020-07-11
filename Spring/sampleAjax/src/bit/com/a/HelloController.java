package bit.com.a;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.model.Human;
import bit.com.a.model.MyClass;
@Controller
public class HelloController {
	private static Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	//1번째 방법 데이터를 넘겨주는 작업
	@RequestMapping(value ="hello.do", method = RequestMethod.GET)
	public String hello(Model model) {
		logger.info("HelloController hello" +  new Date());
		
		MyClass cls = new MyClass(10, "일지매");
		
		model.addAttribute("myCls", cls);
		
		return "hello";
	}
	
	//2번째 방법 controller -> controller 이동할때는 redirect:/ forward:/해주어야함
	@RequestMapping(value= "move.do", method= RequestMethod.GET)
	public String move(){
		logger.info("HelloController move" +  new Date());
		
		//return "hello.do"; do.jsp가 붙어서 << 찾지 못함
		
		/* redirect와 forward의 차이: 짐 */
		//redirect방법(컨트톨러에서 같은컨트롤러 이동시 사용많이함)
		//return "redirect:/hello.do"; //sendRedirect와 동일
	
		//forward방법 (컨트롤러에서 다른컨트롤러 이동시 사용많이함)
		return "forward:/hello.do"; //forward	
	}
	
	//3번째 방법 Ajax [주의사항--ajax전용은 여기서 return값 String은 어디로가는것이아님 넘겨주어야할 데이터임]
	@ResponseBody /* ajax전용의 컨트롤러의 경우 annotation @ResponseBody 반드시 해주어야함 */
	//produces="application/String; charset=utf-8" >> 문자열로만 전송할때 필요함 , 한글이 깨지지 않도록
	@RequestMapping(value = "idcheck.do", produces="application/String; charset=utf-8")
	public String idcheck(String id, 
			HttpSession session) { //session접근은 session이라는 내장객체가 있음, 내장객체가 없다면 request.getSession -> 이것의 original version은  HttpSession임
		logger.info("HelloController idcheck" +  new Date());
		logger.info("데이터들어온 id확인:" +id);
		
		String str = "오케이"; //
		return str;
	}
	
	//4번째 방법(데이터가 넘어왔다가 확인을하고 다른데이터를 넘겨줌)
	@ResponseBody
	@RequestMapping(value = "account.do", method=RequestMethod.POST)
	public Map<String, Object> account(Human my){
		logger.info("HelloController account" +  new Date());
		logger.info(my.toString());
		
		//DB로 접근하는 작업
		Map<String, Object> rmap = new HashMap<String, Object>();
		//rmap.put("넘겨줄데이터", "값")
		rmap.put("msg","메시지 입니다");
		rmap.put("name", "정수동");
		
		return rmap;
	}
	
	@ResponseBody
	@RequestMapping(value= "updateUser.do", method=RequestMethod.POST)
	public Map<String, Object> account(@RequestBody Map<String, Object> map){ //@RequestBody 데이터를 받는다는 의미
		logger.info("HelloController updateUser" +  new Date());
		logger.info( map.get("name") + "");
		logger.info( map.get("phone") + "");
		logger.info( map.get("email") + "");
		logger.info( map.get("birth") + "");
		
		
		//DB로 접근하는 작업
		Map<String, Object> rmap = new HashMap<String, Object>();
		//rmap.put("넘겨줄데이터", "값")
		rmap.put("age","24");
		rmap.put("name", "일지매");
		
		return rmap;
	}
	

	
}
