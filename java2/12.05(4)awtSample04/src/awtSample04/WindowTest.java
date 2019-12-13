package awtSample04;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowTest extends Frame implements WindowListener {
	
	public WindowTest() {
		
		//Panel == 종이위에 종이
		setLayout(new GridLayout(2, 1)); //위아래로 2칸(열)
		
		//label추가 ->위부분
//		Label label = new Label("label");
//		add(label);
		
		//레이블대신에 외부(myPanel)에서 작성한것을 불러옴
		myPanel myP = new myPanel();
		add(myP);
		
		
		//panel ->아래부분
		Panel panel = new Panel();
		panel.setBackground(Color.GRAY);
		panel.setLayout(new GridLayout(1, 2));
		add(panel);
		
		Label label1 = new Label("label 1");
		panel.add(label1);
		
		Button button = new Button("button");
		panel.add(button);
			
		
		setSize(640, 480);
		setLocation(0,0);
		
		setVisible(true);
		
		addWindowListener(this);
	}
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0);

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

}