 package awtSample01;

import javax.swing.JFrame;

public class WindowTestJ extends JFrame {
	//윈도우리스너킬필요없음
	
	public WindowTestJ() {
		setSize(800, 600);
		setLocation(100, 0);
		
		setVisible(true);
		
		//윈도우끌때
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
