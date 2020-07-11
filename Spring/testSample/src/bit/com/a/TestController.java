package bit.com.a;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@가 붙는것은 무조건 annotation에 해당됨
public class TestController {
	//src에 추가한 log4j.xml import >> org.slf4j.Logger;를 사용함
	private static Logger logger = LoggerFactory.getLogger(TestController.class);
	
	//requestMapping = @Webservlet같은느낌
	@RequestMapping("hello") //GET방식
	public ModelAndView hello() {
		//System.out.println("TestController안의 hello()함수 호출");
		logger.info("TestController hello()" + new Date());
		
		//ModelAndView hello.jsp로 가라
		ModelAndView view = new ModelAndView();
		view.setViewName("hello");
		return view;
	}	
										//둘다 사용{RequestMethod.GET,  RequestMethod.POST}
	@RequestMapping(value="home", method = RequestMethod.GET)
	public String home(Model model, Locale locale) { //Model  -> Obejct데이터 전송용
		//System.out.println("TestController의 home()함수 호출");
		
		logger.info("TestController home()" + new Date());
		//콘솔에 출력됨 빨간글씨로 logger
		//[http-nio-8090-exec-5] INFO bit.com.a.TestController - TestController home()Mon Feb 24 13:00:14 KST 2020
		
		
		Date date = new Date(); //현재시간과 날짜를 얻어옴
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale); //형식지정
		
		//전송 하기 위해서 string
		String formattedDate = dateFormat.format(date);
		
		//짐싸!! spring은 model을 사용하여 짐을 싼다
		model.addAttribute("serverTime", formattedDate);
		//위의함수는 modelandVeiw를 통해서 이동시켜줌,
		return "home";
	}
	
	
	
}
