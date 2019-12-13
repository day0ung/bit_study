package main;

import java.util.ArrayList;
import java.util.List;


import person.Person;
import types.Atype;
import types.Btype;

public class mainClass {
	public static void main(String[] args) {
		//메인에서는 person 생성
		
		Person human1 = new Person();
		//캐릭터가 어떻게 만들어지는가? person에 creat메소드가 있었음, abitem은 atype과 btype으로 나눠줘 있음
		human1.create(new Btype()); //human1은 총과 다이나마이트가 생성됨
	//	human1.m_Weapon.drawWeapon();
	//	human1.m_Bomb.drawBomb();
		human1.getM_Weapon().drawWeapon();
		human1.getM_Bomb().drawBomb();
		//객체가 여러개로나눠져있을때 그중에서 옵션으로 고르는것 
		
		
		//----과제 리스트로 만들어서 출력
		System.out.println("----과제 리스트로 만들어서 출력----");
		List<Person> list = new ArrayList<Person>();
		Person p1 =  new Person();
		p1.create(new Btype());
		
		Person p2 = new Person();
		p2.create(new Btype());
		
		Person p3 = new Person();
		p3.create(new Atype());
		
		Person p4 = new Person();
		p4.create(new Btype());
		
		Person p5 = new Person();
		p5.create(new Atype());
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		
		for (int i = 0; i < list.size(); i++) {
			Person p = list.get(i);
			p.m_Bomb.drawBomb();
			p.m_Weapon.drawWeapon();
	
		}
	}
}
