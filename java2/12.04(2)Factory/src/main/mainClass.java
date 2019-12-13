package main;

import java.util.ArrayList;
import java.util.List;

import animal.Animal;
import animal.Cat;
import animal.Cow;
import animal.Dog;
import factory.AnimalFactory;

public class mainClass {

	public static void main(String[] args) {
		/*
		  	(복습)Singleton Pattern 중요**
		  			중심이 되는 데이터관리 template(list, map)을 중심으로 
		  			어디서나 접근이 용이하게 하기 위한 패턴
		  			instance는 한개.
		    
		    Factory Pattern : 공장
		    	원하는 클래스의 형태를 생성하기 용이한 패턴이다.
		    
		    interface, class 동물 [부모]
		    class[자식] 	고양이, 멍멍이, 황소
		    
		    Animal a = new Cat();
		 */
		
		List<Animal> list  = new ArrayList<Animal>();
		Animal ani1 = AnimalFactory.creat("댕댕이");
		list.add(ani1);
		
		ani1 =  AnimalFactory.creat("냥이");
		list.add(ani1);
		
		ani1 = AnimalFactory.creat("황소");
		list.add(ani1);
		
		for (int i = 0; i < list.size(); i++) {
	         Animal a = list.get(i);
	         a.printDescript();
	         
	         if (a instanceof Cat) {
	            ((Cat)a).catMethod();
	         }
	         else if(a instanceof Cow) {
	            ((Cow)a).cowMethod();
	         }
	         else if(a instanceof Dog) {
	            ((Dog)a).dogMethod();
	         }
	      }

	}

}
