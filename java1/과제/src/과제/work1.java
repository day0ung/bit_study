package 과제;
//두 점 (x,y)와 (x1,y1)간의 거리를 구한다.
public class work1 {
public static void main(String args[]) {
		double dis = getDistance(1, 1, 2, 2);
		System.out.println(dis);
		
		
	}


	static double getDistance(int x, int y, int x1, int y1) {
		/*
		
		 * (1) 알맞은 코드를 넣어 완성하시오.
		 
		double a = Math.pow(y1 - y,2);
		double b = Math.pow(x1 -x, 2);
		int result = (int)(Math.sqrt(a+b));
		
		return result;
		*/
		return Math.sqrt(Math.pow(x1 -1,2) + Math.pow(y1 - y, 2));
		
		
	}

}

