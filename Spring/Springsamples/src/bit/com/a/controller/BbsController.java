package bit.com.a.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	@RequestMapping(value = "bbslist.do", method= {RequestMethod.GET,RequestMethod.POST} )
	public String bbslist(Model model, BbsParam param) {
		/* layouts-tiles.jsp의  ${doc_title } 만들어주기 위함 */
		model.addAttribute("doc_title", "글목록");
		
		//paging 처리
		int sn = param.getPageNumber(); //0 1 2 현재페이지
		int start = sn * param.getRecordCountPerPage() +1; //0이들어왔을때 0이 되서  10 이 됨 //+1을 해서 1인지 11인지 
		int end = (sn+1) *param.getRecordCountPerPage(); //10 20 30이 나옴
		
		param.setStart(start);
		param.setEnd(end);
		List<BbsDto> list = bbsService.getBbsList(param);
		
		//글의 총 수
		int totalRecordCount = bbsService.getBbsCount(param);
		model.addAttribute("bbslist", list);
		model.addAttribute("pageNumber", sn);
		model.addAttribute("pageCountPerScreen", 10);
		model.addAttribute("recordCountPerPage", param.getRecordCountPerPage());
		model.addAttribute("totalRecordCount", totalRecordCount);
		
		
		return "bbslist.tiles";
	}
	
	@RequestMapping(value= "bbswrite.do")
	public String bbsWrite(Model model) {
		model.addAttribute("doc_title", "글쓰기");
		return "bbswrite.tiles";
	}
	
	
	@RequestMapping(value= "bbswriteAf.do")
	public String bbsWriteAf( BbsDto bbs ) {
		boolean b= bbsService.writeBbs(bbs);
		if(b == false) {
			return "bbslist.tiles";	
		}else {
			return "redirect:/bbslist.do";
		}
	}
	
	@RequestMapping(value="bbsdetail.do")
	public String bbsDetail(HttpServletRequest req, Model model) {
		model.addAttribute("doc_title", "글 상세보기");
		String sseq = req.getParameter("seq");
		int seq = Integer.parseInt(sseq);
		BbsDto dto = bbsService.getBbs(seq);
		model.addAttribute("dto", dto);
		return "bbsdetail.tiles";
	}
	
	@RequestMapping(value="bbsupdate.do")
	public String bbsUpdate(BbsDto bbs, Model model) {
		model.addAttribute("doc_title", "글 수정하기");
		model.addAttribute("bbs", bbs);
		return "bbsupdate.tiles";
	}
	
	@RequestMapping("bbsupdateAf.do")
	public String bbsUpdateAf(BbsDto bbs, Model model) {
		boolean b = bbsService.updateBbs(bbs);
		if(b == false) {
			return "bbsupdate.tiles";
		}else {
			return "redirect:/bbslist.do";			
		}
	}
	
	@RequestMapping("bbsdelete.do")
	public String bbsDelete(BbsDto bbs) {
		boolean b = bbsService.deleteBbs(bbs);
		return "redirect:/bbslist.do";	
	}
	
	@RequestMapping("bbsReply.do")
	public String bbsRepley(BbsDto bbs) {
		return "";
	}
}







