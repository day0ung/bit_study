package com.aop;

import org.aspectj.lang.ProceedingJoinPoint; //maven에서 추가한 부분
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LogAOP {
	
	@Around("within(com.dto.*)")
	public Object loggerAOP(ProceedingJoinPoint joinpoint) throws Throwable{
		String signatureStr = joinpoint.getSignature().toShortString();
		
		
		System.out.println(signatureStr+"시작");
		try {
		Object obj = joinpoint.proceed(); //기능실행 : 지정하게될 함수가 호출됫을때 joinpoint가 호출된다,
		
		
		return obj;
		}finally {
			System.out.println("실행 후"+ System.currentTimeMillis());
			System.out.println(signatureStr+"종료");
		}
	}
}
