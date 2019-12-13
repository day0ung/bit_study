
public class mainClass {
	public static void main(String[] args) {
		/*
		//1. 셔플 첫번째 방법
		int number[] = new int [10]; // 1 ~ 10
		
	
		//초기화
		for (int i = 0; i < number.length; i++) {
			number[i] = i + 1; //1~10까지 숫자를 집어넣는 것
		}
		
		//swap을 사용 하여 셔플
		int temp;
		for (int i = 0; i < 1000; i++) {
			int a = (int)(Math.random()*10);  //for문안에서 랜덤선언
			int b = (int)(Math.random()*10);  //0 ~ 9
			
			temp = number[a]; //인덱스값이용하는것
			number[a] = number[b];
			number[b] = temp;
		}
		
		for (int i = 0; i < number.length; i++) {
			System.out.println(number[i] + " ");
		}
		System.out.println();
		*/
		
		//2.셔플 두 번째방법
		int number[] = new int[10];
		//갯수에 맞춰서 껏다켰다 할 수 있는 스위치준비
		boolean _switch[] = new boolean[10];
		
		int w,r;
		
		//System.out.println(_switch[0]); //이미false 지만 게임을다시 하게될경우를 생각해야함
		//boolean false로 초기화하는 작업
		for (int i = 0; i < _switch.length; i++) {
			_switch[i] =false;
		}
		
		w =0; //아래 if문을 계속 돌리기 위해서 while작성, while w초기화는 while문 위에다가 하는것이좋다
		while(w < 10) { // while이  0~9이기 떄문에 number[0] ->number[w] 로바꿈
		r = (int)(Math.random()*10); //0 ~ 9
		//조사
		if(_switch[r] == false) {
			_switch[r] = true;  // f 를 true로 바꾸세요
			number[w] = r + 1; // 1~ 10
			w++;
			}
		}
		
		for (int i = 0; i < number.length; i++) {
			System.out.print(number[i] + " ");
		}
		System.out.println();
	}

}
