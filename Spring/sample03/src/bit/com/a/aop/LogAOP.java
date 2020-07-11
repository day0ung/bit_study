package bit.com.a.aop;

import org.aspectj.lang.ProceedingJoinPoint; //maven에서 추가한 부분
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

import bit.com.a.service.MemberService;

@Aspect
public class LogAOP {
	@Autowired
	//member가 한명도 없다, 특정멤버가 있느냐 없느냐 확인하고 싶을때
	MemberService memberService;
	
	@Around("within(bit.com.a.controller.*) or within(bit.com.a.dao.impl.*)") //or을 쓰면 2개더 필요하다
	public Object loggerAOP(ProceedingJoinPoint joinpoint) throws Throwable{
		String signatureStr = joinpoint.getSignature().toShortString();
		try {
		System.out.println("loggerAOP:" +signatureStr+"메소드가 실행되었습니다.");
		
		
		Object obj = joinpoint.proceed(); //기능실행 : 지정하게될 함수가 호출됫을때 joinpoint가 호출된다,
		return obj;
		}finally {		}
	}
}
