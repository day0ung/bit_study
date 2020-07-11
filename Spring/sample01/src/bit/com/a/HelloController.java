package bit.com.a;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	private static Logger logger = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping("hello")	// GET
	public String hello() {
		logger.info("TestController hello " + new Date());
		
		return "hello";
	}
}
