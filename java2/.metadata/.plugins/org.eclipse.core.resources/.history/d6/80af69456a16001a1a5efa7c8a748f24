package dao;

import java.util.Scanner;

import java.util.Iterator;

import dto.Batter;
import dto.Human;
import dto.Pitcher;
import singleton.Singleton;

public class Insert {
	Scanner scan = new Scanner(System.in);

	private int memberNum;	
	
	public Insert() {
		memberNum = 1000;		
	}
	
	public void input() {
		Human human = null;
		System.out.println("===>>선수등록<<===");
		System.out.println("투수(1)/ 타자(2) ");
		System.out.print("번호입력>>> ");
		int choice = scan.nextInt();
		
		System.out.print("이름: ");
		String name = scan.next();
		
		System.out.print("나이: ");
		int age = scan.nextInt();
		
		System.out.print("신장: ");
		double height = scan.nextDouble();
		
		System.out.print("생일: ");
		String birth = scan.next();
		
		if(choice == 1) {
			System.out.print("승: ");
			int win = scan.nextInt();
			System.out.print("패: ");
			int lose = scan.nextInt();
			System.out.print("방어율: ");
			double defense = scan.nextDouble();
			human = new Pitcher(memberNum, name, age, height, birth, win, lose, defense);
		}
		else {
			System.out.print("타수: ");
			int bat = scan.nextInt();
			System.out.print("안타: ");
			int hit = scan.nextInt();
			System.out.print("타율: ");
			double batAvg = scan.nextDouble();
			human = new Batter(memberNum+1000, name, age, height,birth, bat, hit, batAvg);
		}
		Singleton sin = Singleton.getInstance();
		sin.map.put(human.getName() , human);
		
		memberNum++;
		
		allprint();
	}
	
	public void allprint() {
		Singleton sin = Singleton.getInstance();
		
		Iterator<String> it = sin.map.keySet().iterator();
		
		while(it.hasNext()) {
			String key =it.next();
			Human h = sin.map.get(key); //휴먼데이터가나옴
			System.out.println(h.toString()); //피처건배터건 상속받은부분의 toString이 나옴
		}
	}
}


