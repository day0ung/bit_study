package com.aop;

import org.aspectj.lang.ProceedingJoinPoint; //maven에서 추가한 부분

//aop를 심어놔서 어떤특정순간이 되면 자동호출되도록 만들어 놓음
//application쪽에서는 callback함수라고 한다. : callback = 자동호출, pl에서 트리거 랑 비슷한 개념
public class LogAOP {
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
