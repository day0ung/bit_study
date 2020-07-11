package bit.com.a.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.model.BbsDto;
import bit.com.a.model.BbsParam;
import bit.com.a.service.BbsService;

@RestController
public class BbsController {
	
	@Autowired
	BbsService service;
	
	@RequestMapping(value="/getBbsPageList", method=RequestMethod.GET)
	public List<BbsDto> getBbsPageList(BbsParam param){
		System.out.println("BbsCntroller get BbsPageList()");
		System.out.println(param.toString());
		
		//페이지 넘버를 구하기 위함
		 int sn = param.getPageNumber() -1; //0 1 2 
		 int start = sn*param.getRecordCountPerPage() +1; //1, 11 시작페이지가 1부터인지 11부터인지
		 
		 int end = (sn+1) * param.getRecordCountPerPage(); //10 20
		 
		 param.setStart(start);
		 param.setEnd(end);
		 
		 List<BbsDto> list = service.getBbsList(param);
		 return list;
	}
	
	@RequestMapping(value="/getBbsCount", method=RequestMethod.GET) //글의 총수만 가져오면됨
	public int getBbsCount(BbsParam param) {
		System.out.println("BbsController getBbsPageList()");
		
		int len = service.getBbsCount(param);
		return len;
	}
	
	@RequestMapping(value="/writeBbs",  method=RequestMethod.GET)
	public String writeBbs(BbsDto dto ) {
		System.out.println("bbsController writeBbs()");
		System.out.println(dto.toString());
		boolean b = service.writeBbs(dto);
		if(b == true) {
			return "success";
		}else {
			return "fail";			
		}
	}
	
	@RequestMapping(value="/updateBbs", method=RequestMethod.POST)
	public String updateBbs(BbsDto dto ) {
		System.out.println("Controller updateBbs()");
		boolean b = service.updateBbs(dto);
		return "";
	}
	
	@RequestMapping(value="/deleteBbs", method=RequestMethod.POST)
	public String deleteBbs(int seq ) {
		System.out.println("Controller deleteBbs()");
		boolean b = service.deleteBbs(seq);
		if(b == true) {
			return "success";
		}else {
			return "fail";			
		}
	}
	
	
	@RequestMapping(value="/getBbsDetail", method=RequestMethod.GET)
	public BbsDto detailBbs(int seq) {
		System.out.println("bbsController detaiulBbs");
		BbsDto dto =service.getBbs(seq);
		return dto;
	}
}
