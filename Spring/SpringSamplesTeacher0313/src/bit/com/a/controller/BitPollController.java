package bit.com.a.controller;

import java.util.List;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bit.com.a.model.MemberDto;
import bit.com.a.model.PollBean;
import bit.com.a.model.PollDto;
import bit.com.a.model.PollSubDto;
import bit.com.a.model.Voter;
import bit.com.a.service.BitPollService;

/*
  
  투표항목  : 1.좋아하는 과일은? (투표는 했는지 안했는지 YES/NO)  2.좋아하는 배우는?
  투표보기  : (1)(1.사과  2.귤  3.배)			(2)(1.손예진 2.수지 )
  투표자: 누가? 어느질문? 보기번호 
 */

@Controller
public class BitPollController {
	@Autowired
	BitPollService service;
	
	@RequestMapping(value="polllist.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String pollList(Model model, HttpServletRequest req ) {
		model.addAttribute("doc_title", "투표목록");
		String id = ((MemberDto)req.getSession().getAttribute("login")).getId();
		
		List<PollDto> list = service.getPollAllList(id);
		model.addAttribute("plists", list);
		return "polllist.tiles";
		
	}
	
	@RequestMapping(value="pollmake.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String pollmake(Model model) {
		model.addAttribute("doc_title", "투표만들기");
		return "pollmake.tiles";
	}
	
	@RequestMapping(value="pollmakeAf.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String pollmakeAfter(PollBean pbean) {
		service.makePoll(pbean);
		return "redirect:/polllist.do";
	}
	
	@RequestMapping(value="polldetail.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String polldetail(PollDto poll, Model model) { //pollid가 넘어옴 dto 로 넘겨받기
		model.addAttribute("doc_title", "투표내용");
		PollDto dto = service.getPoll(poll); //질문
		List<PollSubDto> list = service.getPollSubList(poll); //보기
		
		model.addAttribute("poll", dto);
		model.addAttribute("pollsublist", list);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		return "polldetail.tiles";
	}
	
	@RequestMapping(value="polling.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String polling(Voter voter) {
		service.polling(voter);
		return "redirect:/polllist.do";
	}
	
	@RequestMapping(value="pollresult.do",  method= {RequestMethod.GET, RequestMethod.POST})
	public String pollResult(PollDto poll, Model model ) { //pollid 넘겨받아야함 dto로받음
		model.addAttribute("doc_title", "투표결과");
		PollDto dto = service.getPoll(poll); //polltotal을 가져오기 위함
		List<PollSubDto> list = service.getPollSubList(poll); //acount
		
		model.addAttribute("poll", dto);
		model.addAttribute("pollsublist", list);
		return "pollresult.tiles";
		
	}
}