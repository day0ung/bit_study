package bit.com.a.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.model.MemberDto;
import bit.com.a.model.Youtube;
import bit.com.a.model.YoutubeSave;
import bit.com.a.service.BitYoutubeService;
import bit.com.a.util.YoutubeParser;

@Controller
public class BitYoutubeController {

	@Autowired
	private YoutubeParser youtubeParser;
	
	@Autowired
	private BitYoutubeService service;
	
	@RequestMapping(value = "yutube.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String yutube(String s_keyword, Model model) {
		model.addAttribute("doc_title", "Youtube");
		
		if(s_keyword != null && !s_keyword.equals("")) {
			
			ArrayList<Youtube> getTitles = youtubeParser.getTitles(s_keyword);
			
			model.addAttribute("yulist", getTitles);
			model.addAttribute("s_keyword", s_keyword);			
		}
		return "yutube.tiles";
	}
	
	@ResponseBody
	@RequestMapping(value = "youtubesave.do", method= {RequestMethod.GET, RequestMethod.POST})
	public YoutubeSave youtubesave(YoutubeSave y) {
		service.writeYoutube(y);
		YoutubeSave ysave = service.getYoutube(y);
		
		return ysave;
	}
	
	@RequestMapping(value="youtubelist.do")
	public String youtubeSaved(Model model, HttpServletRequest req ) {
		model.addAttribute("doc_title", "유튜브 저장내역");
		String id = ((MemberDto)req.getSession().getAttribute("login")).getId();
		List<YoutubeSave> list = service.getYoutubeSave(id);
		model.addAttribute("list", list);
		
		return "youtubesave.tiles";
	}
	
	@ResponseBody
	@RequestMapping(value = "youtubedelte.do", method= RequestMethod.POST)
	public void youtubedelete(YoutubeSave y) {
		service.deleteYoutube(y);
	
	}
	
	
}
