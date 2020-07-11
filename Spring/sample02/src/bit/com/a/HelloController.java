package bit.com.a;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HelloController {

	private static Logger logger = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping("hello")	// GET
	public String hello() {
		logger.info("HelloController hello " + new Date());
		
		return "hello"; //hello.jsp
	}
	
	
	
	@RequestMapping(value = "home.do", method=RequestMethod.GET) //.do로 표시해주면 컨트롤러로 이동		
	public String home(Model model) { //Java(Controller) -> web
		logger.info("HelloController home " + new Date());
		
		String name = "홍길동";
		//addAttribute = setAttribute와 동일함(request,session, application소속)
		model.addAttribute("name", name);
		
		return "home";
	}
	
	//home.jsp에서 a태그로넘겨준 데이터 받기, 파라미터로
	@RequestMapping(value= "world.do", method= {RequestMethod.GET, RequestMethod.POST}) //a태그는 무조건 get
	public String world(int age, String email) { //spring의 의존성, 자동적으로 int로 받음
		logger.info("HelloController world.do " + new Date());
		
		logger.info("데이터확인 >> age:"+age+"//email:"+ email);
		
		return "world";
	}
	
	//home.jsp에서 form으로 넘겨준 데이터 받기, Member dto
	@RequestMapping(value= "func.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String func(Member mem) { //dto에서 기본생성자안만들면 안됨
		logger.info("HelloController func.do " + new Date());
		
		logger.info(mem.toString());
		//INFO : bit.com.a.HelloController - Member [age=25, name=홍길동, address=서울시]가 줄력됨
		return "home";
	}
}
