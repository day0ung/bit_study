package awtSample03;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowTest extends Frame implements WindowListener {

	public WindowTest() {
		super("layout");
		
//		setLayout(new FlowLayout());
//		setLayout(new GridLayout(3, 1)); //첫번째칸엔 레이블 , 두번째칸에 레이블 세번칸에 버튼
		setLayout(null); //사용안하겠다 >> 위치 잡아줘야함
		
		//label1
		Label label1 = new Label("레이블 1 입니다");
		label1.setBackground(new Color(255, 0, 0));
		label1.setSize(150, 30); //레이블의 폭과 높이
		label1.setLocation(100,100);
		add(label1);
		//label2
		Label label2 = new Label("레이블 2 입니다");
		label2.setBackground(new Color(0, 255, 0));
		label2.setBounds(100, 200, 200, 100); //앞에 두개숫자는 위치, 뒤는 넓이
		add(label2);
		
		Button button = new Button();
		button.setLabel("버튼");
		button.setBounds(100,350,200, 100);
		add(button);
		
		
		setBounds(0, 0, 640, 480);
		setVisible(true);
		
		addWindowListener(this);
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}