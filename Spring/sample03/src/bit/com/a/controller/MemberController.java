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
	
	@Autowired // >> 의존성 Dependency Injection(DI) springframework이 자동적으로 memberserviceimpl을 찾아준다
	
	//autowired가 없으면 MemberService memberService = new MemberServiceImple();
	MemberService memberService; //memberservice = interface임 
	
	@RequestMapping(value = "allmember.do", method=RequestMethod.GET)
	public String allmember(Model model) {
		logger.info("MemberController allmember" + new Date());
		
		List<MemberDto> list = memberService.allMember();
		
		model.addAttribute("memlist", list);
		return "allMember";
	}
	
	@RequestMapping(value= "login.do")
	public String login() {
		logger.info("MemberController login" + new Date());
		return "login";
	}
	
	
	
	@RequestMapping(value = "regi.do")
	public String regi() {
		logger.info("MemberController regi" + new Date());
		return "regi";	
	}
	
	@ResponseBody
	@RequestMapping(value="idcheck.do", method=RequestMethod.POST)
	public String idcheck(MemberDto mem) {
		logger.info("KhMemberController getId " + new Date());
		
		int count = memberService.getId(mem);
		
		logger.info("count = " + count);
		String msg = "";
		if(count > 0) {
			msg = "NO";
		}else {
			msg = "YES";
		}
		return msg;
	}
	
	
	@RequestMapping(value = "loginAf.do", method=RequestMethod.POST)
	public String loginAf(Model model, MemberDto dto, HttpServletRequest req) { // httpsession/httpservletrequest >> session저장
		logger.info("MemberController loginAf" + new Date());
		//logger.info(dto.toString());
		//service -> id,pwd비교
		MemberDto login = memberService.login(dto);
		if(login != null && login.getId().equals("") == false) {
			//login success
			req.getSession().setAttribute("login", login); //session에 로그인한 정보 넣기
			req.getSession().setMaxInactiveInterval(60*60*365);
			
			model.addAttribute("message", "1");
			//return "redirect:/bbslist.do"; //controller -> controller이동
			return "MessageAlert";
		}else {
			return "login";
		}
	
		
	}
}
