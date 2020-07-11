package bit.com.a.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bit.com.a.model.BbsDto;
import bit.com.a.model.BbsParam;
import bit.com.a.service.BbsService;

@Controller
public class BbsController {	
	private static Logger logger = LoggerFactory.getLogger(BbsController.class);

	@Autowired
	BbsService bbsService;
	/*
	@RequestMapping(value = "bbslist.do", method=RequestMethod.GET)
	public String bbslist(Model model) {
		logger.info("BbsController bbslist " + new Date());
		
		List<BbsDto> list = bbsService.getBbsList();
		model.addAttribute("bbslist", list);
		
		return "bbslist";
	}
	*/
	@RequestMapping(value = "bbslist.do", method=RequestMethod.GET)
	public String bbslist(Model model, BbsParam param) {
		logger.info("BbsController bbslist " + new Date());
		
		List<BbsDto> list = bbsService.getBbsList(param);
		model.addAttribute("bbslist", list);
		
		return "bbslist";
	}
	
	@RequestMapping(value = "bbswrite.do", method = {RequestMethod.GET,	RequestMethod.POST})
	public String bbswrite(Model model) {
		logger.info("BbsController bbswrite "+ new Date());		
		return "bbswrite";
	}
	
	@RequestMapping(value = "bbswriteAf.do", method = RequestMethod.POST)
	public String bbswriteAf(BbsDto bbs, Model model) {
		logger.info("BbsController bbswriteAf! "+ new Date());
		bbsService.writeBbs(bbs);
		return "redirect:/bbslist.do";
	}
	
	@RequestMapping(value = "bbsdetail.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String bbsdetail(int seq, Model model) {
		logger.info("BbsController bbsdetail! "+ new Date());
		BbsDto bbs=bbsService.getBbs(seq);
		model.addAttribute("bbs", bbs);
		return "bbsdetail";
	}
	
	@RequestMapping(value = "answer.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String answer(int seq, Model model) throws Exception {
		logger.info("BbsController answer! "+ new Date());
		BbsDto bbs = bbsService.getBbs(seq);
		model.addAttribute("_bbs", bbs);
		return "answer";
	}
	
	@RequestMapping(value = "answerAf.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String answerAf(BbsDto bbs, Model model) throws Exception {
		logger.info("BbsController answer! "+ new Date());
		bbsService.reply(bbs);		
		return "redirect:/bbslist.do";
	}
	
}







