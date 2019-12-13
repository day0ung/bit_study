package oopExStarCraft;

import java.util.Stack;

import child.Marin;
import child.Race;
import child.Tank;
import parent.StarCraft;

public class mainClass {
	public static void main(String[] args) {
		//unit 30
		//어떤사람은 마린을더많이, 비행기를더많이쓸수도있다.
		//선택의폭을 넓혀야함
		//아래는 지정되어있는것임 왔다갔다할수없음
		Marin m[] = new Marin[10];
		Race r[] = new Race[10];
		Tank t[] = new Tank[10];
		
		
		//위의것과의 차이점
		//유동적임, 마린만다들어갈수있음
		StarCraft starArr[] = new StarCraft[5];
		starArr[0] = new Marin(); 
		starArr[1] = new Tank(); 
		starArr[2] = new Marin(); 
		starArr[3] = new Tank(); 
		starArr[4] = new Tank();
		
		//Over Ride된 메소드 라이프를 보기위해서 for
		//위의것과 맞춰서 알아서 출력해줌
		for (int i = 0; i < starArr.length; i++) {
			starArr[i].life();
		}
		
		//instanceOf 인스턴스를 분별해주는것, 객체를판별해주는 예약어		
		for (int i = 0; i < starArr.length; i++) {
			StarCraft sc = starArr[i]; //StarCraft sc부모클래스 인스턴스
			if(sc instanceof Marin) {//너마린이니하고물어보는것 
				Marin ma = (Marin)sc;
				ma.run();
				
			//((Marin)sc).run(); 동일한 코드
			} else if (sc instanceof Race) {
				Race ra = (Race) sc;
				ra.fly();
			} else if (sc instanceof Tank) {
				Tank ta = (Tank) sc;
				ta.canon();
			}
		}
		//자식클래스를다모아서 부모클래스인스턴스로관리할수있다.
		
				
	}

}
