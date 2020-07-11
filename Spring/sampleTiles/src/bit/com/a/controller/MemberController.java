package bit.com.a.controller;

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
		
		return "login.tiles";
	}
	
	@RequestMapping(value = "regi.do", method=RequestMethod.GET)
	public String regi() {
		
		return "regi.tiles";
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
	
	
	
}





