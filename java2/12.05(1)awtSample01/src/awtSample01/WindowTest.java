package awtSample01;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowTest extends Frame implements WindowListener {
	public WindowTest() {
		super("간단한 예제"); //barTitle에 나옴
		//frame에서 상속받은메소드
		setSize(640, 480); // 윈도우의 크기(폭, 높이)
		setLocation(100, 0); //윈도우가 실행 위치(x오른쪽으로갈수록 늘어남, y 밑으로내려갈수록 늘어남)
		setVisible(true); // 윈도우 시각화
		
		addWindowListener(this); //스위치키는것, 윈도우리스너 (this)인스턴스값이 어디있는지적어주는것
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("windowClosed");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing");
		System.exit(0); //메인에서 실행해서 끄면 꺼짐
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("windowDeactivated");
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("windowDeiconified");
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("windowIconified");
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened");
		
	}
}