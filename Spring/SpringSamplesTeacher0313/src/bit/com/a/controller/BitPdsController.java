package bit.com.a.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import bit.com.a.model.PdsDto;
import bit.com.a.service.PdsService;
import bit.com.a.util.FUpUtil;

@Controller
public class BitPdsController {
	@Autowired
	PdsService service;
	
	@RequestMapping(value="pdslist.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String pdsList(Model model) {
		model.addAttribute("doc_title", "자료실 목록");
		List<PdsDto> list = service.getPdsList();
		
		model.addAttribute("pdslist", list);
		return "pdslist.tiles";
	}
	
	@RequestMapping(value="pdswrite.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String pdswrite(Model model) {
		model.addAttribute("doc_title", "자료올리기");
		
		return "pdswrite.tiles";
	}
	
	@RequestMapping(value="pdsupload.do",method=  RequestMethod.POST) // required = false 캐시에 관한것, 저장을 하겠느냐 이런것
	public String pdsupload(PdsDto pdsdto, //form에 있는것
				@RequestParam(value = "fileload", required = false)MultipartFile fileload, //파일
				HttpServletRequest req) { //서버경로를 취득하기 위해서 필요한것) 
		//filename취득
		String filename= fileload.getOriginalFilename(); //실제파일이름
		pdsdto.setFilename(filename);
		
		//upload경로 설정
		//tomcat 서버에 올리는 경로
		String fupload = req.getServletContext().getRealPath("/upload"); //webcontent폴더에 만들어놓은 폴더명
		//folder에 올리는 경로
		//String fupload = "d:\\tmp";
		System.out.println("컨트롤러의 fupload:"+ fupload); //업로드 위치
		
		//file명을 변경
		String f = pdsdto.getFilename();
		String newFileName = FUpUtil.getNewFileName(f);
		
		pdsdto.setFilename(newFileName);
		
		File file = new File(fupload + "/" + newFileName);
		
		try {
			//실제 파일 업로드되는 부분 try/catch
			FileUtils.writeByteArrayToFile(file, fileload.getBytes());
			
			//DB 저장
			service.uploadPds(pdsdto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/pdslist.do";
	}
	
	@RequestMapping(value= "pdsdetail.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String pdsdetail(int seq, Model model) {
		model.addAttribute("doc_title", "자료보기");
		//readcount
		
		//dto 취득
		PdsDto pdsdto = service.getPds(seq);
		model.addAttribute("pds", pdsdto);
		return "pdsdetail.tiles";
	}

	@RequestMapping(value= "fileDownLoad.do", method= {RequestMethod.GET, RequestMethod.POST})
	String fileDownLoad(String filename, int seq, HttpServletRequest req, Model model) {
		//download경로
		//tomcat
		String fupload = req.getServletContext().getRealPath("/upload");
		
		//폴더경로
		//String fupload = "d:\\tmp";
		File downloadFile = new File(fupload+"/"+filename);
		model.addAttribute("downloadFile", downloadFile);
		model.addAttribute("seq", seq);
		return "downloadView"; //servlet-context.xml에다가 생성해놓은 클래스 //다운로드뷰안에 renderMergedOutputModel sysout에서 확인할수 있음
		
	}

}
