package bit.com.a.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint; //maven에서 추가한 부분
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import bit.com.a.model.MemberDto;

@Aspect
public class LogAOP {
	///aop란? 다수의 여러작업이 공통된것을 한군데에다 모아놓은것 
	@Around("within(bit.com.a.controller.*)")// or within(bit.com.a.dao.*)")
	public Object loggerAOP(ProceedingJoinPoint joinpoint) throws Throwable{
		String signatureStr = joinpoint.getSignature().toShortString();
		
		//session check
		HttpServletRequest request
		= ( (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes() ).getRequest(); //request를 얻어올수 있음
		
		if(request != null) { //로그인한 다음
			HttpSession session = request.getSession();
			MemberDto login = (MemberDto)session.getAttribute("login");
			if(login == null) {
				return "redirect:/sessionOut.do";
			}
		}
		
		
		Object obj = joinpoint.proceed(); //기능실행 : 지정하게될 함수가 호출됫을때 joinpoint가 호출된다,
		System.out.println("loggerAOP:" + signatureStr + "메소드 호출");
		
		return obj;
		
	}
}
