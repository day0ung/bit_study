package awtSample01;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowTest1 implements WindowListener {
	//extens에서 frame상속안받음, 생성해서 하기
	public WindowTest1() {
	
		Frame frame = new Frame();
		
		frame.setTitle("제목");
		frame.setSize(640, 480);
		frame.setLocation(100, 100);
		frame.setBackground(Color.DARK_GRAY);
		frame.setVisible(true);
		
		frame.addWindowListener(this);
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
