package com.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.dto.Cat;

public class MainClass {
	public static void main(String[] args) {
		//Java에서 xml실행시
		AbstractApplicationContext ctx
			= new GenericXmlApplicationContext("bean.xml"); //경로명
		
		//bean.xml의 mycat 가져오기
		Cat mycat = ctx.getBean("myCat",Cat.class);
		mycat.catInfomation();
		
		System.out.println(mycat.getName());
		
		
	}
}
