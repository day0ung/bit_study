package dao;

import java.util.Scanner;

import dto.Batter;
import dto.Human;
import dto.Pitcher;
import single.Singleton;

public class UpdateClass implements DaoInterface{
	public UpdateClass() {
		
	}
	@Override //namespace(있어도되고 없어도됨)
	public void process() {
		Scanner sc = new Scanner(System.in);
		Singleton s = Singleton.getInstance();
		System.out.println("수정하고 싶은 선수명을 입력해주십시오");
		System.out.print(">>");
		String name = sc.next();
		
		Human h = null;
		h = s.map.get(name);
		
		if(h == null || h.getName().equals("")) {
			System.out.println("데이터를 찾을 수 없습니다.");
			return; //못찾고 튀어나감
		}
		System.out.println("수정할 데이터를 입력해주십시오");
		if(h.getNumber()< 2000) { //2000번보다 작으면 투수
			Pitcher p = (Pitcher)h; //변환
			System.out.print("승: ");
			int win = sc.nextInt();
			
			System.out.print("패: ");
			int lose = sc.nextInt();
			
			System.out.print("방어율: ");
			int defence = sc.nextInt();
			
			p.setWin(win);
			p.setLose(lose);
			p.setDefence(defence);
			
		}else {//타자
			Batter b = (Batter)h;
			System.out.print("타수: ");
			int batcount = sc.nextInt();
			
			System.out.print("안타: ");
			int hit = sc.nextInt();
			
			System.out.print("방어율: ");
			double hitAvg = sc.nextDouble();
			
			b.setBatcount(batcount);
			b.setHit(hit);
			b.setHitAvg(hitAvg);
			
		}
		System.out.println("데이터를 수정하였습니다.");
	}
}
