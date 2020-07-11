package bit.com.a.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bit.com.a.model.CalParam;
import bit.com.a.model.CalendarDto;
import bit.com.a.model.MemberDto;
import bit.com.a.service.BitCalendarService;
import bit.com.a.util.CalendarUtil;

@Controller
public class BitCalendarController {

	@Autowired
	BitCalendarService service;
	
	@RequestMapping(value = "calendarlist.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String calendarlist(Model model, CalParam jcal, HttpSession session) {
		model.addAttribute("doc_title", "일정");
		
		jcal.calculate();
		
		// id 취득
		String id = ((MemberDto)session.getAttribute("login")).getId();
		// 날짜 취득
		String yyyymm = CalendarUtil.yyyymm(jcal.getYear(), jcal.getMonth());
		
		CalendarDto fcal = new CalendarDto();
		fcal.setId(id);
		fcal.setRdate(yyyymm);
		
		List<CalendarDto> list = service.getCalendarList(fcal);
		
		model.addAttribute("flist", list);
		model.addAttribute("jcal", jcal);
		
		return "calendar.tiles";
	}
	
	//글쓰기
	@RequestMapping("calwrite.do")
	public String calWrite(Model model, CalParam jcal) {
		model.addAttribute("doc_title", "일정쓰기");
		
		jcal.calculate();
		model.addAttribute("jcal", jcal);
		return "calwrite.tiles";
	}
	
	@RequestMapping("calwriteAf.do")
	public String calWriteAf(CalendarDto dto, Model model) {
		boolean b = service.addSchedule(dto);
		if(b == false) {
			return "calwrite.tiels";
		}else {
			return "calendar.tiles";
		}
		
	}
	
}







