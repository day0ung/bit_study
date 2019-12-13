package dao;

import java.util.Scanner;

import dto.Batter;
import dto.Human;
import dto.Pitcher;
import single.Singleton;

public class InsertClass implements DaoInterface{
	
	private int MemNumber;
	
	
	public InsertClass() {
		MemNumber = 1000; //생성이된다음에 들어오기때문에 인서트다음에 파일생성하면됨
		Singleton s = Singleton.getInstance();
		System.out.println("s.map.size() = " + s.map.size());
		if(s.map.size() >0) {
			MemNumber = s.MemNumber;
			System.out.println("MemNumber = " + MemNumber);
		}
	}
	
	public void process() { //실제처리하는메소드
		Scanner sc = new Scanner(System.in);
		System.out.println("===>>선수등록<<===");
		System.out.println("투수(1)/ 타자(2) ");
		System.out.print("번호입력>>> ");
		int choice = sc.nextInt(); 
		
		Human human = null;// map에다 넣기 위함
		
		//human
		System.out.print("이름: "); //number는 우리가 지정해주는것임
		String name = sc.next();
		
		System.out.println("나이: ");
		int age = sc.nextInt();
		
		System.out.println("신장: ");
		double height = sc.nextDouble();
		
		if(choice ==1) { //pitcher
			System.out.print("승: "); 
			int win = sc.nextInt();
			
			System.out.print("패: ");
			int lose = sc.nextInt();
			
			System.out.print("방어율: ");
			double defence = sc.nextDouble();
			
			human = new Pitcher(MemNumber, name, age, height, win, lose, defence);
			
		}else { //batter
			System.out.print("타수: "); 
			int batcount = sc.nextInt();
			
			System.out.print("안타수: ");
			int hit = sc.nextInt();
			
			System.out.print("타율: ");
			double hitAvg = sc.nextDouble();
			
			 human = new Batter(MemNumber +1000, name, age, height, 
					 batcount, hit, hitAvg); 
		}
		Singleton s = Singleton.getInstance();
		//map에 추가
		s.map.put(human.getName(), human); 
		MemNumber++;
	}
}
