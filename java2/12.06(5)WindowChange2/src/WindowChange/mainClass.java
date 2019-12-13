package WindowChange;

public class mainClass {

	public static void main(String[] args) {
		/*
		  2.visible
		     flase(보이게    true(안보이게)
		     
		     1, 2번방법은 윈도우를 끈다음에 다시키는것,,,
		  
		  3.  frame -> panel심어놓고 패널만 체인지 하는것임
		       change는 맞는데 윈도우체인지가아님,  프레임하나만들어서 패널만바꾸면됨
		       panel2 <-> panel2		  	
		 */
		Singleton.getInstance().win1.setVisible(true); //싱글턴을통해서 win1켜준것임
		//버튼누르면 win1을 false로 만들어야함 버튼에서 싱글턴클래스얻어와야함
		Singleton s = Singleton.getInstance();
		

	}

}
