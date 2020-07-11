package bit.com.a.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.model.MemberDto;
import bit.com.a.service.MemberService;

@RestController //Controller를 쓰면 mvc패턴을 사용하게됨  boot에서는 RestController?ㅇ를 사용해야함, 뭐하나가 빠짐
//restController -> controller + responsebody(Ajax) ->restful 방식
public class HelloController {
	//service 추가
	@Autowired
	MemberService service;
	
	//외부에서 요청하면 대답만해준다. 
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String test() throws Exception{
	//여기서 String은 view로 가는것이 아님
		System.out.println("test()");
		return "test";
	}
	
	@RequestMapping(value="/member", method=RequestMethod.GET)
	public MemberDto getMember() throws Exception{
		System.out.println("getMember()");
		MemberDto dto = new MemberDto("아이디", "비밀번호", "이름" , "이메일", 3);
		
		return dto;
	}
	
	@RequestMapping(value="/dbtest", method=RequestMethod.GET)
	public List<MemberDto> dbtest() throws Exception{
		System.out.println("dbtest");
		
		List<MemberDto> list = service.allMember();
		return list;
	}
	
	@RequestMapping(value="/conn_param", method=RequestMethod.GET)
	//vue에서 받는 데이터 conn_param에서 title이라는 ket값을 받아와야함
	public String conn_param(String title) {
		System.out.println("conn_param()");
		System.out.println("title:" + title);
		
		return "conn success";
	}
	
	@RequestMapping(value="/conn_post_param", method=RequestMethod.POST)
	//vue에서 받는 데이터 conn_param에서 title이라는 ket값을 받아와야함
	public String conn_post_param(String title, String content) {
		System.out.println("conn_post_param()");
		System.out.println("title:" + title);
		System.out.println("content:" +content);
		
		return "통신 post success";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getid")
	public String getId(String id){
		System.out.println("MemberController getId()");
		
		int count = service.getId(id);
		if(count > 0) {
			return "NO";
		}else {
			return "YES";
		}
	}
	
	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public String account(MemberDto dto) {		
		System.out.println(dto.toString());
		
		boolean b = service.addmember(dto);
		if(b) {
			System.out.println("회원가입되었습니다 " + new Date());
			return "YES";
		}
		return "NO";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public MemberDto login(MemberDto dto) {
		System.out.println("멤버 컨트롤러login");
		System.out.println(dto.toString());
		
		MemberDto mem = service.login(dto);
		return mem;
	}
}
