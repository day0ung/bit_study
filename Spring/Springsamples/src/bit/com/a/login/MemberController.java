package bit.com.a.login;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.model.MemberDto;
import bit.com.a.service.MemberService;

@Controller
public class MemberController {

	private static Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired	// -> 의존성	Dependency Injection(DI) I
	MemberService memberService;
	
	@RequestMapping(value = "login.do", method=RequestMethod.GET)
	public String login(Model model) {
		logger.info("MemberController login " + new Date());			
		
		return "login.tiles";  //layouts.xml 의 <definition name="login.tiles"
	}
	
	@RequestMapping(value = "regi.do", method=RequestMethod.GET)
	public String regi() {
		
		return "regi.tiles";
	}
	
	@ResponseBody
	@RequestMapping(value="idcheck.do", method=RequestMethod.POST)
	public String idcheck(String id) {
		System.out.println("컨트롤러 idcheck"+ id);
		int count = memberService.getId(id);
		
		logger.info("count = " + count);
		String msg = "";
		if(count > 0) {
			msg = "NO";
		}else {
			msg = "YES";
		}
		return msg;
	}
	
	@RequestMapping(value="loginAf.do", method=RequestMethod.POST)
	public String loginAf(MemberDto dto, HttpServletRequest req) {
		MemberDto login = memberService.login(dto);
		if(login!= null && !login.getId().equals("")) {
			//session
			req.getSession().setAttribute("login", login);
			req.getSession().setMaxInactiveInterval(60*60*365);
			
			return "redirect:/bbslist.do"; //data를 가져가려면 forward사용
		}else {
			return "redirect:/login.do";
		}
	}
	
	//session아웃이 되었을때
	@RequestMapping(value="sessionOut.do", method = RequestMethod.GET)
	public String sessionOut() {
		
		return "sessionOut.tiles";
	}
	
	@RequestMapping(value = "regiAf.do", method=RequestMethod.POST)
	public String regiAf(MemberDto dto) {
		logger.info("MemberController regiAf " + new Date());
		
		boolean b = memberService.addmember(dto);
		if(b) {
			logger.info("회원 가입되었습니다 " + new Date());
			return "login.tiles";
		}
		logger.info("가입되지 않았습니다 " + new Date());
		
		return "regi.tiles";
	}
	
	@RequestMapping(value = "test.do", method=RequestMethod.GET)
	public String test() {
	
		return "test";
	}
	
	
	
}





